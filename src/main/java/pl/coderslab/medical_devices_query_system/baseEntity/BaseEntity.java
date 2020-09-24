package pl.coderslab.medical_devices_query_system.baseEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    @Column(nullable = false)
    private boolean active = false;

    @PrePersist
    public void setCreatedOnAndActive() {
        createdOn = LocalDateTime.now();
        active = true;
    }

    @PreUpdate
    public void setUpdatedOn() {
        updatedOn = LocalDateTime.now();
    }
}
