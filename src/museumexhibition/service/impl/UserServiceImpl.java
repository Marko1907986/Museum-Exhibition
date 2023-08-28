package museumexhibition.service.impl;

import museumexhibition.domain.User;
import museumexhibition.repository.UserRepository;
import museumexhibition.repository.impl.UserRepositoryImpl;
import museumexhibition.service.UserService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public User login(String username, String password) throws Exception {
        return userRepository.login(username, password);
    }

}
