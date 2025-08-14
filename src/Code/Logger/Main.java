package Code.Logger;

public class Main {

    public static void main(String args[]){

        LogProccessor logProccessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProccessor.log(LogProccessor.ERROR , "ExceptionsHAppens");
        logProccessor.log(LogProccessor.INFO , "just for info");
        logProccessor.log(LogProccessor.DEBUG , "for debugging");



    }
}
