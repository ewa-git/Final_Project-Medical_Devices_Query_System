package pl.coderslab.medical_devices_query_system.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public void editHospital(Hospital hospital){
        hospital.setActive(true);
        hospitalRepository.save(hospital);
    }

    public void deleteHospital(Hospital hospital){
        hospital.setActive(false);
        hospitalRepository.save(hospital);
    }
}
