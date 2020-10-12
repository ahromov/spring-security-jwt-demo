package ahromov.jwtappdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ahromov.jwtappdemo.model.User;

/**
 * Repository interface that extends {@link JpaRepository} for class
 * {@link User}.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String name);

}
