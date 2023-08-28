package museumexhibition.service.impl;

import java.util.Date;
import java.util.List;
import museumexhibition.connection.MyConnection;
import museumexhibition.domain.*;
import museumexhibition.repository.ExhibitionRepository;
import museumexhibition.repository.impl.ExhibitionRepositoryImpl;
import museumexhibition.service.ExhibitionService;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitionServiceImpl implements ExhibitionService {

    private ExhibitionRepository exhibitionRepository;

    public ExhibitionServiceImpl() {
        exhibitionRepository = new ExhibitionRepositoryImpl();
    }
    
    @Override
    public void save(Exhibition exhibition) throws Exception {
        exhibitionRepository.save(exhibition);
    }

    @Override
    public List<Exhibition> getAll() throws Exception {
       return exhibitionRepository.getAll();
    }

    @Override
    public List<Exhibition> getDistinct() throws Exception {
        return exhibitionRepository.getDistinct();
    }

    @Override
    public void delete(Long museumid, Date date) throws Exception {
        exhibitionRepository.delete(museumid, date);
    }

    @Override
    public void update(Long id, Date newDate, String newName, int newDays, Exhibition exhibition) throws Exception {
        exhibitionRepository.update(id, newDate, newName, newDays, exhibition);
    }

    @Override
    public List<Exhibit> getListNames(Exhibition exhibition) throws Exception {
        return exhibitionRepository.getListNames(exhibition);
    }

    @Override
    public void deleteExhibit(Long museumid, Date date, String exhibitName) throws Exception {
        exhibitionRepository.deleteExhibit(museumid, date, exhibitName);
    }

    @Override
    public void save(List<Exhibition> exhibitions) throws Exception {
        MyConnection.getInstance().getConnection().setAutoCommit(false);
        try {
            for (Exhibition exhibition : exhibitions) {
                exhibitionRepository.save(exhibition);
            }
            MyConnection.getInstance().getConnection().commit();
            MyConnection.getInstance().getConnection().setAutoCommit(true);
        } catch (Exception e) {
            MyConnection.getInstance().getConnection().rollback();
            MyConnection.getInstance().getConnection().setAutoCommit(true);
            throw e;
        }

    }

}
