package pl.coderslab.medical_devices_query_system.user.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User{
    private final pl.coderslab.medical_devices_query_system.user.model.User user;

    public CurrentUser (String username,
                        String password,
                        Collection<?extends GrantedAuthority> authorities,
                        pl.coderslab.medical_devices_query_system.user.model.User user){
        super(username, password, authorities);
        this.user = user;
    }

    public pl.coderslab.medical_devices_query_system.user.model.User getUser(){
        return user;
    }
}
