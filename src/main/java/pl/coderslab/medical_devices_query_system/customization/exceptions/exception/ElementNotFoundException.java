package pl.coderslab.medical_devices_query_system.customization.exceptions.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message){
        super(message);
    }
}
