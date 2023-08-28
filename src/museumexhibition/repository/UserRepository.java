package museumexhibition.repository;

import museumexhibition.domain.User;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface UserRepository {

    User login(String username, String password) throws Exception;
}
