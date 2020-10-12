package ahromov.jwtappdemo.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * Authetication exception for JwtAppDemo application.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

public class JwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 2186427051940659160L;

	public JwtAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public JwtAuthenticationException(String msg) {
		super(msg);
	}

}
