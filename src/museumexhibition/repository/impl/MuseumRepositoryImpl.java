package museumexhibition.repository.impl;

import museumexhibition.domain.Museum;
import museumexhibition.repository.MuseumRepository;
import java.sql.*;
import java.util.*;
import museumexhibition.connection.MyConnection;
import museumexhibition.domain.City;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MuseumRepositoryImpl implements MuseumRepository {

    @Override
    public void save(Museum museum) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "INSERT INTO museum (name, address, cityid) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, museum.getName());
        ps.setString(2, museum.getAddress());
        ps.setLong(3, museum.getCity().getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<Museum> getAll() throws Exception {
        List<Museum> museums = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT m.id, m.name, m.address, m.cityid, c.zipcode, c.name "
                + "FROM museum m "
                + "INNER JOIN city c ON m.cityid=c.id "
                + "ORDER BY 1";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long id = rs.getLong("m.id");
            String name = rs.getString("m.name");
            String address = rs.getString("m.address");
            Long cityid = rs.getLong("m.cityid");
            Long zipcode = rs.getLong("c.zipcode");
            String cityname = rs.getString("c.name");

            City city = new City();
            city.setId(cityid);
            city.setZipcode(zipcode);
            city.setName(cityname);

            Museum museum = new Museum(id, name, address, city);
            museums.add(museum);
        }
        rs.close();
        statement.close();
        return museums;
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "DELETE FROM museum WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(Museum museum) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "UPDATE museum SET name=?, address=?, cityid=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, museum.getName());
        ps.setString(2, museum.getAddress());
        ps.setLong(3, museum.getCity().getId());
        ps.setLong(4, museum.getId());
        ps.executeUpdate();
        ps.close();
    }

}
