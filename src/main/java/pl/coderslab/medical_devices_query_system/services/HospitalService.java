package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.domain.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.domain.repositories.HospitalRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public void saveHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public List<Hospital> findAllByActiveAndManagerId(long id) {
        return hospitalRepository.findAllByActiveAndManagerId(id);
    }

    public Optional<Hospital> findHospitalById(long id) {
        return hospitalRepository.findHospitalById(id);
    }

    public void editHospital(Hospital modelHospital, Hospital dbHospital) {
        dbHospital.setName(modelHospital.getName());
        dbHospital.getHospitalDetails().setCity(modelHospital.getHospitalDetails().getCity());
        dbHospital.getHospitalDetails().setStreet(modelHospital.getHospitalDetails().getStreet());
        dbHospital.getHospitalDetails().setNip(modelHospital.getHospitalDetails().getNip());
        dbHospital.getHospitalDetails().setRegon(modelHospital.getHospitalDetails().getRegon());
        hospitalRepository.save(dbHospital);
        log.debug("Zmieniono dane szpitala:", dbHospital);
    }

    public void deleteHospital(Hospital hospital) {
        hospital.setActive(false);
        hospitalRepository.save(hospital);
        log.debug("Zdeaktywowano szpital:", hospital);
    }


}
