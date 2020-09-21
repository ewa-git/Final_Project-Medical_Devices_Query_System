package pl.coderslab.medical_devices_query_system.baseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on",nullable = false, updatable = false)
    private LocalDateTime createdOn;
    @Column(name = "created_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void setCreatedOn(){
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedOn(){
        updatedOn = LocalDateTime.now();
    }
}
