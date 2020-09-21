package pl.coderslab.medical_devices_query_system.user;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.medical_devices_query_system.baseEntity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity {
    public static final String TABLE_NAME = "users";
    private final String COLUMN_ROLE = "user_role";

    @NotBlank
    private String fisrtName;

    @NotBlank
    private String lastName;

    public String getFullName() {
        return fisrtName + lastName;
    }

    @Column(name = COLUMN_ROLE)
    private String role;

    private UserDetails userDetails;


}
