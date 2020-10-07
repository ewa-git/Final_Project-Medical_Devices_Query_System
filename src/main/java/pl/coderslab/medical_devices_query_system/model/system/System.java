package pl.coderslab.medical_devices_query_system.model.system;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.model.baseEntity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = System.TABLE_NAME)
public class System extends BaseEntity {
    public static final String TABLE_NAME = "systems";

    @NotBlank
    @Column(nullable = false)
    private String type;

    @NotBlank
    @Column(nullable = false)
    private String name;

//    @NotNull
//    private Double price;

    private String description;

}
