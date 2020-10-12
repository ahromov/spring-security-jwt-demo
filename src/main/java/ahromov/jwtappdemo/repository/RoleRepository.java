package ahromov.jwtappdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ahromov.jwtappdemo.model.Role;

/**
 * Repository interface that extends {@link JpaRepository} for class
 * {@link Role}.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);

}
