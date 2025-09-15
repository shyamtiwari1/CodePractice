package models;

import enums.DifficultyLevel;

import java.util.*;

public class Problem {
    private final String id;
    private final String description ;
    private final String tag;
    private final DifficultyLevel difficulty;

    private final int score;
    private final Set<String> solvedBy = new HashSet<>();
    private final Map<String, Integer> solveTime = new HashMap<>();


    public Problem(String id , String description, String tag, DifficultyLevel difficulty , int score) {
        this.id = id ;
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;

    }



    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public Set<String> getSolvedBy(){
        return solvedBy;
    }
    public List<Integer> getSolveTime(){
        return solveTime.values().stream()
                .toList();
    }

    public void addSolver(String userId , int timeTaken){
        solvedBy.add(userId);
        solveTime.put(userId , timeTaken);
    }

    public double getAverageSolveTime() {
        return solveTime.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }



}
