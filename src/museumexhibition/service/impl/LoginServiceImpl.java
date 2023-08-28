package museumexhibition.service.impl;

import museumexhibition.domain.*;
import museumexhibition.repository.*;
import museumexhibition.repository.impl.*;
import museumexhibition.service.LoginService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;
    private EmployerRepository employerRepository;

    public LoginServiceImpl() {
        userRepository = new UserRepositoryImpl();
        employerRepository = new EmployerRepositoryImpl();
    }

    @Override
    public User login(String username, String password) throws Exception {
        User user = userRepository.login(username, password);
        Employer employer = employerRepository.findById(user.getEmployer().getId());
        user.setEmployer(employer);
        return user;
    }

}
