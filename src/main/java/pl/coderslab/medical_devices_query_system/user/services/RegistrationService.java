package pl.coderslab.medical_devices_query_system.user.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.user.model.Role;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void registerManager(User user){
        user.setRole(Role.MANAGER.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
    }

}
