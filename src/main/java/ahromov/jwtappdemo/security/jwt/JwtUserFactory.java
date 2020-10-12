package ahromov.jwtappdemo.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ahromov.jwtappdemo.model.Role;
import ahromov.jwtappdemo.model.Status;
import ahromov.jwtappdemo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of Factory Method for class {@link JwtUser}.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

public final class JwtUserFactory {

	public JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPassword(), mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
				user.getStatus().equals(Status.ACTIVE), user.getUpdated());
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
		return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
