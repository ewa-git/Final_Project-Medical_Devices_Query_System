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
    @Column(name = "room_name")
    private String roomName;

    @NotBlank
    private String height;

    @NotBlank
    @Column(name = "room_length")
    private String roomLength;

    @NotBlank
    @Column(name = "room_width")
    private String roomWidth;

    @CollectionTable
    @ElementCollection
    private List<String> comments;
}
