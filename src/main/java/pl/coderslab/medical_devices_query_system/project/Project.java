package pl.coderslab.medical_devices_query_system.project;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.baseEntity.BaseEntity;
import pl.coderslab.medical_devices_query_system.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.system.System;
import pl.coderslab.medical_devices_query_system.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = Project.TABLE_NAME)
public class Project extends BaseEntity {
    public static final String TABLE_NAME = "projects";

    private ProjectDetails projectDetails;

    private String status;

    @PrePersist
    public void setStatus(){
        status = "requested";
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
