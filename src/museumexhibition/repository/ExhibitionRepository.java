package museumexhibition.repository;

import java.util.Date;
import java.util.List;
import museumexhibition.domain.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public interface ExhibitionRepository {

    void save(Exhibition exhibition) throws Exception;

    List<Exhibition> getAll() throws Exception;

    List<Exhibition> getDistinct() throws Exception;

    void delete(Long museumid, Date date) throws Exception;

    void update(Long id, Date newDate, String newName, int newDays, Exhibition exhibition) throws Exception;

    List<Exhibit> getListNames(Exhibition exhibition) throws Exception;

    void deleteExhibit(Long museumid, Date date, String exhibitName) throws Exception;

}
