package pl.coderslab.medical_devices_query_system.hospital;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NIP
    private String nip;

    @REGON
    private String regon;

}
