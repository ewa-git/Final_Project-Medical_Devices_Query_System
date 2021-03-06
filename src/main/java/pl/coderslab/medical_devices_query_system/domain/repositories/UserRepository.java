package pl.coderslab.medical_devices_query_system.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.medical_devices_query_system.domain.model.user.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String emailToCheck);

    User findUserByEmail(String email);

    boolean existsByRole(String role);

    @Query("SELECT u FROM User u WHERE u.active = true AND u.role = ?1")
    List<User> findUserByActiveAndRole(String role);

}
