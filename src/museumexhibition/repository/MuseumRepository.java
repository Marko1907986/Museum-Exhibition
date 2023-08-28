package museumexhibition.repository;

import java.util.List;
import museumexhibition.domain.Museum;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface MuseumRepository {

    void save(Museum museum) throws Exception;

    List<Museum> getAll() throws Exception;

    void delete(Long id) throws Exception;

    void update(Museum museum) throws Exception;
}
