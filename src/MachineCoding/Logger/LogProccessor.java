package MachineCoding.Logger;

public class LogProccessor {

    public static int INFO = 1;
    public static int ERROR = 2;
    public static int DEBUG = 3;

    LogProccessor nextLogPrpcessor ;

    public  LogProccessor(LogProccessor logProccessor) {
        this.nextLogPrpcessor = logProccessor;
    }

    public void log(int logLevel, String message){

    }
}
