package museumexhibition.service.impl;

import java.util.List;
import museumexhibition.domain.Exhibit;
import museumexhibition.repository.ExhibitRepository;
import museumexhibition.repository.impl.ExhibitRepositoryImpl;
import museumexhibition.service.ExhibitService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitServiceImpl implements ExhibitService {
    
    private final ExhibitRepository exhibitRepository;
    
    public ExhibitServiceImpl() {
        exhibitRepository = new ExhibitRepositoryImpl();
    }
    
    @Override
    public void save(Exhibit exhibit) throws Exception {
        exhibitRepository.save(exhibit);
    }
    
    @Override
    public List<Exhibit> getAll() throws Exception {
        return exhibitRepository.getAll();
    }
    
    @Override
    public List<Exhibit> findByQuery(String model) throws Exception {
        return exhibitRepository.findByQuery(model);
    }
    
    @Override
    public void delete(Long id) throws Exception {
        exhibitRepository.delete(id);
    }
    
    @Override
    public void update(Exhibit exhibit) throws Exception {
        exhibitRepository.update(exhibit);
    }
    
}
