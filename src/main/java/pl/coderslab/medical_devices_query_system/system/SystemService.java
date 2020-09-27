package pl.coderslab.medical_devices_query_system.system;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class SystemService {

    private final SystemRepository systemRepository;

    public void saveSystem(System system){
        systemRepository.save(system);
    }

    public List<System> findAllByActive(){
        return systemRepository.findAllByActive();
    }

    public List<System> findAllByNotActive(){
        return systemRepository.findAllByNotActive();
    }

    public Optional<System> findSystemById(long id){
        return systemRepository.findById(id);
    }

    public void updateSystem(System system){
        system.setActive(true);
        systemRepository.save(system);
    }

    public void deactivateSystem(System system){
        system.setActive(false);
        systemRepository.save(system);
    }
}
