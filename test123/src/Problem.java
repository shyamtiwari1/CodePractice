import java.util.HashSet;
import java.util.Set;

public class Problem {
    String id ;
    String description;
    String tag;
    Difficulty difficulty;
    int score ;
    double avgTimeToSolve;

    Set<User> solvedBy ;


    public Problem(String id, String description, String tag, Difficulty difficulty, int score) {
        this.id = id;
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;
        this.solvedBy = new HashSet<>();
    }


    public Set<User> getSolvedBy() {
        return solvedBy;
    }
}
