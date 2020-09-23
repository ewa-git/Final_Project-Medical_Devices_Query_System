package pl.coderslab.medical_devices_query_system.user.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.coderslab.medical_devices_query_system.baseEntity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity {
    public static final String TABLE_NAME = "users";

    @NotBlank
    private String fisrtName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 5)
    private String password;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

/*
    public User(String email, String password, GrantedAuthority authority) {
        this.email = email;
        this.password = password;
        authority = new SimpleGrantedAuthority(role);
    }
*/

    public String getFullName() {
        return fisrtName + lastName;
    }


}
