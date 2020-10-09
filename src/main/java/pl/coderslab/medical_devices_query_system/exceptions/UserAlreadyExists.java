package pl.coderslab.medical_devices_query_system.exceptions;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message){
        super(message);
    }
}
