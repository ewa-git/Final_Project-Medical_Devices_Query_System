package pl.coderslab.medical_devices_query_system.hospital;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;
import pl.coderslab.medical_devices_query_system.user.model.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class HospitalDetails {

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String street;

    @NIP
    private String nip;

    @REGON
    private String regon;

    @OneToOne
    private User manager;
}
