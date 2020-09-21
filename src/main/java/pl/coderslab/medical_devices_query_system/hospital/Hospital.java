package pl.coderslab.medical_devices_query_system.hospital;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.medical_devices_query_system.baseEntity.BaseEntity;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = Hospital.TABLE_NAME)
public class Hospital extends BaseEntity {
    public static final String TABLE_NAME = "hospitals";

    @NotBlank
    private String name;

    private HospitalDetails hospitalDetails;

}
