package pl.coderslab.medical_devices_query_system.customization.exceptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message){
        super(message);
    }
}
