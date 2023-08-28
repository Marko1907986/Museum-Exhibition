package museumexhibition.service;

import java.util.List;
import museumexhibition.domain.Exhibit;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface ExhibitService {

    void save(Exhibit exhibit) throws Exception;

    List<Exhibit> getAll() throws Exception;

    List<Exhibit> findByQuery(String model) throws Exception;

    void delete(Long id) throws Exception;

    void update(Exhibit exhibit) throws Exception;

}
