package museumexhibition.repository.impl;

import museumexhibition.connection.MyConnection;
import museumexhibition.domain.City;
import museumexhibition.repository.CityRepository;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class CityRepositoryImpl implements CityRepository {

    @Override
    public void save(City city) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "INSERT INTO city (zipcode, name) VALUES (?,?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, city.getZipcode());
        ps.setString(2, city.getName());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<City> getAll() throws Exception {
        List<City> cities = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT id, zipcode, name FROM city ORDER BY 1";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long id = rs.getLong("id");
            Long zipcode = rs.getLong("zipcode");
            String name = rs.getString("name");

            City city = new City(id, zipcode, name);
            cities.add(city);
        }
        rs.close();
        statement.close();
        return cities;
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "DELETE FROM city WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(City city) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "UPDATE city SET zipcode=?, name=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, city.getZipcode());
        ps.setString(2, city.getName());
        ps.setLong(3, city.getId());
        ps.executeUpdate();
        ps.close();
    }

}
