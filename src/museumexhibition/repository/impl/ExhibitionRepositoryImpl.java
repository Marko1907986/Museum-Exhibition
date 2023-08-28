package museumexhibition.repository.impl;

import museumexhibition.connection.MyConnection;
import museumexhibition.domain.Exhibition;
import museumexhibition.repository.ExhibitionRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import museumexhibition.domain.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitionRepositoryImpl implements ExhibitionRepository {

    @Override
    public void save(Exhibition exhibition) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        Date sqlDate = new Date(exhibition.getOpening().getTime());
        String query = "INSERT INTO exhibition (museumid, opening, `name`, duration_in_days, exhibitid) "
                + "VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, exhibition.getMuseum().getId());
        ps.setDate(2, sqlDate);
        ps.setString(3, exhibition.getName());
        ps.setInt(4, exhibition.getDurationInDays());
        ps.setLong(5, exhibition.getExhibit().getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<Exhibition> getAll() throws Exception {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT e.museumid, e.opening, e.name, e.duration_in_days, e.exhibitid, "
                + "ex.name, ex.description, "
                + "m.name, m.address, m.cityid, "
                + "c.zipcode, c.name "
                + "FROM exhibition e "
                + "INNER JOIN exhibit ex ON e.exhibitid=ex.id "
                + "INNER JOIN museum m ON e.museumid=m.id "
                + "INNER JOIN city c ON m.cityid=c.id "
                + "ORDER BY 2";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long museumid = rs.getLong("e.museumid");
            Long exhibitid = rs.getLong("e.exhibitid");
            Date opening = rs.getDate("e.opening");
            String exhibitionName = rs.getString("e.name");
            int duration = rs.getInt("e.duration_in_days");

            String exhibitName = rs.getString("ex.name");
            String description = rs.getString("ex.description");

            String museumName = rs.getString("m.name");
            String address = rs.getString("m.address");
            Long cityid = rs.getLong("m.cityid");

            Long zipcode = rs.getLong("c.zipcode");
            String cityName = rs.getString("c.name");

            City city = new City(cityid, zipcode, cityName);
            Museum museum = new Museum(museumid, museumName, address, city);
            Exhibit exhibit = new Exhibit(exhibitid, exhibitName, description);
            Exhibition exhibition = new Exhibition(museum, exhibit, opening, exhibitionName, duration);

            exhibitions.add(exhibition);
        }
        rs.close();
        statement.close();
        return exhibitions;
    }

    @Override
    public void delete(Long museumid, java.util.Date date) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        Date sqlDate = new Date(date.getTime());
        String query = "DELETE FROM exhibition WHERE museumid=? AND opening=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, museumid);
        ps.setDate(2, sqlDate);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<Exhibition> getDistinct() throws Exception {
        List<Exhibition> exhibitions = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT DISTINCT e.museumid, e.opening, e.name, e.duration_in_days, "
                + "m.name, m.address, m.cityid, "
                + "c.zipcode, c.name "
                + "FROM exhibition e "
                + "INNER JOIN museum m ON e.museumid=m.id "
                + "INNER JOIN city c ON m.cityid=c.id "
                + "ORDER BY 2";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long museumid = rs.getLong("e.museumid");
            Date opening = rs.getDate("e.opening");
            String exhibitionName = rs.getString("e.name");
            int duration = rs.getInt("e.duration_in_days");

            String museumName = rs.getString("m.name");
            String address = rs.getString("m.address");
            Long cityid = rs.getLong("m.cityid");

            Long zipcode = rs.getLong("c.zipcode");
            String cityName = rs.getString("c.name");

            City city = new City(cityid, zipcode, cityName);
            Museum museum = new Museum(museumid, museumName, address, city);
            Exhibition exhibition = new Exhibition(museum, null, opening, exhibitionName, duration);

            exhibitions.add(exhibition);
        }
        rs.close();
        statement.close();
        return exhibitions;
    }

    @Override
    public void update(Long id, java.util.Date newDate, String newName, int nDays, Exhibition exhibition) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        Date sqlDate = new Date(newDate.getTime());
        Date sqlOldDate = new Date(exhibition.getOpening().getTime());
        String query = "UPDATE exhibition SET museumid=" + id + ", opening='" + sqlDate + "', `name`='"
                + newName + "', duration_in_days=" + nDays + " WHERE museumid=? AND opening=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, exhibition.getMuseum().getId());
        ps.setDate(2, sqlOldDate);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<Exhibit> getListNames(Exhibition exhibition) throws Exception {
        List<Exhibit> exhibits = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT ex.name, ex.description, ex.id FROM exhibit ex "
                + "INNER JOIN exhibition e ON ex.id=e.exhibitid "
                + "WHERE e.museumid=" + exhibition.getMuseum().getId() + " "
                + "AND e.opening = '" + exhibition.getOpening().toString() + "'";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long exhibitid = rs.getLong("ex.id");
            String exhibitName = rs.getString("ex.name");
            String description = rs.getString("ex.description");

            Exhibit exhibit = new Exhibit(exhibitid, exhibitName, description);

            exhibits.add(exhibit);
        }
        rs.close();
        statement.close();
        return exhibits;
    }

    @Override
    public void deleteExhibit(Long museumid, java.util.Date date, String exhibitName) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        Date sqlDate = new Date(date.getTime());
        String query = "DELETE FROM exhibition WHERE museumid=? AND opening=? AND exhibitid=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, museumid);
        ps.setDate(2, sqlDate);
        ps.setLong(3, Long.valueOf(exhibitName));
        ps.executeUpdate();
        ps.close();
    }
}
