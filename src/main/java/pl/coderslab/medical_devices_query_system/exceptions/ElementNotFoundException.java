package pl.coderslab.medical_devices_query_system.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message){
        super(message);
    }
}
