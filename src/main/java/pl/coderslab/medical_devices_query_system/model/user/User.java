package pl.coderslab.medical_devices_query_system.model.user;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.model.baseEntity.BaseEntity;
import pl.coderslab.medical_devices_query_system.customization.validation.RepeatPassword;
import pl.coderslab.medical_devices_query_system.customization.validation.UniqueEmail;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@Table(name = User.TABLE_NAME)
@RepeatPassword
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

    @NotBlank
    @Transient
    private String repeatPassword;


    @Email
    @UniqueEmail
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;


    public String getFullName() {
        return fisrtName + " " + lastName;
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
