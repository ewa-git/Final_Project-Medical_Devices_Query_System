package pl.coderslab.medical_devices_query_system.customization.exceptions.exception;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message){
        super(message);
    }
}
