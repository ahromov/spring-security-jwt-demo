package ahromov.jwtappdemo.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ahromov.jwtappdemo.model.Role;
import ahromov.jwtappdemo.model.Status;
import ahromov.jwtappdemo.model.User;
import ahromov.jwtappdemo.repository.RoleRepository;
import ahromov.jwtappdemo.repository.UserRepository;
import ahromov.jwtappdemo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserService} interface. Wrapper for
 * {@link UserRepository} + business logic.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
						   PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User register(User user) {
		Role roleUser = roleRepository.findByName("ROLE_USER");
		List<Role> userRoles = new ArrayList<>();
		userRoles.add(roleUser);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(userRoles);
		user.setStatus(Status.ACTIVE);

		User registeredUser = userRepository.save(user);

		log.info("IN register - user: {} successfully registered", registeredUser);

		return registeredUser;
	}

	@Override
	public List<User> getAll() {
		List<User> result = userRepository.findAll();

		log.info("IN getAll - {} users found", result.size());

		return result;
	}

	@Override
	public User findByUsername(String username) {
		User result = userRepository.findByUsername(username);

		log.info("IN findByUsername - user: {} found by username: {}", result, username);

		return result;
	}

	@Override
	public User findById(Long id) {
		User result = userRepository.findById(id).orElse(null);

		if (result == null) {
			log.warn("IN findById - no user found by id: {}", id);
			return null;
		}

		log.info("IN findById - user: {} found by id: {}", result);

		return result;
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);

		log.info("IN delete - user with id: {} successfully deleted");
	}

}
