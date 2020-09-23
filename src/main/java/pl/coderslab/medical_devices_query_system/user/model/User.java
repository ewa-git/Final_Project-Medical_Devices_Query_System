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
    @Column(nullable = false)
    private String fisrtName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false)
    private String role;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 5)
    private String password;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;


    public String getFullName() {
        return fisrtName + lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
