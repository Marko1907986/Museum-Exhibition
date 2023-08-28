package museumexhibition.service.impl;

import java.util.List;
import museumexhibition.domain.Museum;
import museumexhibition.repository.MuseumRepository;
import museumexhibition.repository.impl.MuseumRepositoryImpl;
import museumexhibition.service.MuseumService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MuseumServiceImpl implements MuseumService {

    private final MuseumRepository museumRepository;

    public MuseumServiceImpl() {
        museumRepository = new MuseumRepositoryImpl();
    }

    @Override
    public void save(Museum museum) throws Exception {
        museumRepository.save(museum);
    }

    @Override
    public List<Museum> getAll() throws Exception {
        return museumRepository.getAll();
    }

    @Override
    public void delete(Long id) throws Exception {
        museumRepository.delete(id);
    }

    @Override
    public void update(Museum museum) throws Exception {
        museumRepository.update(museum);
    }

}
