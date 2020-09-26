package pl.coderslab.medical_devices_query_system.user.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.customization.exceptions.UserAlreadyExists;
import pl.coderslab.medical_devices_query_system.user.model.Role;
import pl.coderslab.medical_devices_query_system.user.model.User;
import pl.coderslab.medical_devices_query_system.user.reposiories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void registerManager(User user) {
        user.setRole(Role.ROLE_MANAGER.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
    }

    public void createAdmin(){
        if(userRepository.existsByRole("ROLE_ADMIN")){
            throw new UserAlreadyExists("Użytkownik admin już istnieje");
        }
        User admin = new User();
        admin.setFisrtName("Admin");
        admin.setLastName("Admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole("ROLE_ADMIN");
        admin.setEmail("admin@gmail.com");
        userRepository.save(admin);

    }

}
