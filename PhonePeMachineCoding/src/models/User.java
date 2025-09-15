package models;

import java.util.HashSet;
import java.util.Set;

public class User {


    private final String id ;
    private final String name ;
    private final String department ;





    private final Set<String> solvedProblems = new HashSet<>();


    public User(String id ,String name , String department){
        this.id = id ;
        this.name = name ;
        this.department = department;
    }


    public String getId() {
        return id;
    }


    public Set<String> getSolvedProblems() {
        return solvedProblems;
    }

    public void solveProblem(String problemId){
        solvedProblems.add(problemId);


    }
}
