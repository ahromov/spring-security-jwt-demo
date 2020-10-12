package ahromov.jwtappdemo.security;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ahromov.jwtappdemo.model.User;
import ahromov.jwtappdemo.security.jwt.JwtUser;
import ahromov.jwtappdemo.security.jwt.JwtUserFactory;
import ahromov.jwtappdemo.service.UserService;

/**
 * Implementation of {@link UserDetailsService} interface for {@link JwtUser}.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public JwtUserDetailsService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User with username: " + username + " not found");
		}

		JwtUser jwtUser = JwtUserFactory.create(user);

		log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);

		return jwtUser;
	}

}
