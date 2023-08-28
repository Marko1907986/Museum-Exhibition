package museumexhibition.service;

import museumexhibition.domain.User;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface UserService {

    User login(String username, String password) throws Exception;

}
