package service;

import enums.DifficultyLevel;
import exceptions.ProblemAlreadyExistException;
import exceptions.ProblemNotFoundException;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import models.Problem;
import models.ProblemFactory;
import models.User;
import models.UserFactory;

import java.util.*;
import java.util.stream.Collectors;

public class CompetitionPlatForm {

    private static CompetitionPlatForm competitionPlatForm;

    private final Map<String , User> userMap = new HashMap<>();

    private final Map<String, Problem> problemMap = new HashMap<>();


    private CompetitionPlatForm(){}

    public static synchronized CompetitionPlatForm getCompetitionPlatForm(){

        if(competitionPlatForm == null) competitionPlatForm = new CompetitionPlatForm();

        return competitionPlatForm;
    }

    public boolean addUser(String id , String name , String department){

        if(userMap.containsKey(id)) throw new UserAlreadyExistException("User already exist");

        userMap.put(id, UserFactory.createUSer(id, name , department));

        return true;
    }

    public boolean addProblem(String id , String description , String tag , DifficultyLevel difficulty , int score){

        if(problemMap.containsKey(id)) throw new ProblemAlreadyExistException("Problem already exist");

        problemMap.put(id, ProblemFactory.createProblem(id, description , tag , difficulty , score));

        return true;
    }


    // mark it as solve
    public boolean solve(String userId , String problemId , int timeTaken){
        User user = userMap.get(userId);
        Problem problem = problemMap.get(problemId);

        if(user==null )throw  new NoSuchElementException("user not found");

        if(problem==null )throw  new NoSuchElementException("Problem not found");

        user.solveProblem(problemId);
        problem.addSolver(userId , timeTaken);
        return true;
    }

    public List<Problem> fetchProblems(DifficultyLevel difficulty , String tag , ProblemSortStrategy sortStrategy){
        List<Problem> filtered = new ArrayList<>();

        for(Problem problem : problemMap.values()){
            boolean isDifficultyMatched = (difficulty==null || problem.getDifficulty().equals(difficulty));
            boolean isTagMatched = (tag==null || problem.getTag().equalsIgnoreCase(tag));

            if(isTagMatched && isDifficultyMatched)filtered.add(problem);
        }

        if(sortStrategy!= null)sortStrategy.sort(filtered);
        return filtered;
    }

    public int getNumberOfSolvers(String problemId){
        Problem problem = problemMap.get(problemId);
        if(problem==null) throw  new NoSuchElementException("Problem not found");
        return problem.getSolvedBy().size();
    }

    public double getAvgSolveTime(String problemId){
        Problem problem = problemMap.get(problemId);
        if(problem==null) throw new ProblemNotFoundException("Problem not found");
        return problem.getAverageSolveTime();
    }

    public Set<String> getSolvedProblemsByUser(String userId){
        User user = userMap.get(userId);

        if(user==null) throw new UserNotFoundException("User does not exist");

        return user.getSolvedProblems();

    }

    public List<String> getLeaderBoard(int size){
        Map<String , Integer> userScore = new HashMap<>();

        for(User user: userMap.values()){
            Set<String> solvedProblem = user.getSolvedProblems();
            int totalscore = 0 ;
            for(String id: solvedProblem){
                totalscore+=problemMap.get(id).getScore();
            }
            userScore.put(user.getId(), totalscore);
        }
        return userScore.entrySet().stream()
                .sorted((a,b)-> Integer.compare(b.getValue() , a.getValue()))
                .limit(size)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

    }



}
