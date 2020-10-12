package ahromov.jwtappdemo.dto;

import lombok.Data;

/**
 * DTO class for authentication (login) request.
 *
 * @author Andriy Hromov
 * @version 1.0
 */

@Data
public class AuthenticationRequestDto {

	private String username;
	private String password;

}
