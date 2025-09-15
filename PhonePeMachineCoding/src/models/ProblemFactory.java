package models;

import enums.DifficultyLevel;

public class ProblemFactory {

    public static Problem createProblem(String id , String description , String tag , DifficultyLevel difficulty , int score){
        return new Problem(id,description , tag , difficulty , score );
    }
}
