package museumexhibition.service;

import java.util.List;
import museumexhibition.domain.City;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface CityService {

    void save(City city) throws Exception;

    List<City> getAll() throws Exception;

    void delete(Long id) throws Exception;

    void update(City city) throws Exception;

}
