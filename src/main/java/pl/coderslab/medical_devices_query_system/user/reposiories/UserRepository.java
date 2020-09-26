package pl.coderslab.medical_devices_query_system.user.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.medical_devices_query_system.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String emailToCheck);
    User findUserByEmail(String email);
    boolean existsByRole(String role);
}
