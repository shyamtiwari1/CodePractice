import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CompetitionPlatForm {

    private static CompetitionPlatForm competitionPlatForm;


    Map<String , User> userMap = new HashMap<>();

    Map<String , Problem> problemMap = new HashMap<>();


    public boolean addUser(String id , String name , String department){
        if(userMap.containsKey(id))throw new RuntimeException("user already exist");
        userMap.put(id, new User(id, name , department));
        return true;
    }

    public boolean addProblemr( String id , String description, String tag, Difficulty difficulty, int score ){
        if(problemMap.containsKey(id))throw new RuntimeException("Problem already exist");
        problemMap.put(id, new Problem(id, description ,tag , difficulty , score));
        return true;
    }
    // mark it as solve
    public boolean solve(String userId , String problemId , int timeTaken){
        User user = userMap.get(userId);
        Problem problem = problemMap.get(problemId);

        if(user==null)throw new RuntimeException("user does not exist");
        if(problem==null) throw  new RuntimeException("problem does not exist");

        user.addSolvedProblem(problemId);
        problem.addSolvedByUser(userId);

    }





}
