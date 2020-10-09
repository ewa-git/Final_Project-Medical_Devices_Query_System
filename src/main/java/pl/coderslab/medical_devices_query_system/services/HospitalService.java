package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.model.hospital.Hospital;
import pl.coderslab.medical_devices_query_system.repositories.HospitalRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public void saveHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public List<Hospital> findAllByActiveAndManagerId(long id){
        return hospitalRepository.findAllByActiveAndManagerId(id);
    }

    public Optional<Hospital> findHospitalById(long id){
        return hospitalRepository.findHospitalById(id);
    }

    public void editHospital(Hospital modelHospital, Hospital dbHospital){
        dbHospital.setName(modelHospital.getName());
        dbHospital.getHospitalDetails().setCity(modelHospital.getHospitalDetails().getCity());
        dbHospital.getHospitalDetails().setStreet(modelHospital.getHospitalDetails().getStreet());
        dbHospital.getHospitalDetails().setNip(modelHospital.getHospitalDetails().getNip());
        dbHospital.getHospitalDetails().setRegon(modelHospital.getHospitalDetails().getRegon());

        hospitalRepository.save(dbHospital);
    }

    public void deleteHospital(Hospital hospital){
        hospital.setActive(false);
        hospitalRepository.save(hospital);
    }


}
