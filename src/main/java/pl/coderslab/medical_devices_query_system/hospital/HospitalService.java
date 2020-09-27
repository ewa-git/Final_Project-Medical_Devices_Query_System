package pl.coderslab.medical_devices_query_system.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void editHospital(Hospital hospital){
        hospital.setActive(true);
        hospitalRepository.save(hospital);
    }

    public void deleteHospital(Hospital hospital){
        hospital.setActive(false);
        hospitalRepository.save(hospital);
    }
}