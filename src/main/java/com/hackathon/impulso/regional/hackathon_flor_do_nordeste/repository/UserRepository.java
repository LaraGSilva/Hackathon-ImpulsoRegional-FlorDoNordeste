import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackathon.impulso.regional.hackathon_flor_do_nordeste.model.User; // Corrigido o import
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
