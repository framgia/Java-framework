package mvs.repository;

import mvs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quangminh on 27/06/2017.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String email);

}
