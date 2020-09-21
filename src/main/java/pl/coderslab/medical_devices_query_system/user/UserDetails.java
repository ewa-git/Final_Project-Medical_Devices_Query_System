package pl.coderslab.medical_devices_query_system.user;

import pl.coderslab.medical_devices_query_system.project.Project;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class UserDetails {
    @Email
    @NotBlank
    private String email;

    private String phone;

    @OneToMany
    private List<Project> listOfProjects = new ArrayList<>();
}
