package MachineCoding.Logger;

public class InfoLogProcessor extends LogProccessor{


    public InfoLogProcessor(LogProccessor nextLogProccessor) {
        super(nextLogProccessor);
    }

    public void log(int logLevel , String message){
        if(logLevel ==INFO){
            System.out.println("Info:{} " + message);
        }else{
            super.log(logLevel , message);
        }

    }
}
