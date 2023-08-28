package museumexhibition.repository;

import museumexhibition.domain.Employer;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface EmployerRepository {

    Employer findById(Long id) throws Exception;
}
