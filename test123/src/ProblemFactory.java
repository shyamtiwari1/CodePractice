public class ProblemFactory {


    public static Problem createProblem(String id, String description, String tag, Difficulty difficulty, int score  ){
        return new Problem(id, description , tag, difficulty , score);
    }}
