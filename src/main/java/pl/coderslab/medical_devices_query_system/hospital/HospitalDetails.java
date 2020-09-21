package pl.coderslab.medical_devices_query_system.hospital;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class HospitalDetails {

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NIP
    private String nip;

    @REGON
    private String regon;
}
