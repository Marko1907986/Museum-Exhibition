package museumexhibition.service.impl;

import museumexhibition.domain.Employer;
import museumexhibition.repository.EmployerRepository;
import museumexhibition.repository.impl.EmployerRepositoryImpl;
import museumexhibition.service.EmployerService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl() {
        employerRepository = new EmployerRepositoryImpl();
    }

    @Override
    public Employer findById(Long id) throws Exception {
        return employerRepository.findById(id);
    }

}
