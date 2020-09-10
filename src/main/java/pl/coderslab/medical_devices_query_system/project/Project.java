package pl.coderslab.medical_devices_query_system.project;

import jdk.vm.ci.meta.Local;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.hospital.Hospital;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String roomName;

    @NotBlank
    private String height;

    @NotBlank
    private String roomLength;

    @NotBlank
    private String roomWidth;

    private String comments;

    private String status;

    private LocalDateTime created;


    @PrePersist
    public void setCreatedAndStatus(){
        created = LocalDateTime.now();
        status = "requested";
    }

    @ManyToOne
    private Hospital hospital;







}
