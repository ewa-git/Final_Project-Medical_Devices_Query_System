package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.model.system.System;
import pl.coderslab.medical_devices_query_system.repositories.SystemRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class SystemService {

    private final SystemRepository systemRepository;

    public void saveSystem(System system) {
        systemRepository.save(system);
    }

    public List<System> findAllByActive() {
        return systemRepository.findAllByActive();
    }

    public List<System> findAllByNotActive() {
        return systemRepository.findAllByNotActive();
    }

    public Optional<System> findSystemById(long id) {
        return systemRepository.findById(id);
    }

    public void updateSystem(System modelSystem, System dbSystem) {
        dbSystem.setName(modelSystem.getName());
        dbSystem.setType(modelSystem.getType());
        dbSystem.setDescription(modelSystem.getDescription());
        systemRepository.save(dbSystem);
    }

    public void deactivateSystem(System system) {
        system.setActive(false);
        systemRepository.save(system);
    }

    public void activateSystem(System system) {
        system.setActive(true);
        systemRepository.save(system);
    }
}
