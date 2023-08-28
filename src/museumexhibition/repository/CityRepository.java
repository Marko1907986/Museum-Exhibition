package museumexhibition.repository;

import museumexhibition.domain.City;
import java.util.List;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface CityRepository {

    void save(City city) throws Exception;

    List<City> getAll() throws Exception;

    void delete(Long id) throws Exception;

    void update(City city) throws Exception;
}
