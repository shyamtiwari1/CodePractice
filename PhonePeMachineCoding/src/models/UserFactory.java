package models;

public class UserFactory {

    public static User createUSer(String id , String name , String department){
        return new User(id, name , department);
    }

//    addUser();


}
