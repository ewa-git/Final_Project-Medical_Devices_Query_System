package pl.coderslab.medical_devices_query_system.project;

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
    private String roomName;

    @NotBlank
    private String height;

    @NotBlank
    private String roomLength;

    @NotBlank
    private String roomWidth;

    @CollectionTable
    @ElementCollection
    private List<String> comments;
}
