package museumexhibition.service;

import museumexhibition.domain.User;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface LoginService {

    User login(String username, String password) throws Exception;
}
