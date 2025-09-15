import enums.DifficultyLevel;
import models.Problem;
import service.CompetitionPlatForm;
import service.SortByDescendingScore;
import service.SortByDifficulty;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CompetitionPlatForm competitionPlatForm = CompetitionPlatForm.getCompetitionPlatForm();
        competitionPlatForm.addUser("u1" , "user1" , "ComputerScience");
        competitionPlatForm.addUser("u2" , "user2" , "Electronics");
        competitionPlatForm.addUser("u3" , "user3" , "Civil");
        competitionPlatForm.addUser("u4" , "user4" , "Mathematics");
        competitionPlatForm.addUser("u5" , "user5" , "Mathematics");


        competitionPlatForm.addProblem("p1" , "House Robber" ,"DP" , DifficultyLevel.MEDIUM , 20 );
        competitionPlatForm.addProblem("p2" , "4 sum" ,"Array-Two pointer" , DifficultyLevel.HARD , 50 );
        competitionPlatForm.addProblem("p3" , "Leact common ancestor" ,"Tree" , DifficultyLevel.MEDIUM , 18 );
        competitionPlatForm.addProblem("p4" , "Find Duplicates" ,"Array" , DifficultyLevel.EASY , 10 );
        competitionPlatForm.addProblem("p5" , "Rotten Oranges" ,"Graph" , DifficultyLevel.MEDIUM , 30 );


        competitionPlatForm.solve("u1" , "p1" , 9 );
        competitionPlatForm.solve("u2" , "p1" , 5 );
        competitionPlatForm.solve("u3" , "p1" , 15 );
        competitionPlatForm.solve("u1" , "p3" , 12 );
        competitionPlatForm.solve("u4" , "p5" , 15 );
        competitionPlatForm.solve("u2" , "p2" , 22 );
        competitionPlatForm.solve("u5" , "p4" , 4 );
        competitionPlatForm.solve("u1" , "p5" , 13 );

        List<Problem> problemListByScore = competitionPlatForm.fetchProblems(null , null , new SortByDescendingScore());



        for(Problem problem :problemListByScore){
            System.out.println(problem.getId()+" Score: "+problem.getScore());
        }

        List<Problem> problemListByDifficulty = competitionPlatForm.fetchProblems(null , null , new SortByDifficulty());


        for(Problem problem :problemListByDifficulty){
            System.out.println(problem.getId()+" Difficulty: "+problem.getDifficulty().toString());
        }
        System.out.println("p1 solvers: "+ competitionPlatForm.getNumberOfSolvers("p1"));
        System.out.println("p1 avg solve time : "+ competitionPlatForm.getAvgSolveTime("p1"));
        System.out.println("Problem solved by u1: "+ competitionPlatForm.getSolvedProblemsByUser("u1"));


        System.out.println("p3 solvers: "+ competitionPlatForm.getNumberOfSolvers("p3"));
        System.out.println("p3 avg solve time : "+ competitionPlatForm.getAvgSolveTime("p3"));
        System.out.println("Problem solved by u2: "+ competitionPlatForm.getSolvedProblemsByUser("u2"));





    }
}