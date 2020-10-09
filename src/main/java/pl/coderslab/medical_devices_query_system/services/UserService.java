package pl.coderslab.medical_devices_query_system.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.exceptions.UserAlreadyExists;
import pl.coderslab.medical_devices_query_system.domain.model.user.Role;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;
import pl.coderslab.medical_devices_query_system.domain.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean existByEmail(String emailToCheck) {
        return userRepository.existsByEmail(emailToCheck);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean existsByRole(String role) {
        return userRepository.existsByRole(role);
    }

    public List<User> findUserByActiveAndRole(String role) {
        return userRepository.findUserByActiveAndRole(role);
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public void registerManager(User user) {
        user.setRole(Role.ROLE_MANAGER.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
    }

    public void createAdmin() {
        if (existsByRole("ROLE_ADMIN")) {
            throw new UserAlreadyExists("Użytkownik admin już istnieje");
        }
        User admin = new User();
        admin.setFisrtName("Admin");
        admin.setLastName("Admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.ROLE_ADMIN.toString());
        admin.setEmail("admin@gmail.com");
        userRepository.save(admin);
        log.debug("Użytkownik zarejestrowany:", admin);

    }

    public void createEngineer(User user) {
        user.setRole(Role.ROLE_ENGINEER.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.debug("Użytkownik zarejestrowany:", user);
    }

    public void updateUser(User user) {
        user.setActive(true);
        userRepository.save(user);
        log.debug("Użytkownik zaktualizowany:", user);
    }

    public void deleteUser(User user) {
        user.setActive(false);
        userRepository.save(user);
        log.debug("Usunięto użytkownika:", user);
    }


}
