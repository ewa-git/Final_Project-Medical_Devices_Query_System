package pl.coderslab.medical_devices_query_system.model.project;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.model.baseEntity.BaseEntity;
import pl.coderslab.medical_devices_query_system.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.model.system.System;
import pl.coderslab.medical_devices_query_system.model.user.User;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = Project.TABLE_NAME)
public class Project extends BaseEntity {
    public static final String TABLE_NAME = "projects";

    @Valid
    private ProjectDetails projectDetails;

    private String status;

    @PrePersist
    public void setStatus() {
        status = Status.REQUESTED.toString();
    }

    @NotNull
    @ManyToOne
    private Hospital hospital;

    @NotNull
    @ManyToOne
    private User manager;

    @ManyToOne
    private User engineer;

    @NotNull
    @ManyToOne
    private System system;

}
