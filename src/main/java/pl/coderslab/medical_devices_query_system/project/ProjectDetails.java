package pl.coderslab.medical_devices_query_system.project;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Embeddable
public class ProjectDetails {
    protected final String COLUMN_ROOM_NAME = "room_name";
    private final String COLUMN_ROOM_LENGTH = "room_length";
    private final String COLUMN_ROOM_WIDTH = "room_width";
    private final String COLUMN_COMMENTS = "room_width";

    @NotBlank
    @Column(name = COLUMN_ROOM_NAME)
    private String roomName;

    @NotBlank
    private String height;

    @NotBlank
    @Column(name = COLUMN_ROOM_LENGTH)
    private String roomLength;

    @NotBlank
    @Column(name = COLUMN_ROOM_WIDTH)
    private String roomWidth;

    @CollectionTable(name = COLUMN_COMMENTS)
    @ElementCollection
    private List<String> comments;
}
