package pl.coderslab.medical_devices_query_system.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@Embeddable
@RequiredArgsConstructor()
public class UserData {

    @NotBlank
    @Size(min = 5)
    private String password;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;


//    private String phone;


    //Relacja dwukierunkowa z klasa project nie jest potrzebna lepiej robic zapytanie
    // do bazy danych dla danego managera/inzyniera wyciagnac liste projektow
/*    @OneToMany
    private List<Project> listOfProjects = new ArrayList<>();*/

}

