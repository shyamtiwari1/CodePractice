package LoggingService;

public class LoggerService {

    private LogLevel logLevel;
    private static LoggerService loggerService;

    private LoggerService(LogLevel logLevel){
        this.logLevel = logLevel;
    }



}
