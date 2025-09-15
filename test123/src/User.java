import java.util.HashSet;
import java.util.Set;

public class User {

    String id ;
    String name ;
    int score ;
    String department;
    Set<String> solvedProblem = new HashSet<>();

    public User(String  id, String name, String department) {
        this.id = id;
        this.name = name ;
        this.department = department;
    }



    public void addSolvedProblem(String problemId) {
        solvedProblem.add(problemId);
    }
}
