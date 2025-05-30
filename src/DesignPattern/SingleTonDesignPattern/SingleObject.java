package DesignPattern.SingleTonDesignPattern;

public class SingleObject {
    public static  SingleObject instance = new SingleObject();
    //make constructor private so that object cannot be instiated
    private SingleObject(){};

    public static SingleObject getInstance(){
        return instance;
    }
}
