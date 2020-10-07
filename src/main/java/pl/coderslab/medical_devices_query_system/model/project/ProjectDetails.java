package pl.coderslab.medical_devices_query_system.model.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Embeddable
public class ProjectDetails {


    @NotBlank
    @Column(nullable = false)
    private String roomName;

    @NotBlank
    @Column(nullable = false)
    private String height;

    @NotBlank
    @Column(nullable = false)
    private String roomLength;

    @NotBlank
    @Column(nullable = false)
    private String roomWidth;

/*    @CollectionTable
    @ElementCollection
    private List<String> comments;*/
}
