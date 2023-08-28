package museumexhibition.service;

import museumexhibition.domain.Employer;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface EmployerService {

    Employer findById(Long id) throws Exception;

}
