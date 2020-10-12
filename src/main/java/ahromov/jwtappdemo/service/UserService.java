package ahromov.jwtappdemo.service;

import java.util.List;

import ahromov.jwtappdemo.model.User;

/**
 * Service interface for class {@link User}.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

public interface UserService {

	User register(User user);

	List<User> getAll();

	User findByUsername(String username);

	User findById(Long id);

	void delete(Long id);

}
