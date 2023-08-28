package museumexhibition.service.impl;

import java.util.List;
import museumexhibition.domain.City;
import museumexhibition.repository.CityRepository;
import museumexhibition.repository.impl.CityRepositoryImpl;
import museumexhibition.service.CityService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl() {
        cityRepository = new CityRepositoryImpl();
    }

    @Override
    public void save(City city) throws Exception {
        cityRepository.save(city);
    }

    @Override
    public List<City> getAll() throws Exception {
        return cityRepository.getAll();
    }

    @Override
    public void delete(Long id) throws Exception {
        cityRepository.delete(id);
    }

    @Override
    public void update(City city) throws Exception {
        cityRepository.update(city);
    }

}
