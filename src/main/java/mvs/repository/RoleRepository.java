package mvs.repository;

import mvs.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quangminh on 27/06/2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);

}
