package pl.coderslab.medical_devices_query_system.user.model;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.baseEntity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    private UserData userData;

    public String getFullName() {
        return fisrtName + lastName;
    }


}
