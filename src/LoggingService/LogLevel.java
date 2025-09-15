package LoggingService;

import jdk.dynalink.linker.ConversionComparator;

public enum LogLevel {
    INFO,
    WARN,
    DEBUG,
    ERROR;

    private int priority;

    LogLevel(int priority){
        this.priority = priority;
    }

    LogLevel() {

    }

    public int getPriority(){
        return this.priority;

    }
}
