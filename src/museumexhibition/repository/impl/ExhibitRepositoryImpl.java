package museumexhibition.repository.impl;

import museumexhibition.domain.Exhibit;
import java.sql.*;
import java.util.*;
import museumexhibition.connection.MyConnection;
import museumexhibition.repository.ExhibitRepository;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitRepositoryImpl implements ExhibitRepository {

    @Override
    public void save(Exhibit exhibit) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "INSERT INTO exhibit(name, description) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, exhibit.getName());
        ps.setString(2, exhibit.getDescription());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public List<Exhibit> getAll() throws Exception {
        List<Exhibit> exhibits = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT id, name, description FROM exhibit ORDER BY id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String description = rs.getString("description");

            Exhibit exhibit = new Exhibit(id, name, description);
            exhibits.add(exhibit);
        }
        rs.close();
        statement.close();
        return exhibits;
    }

    @Override
    public List<Exhibit> findByQuery(String model) throws Exception {
        List<Exhibit> exhibits = new ArrayList<>();
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "SELECT * FROM exhibit WHERE NAME RLIKE '" + model + "' ORDER BY NAME";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String description = rs.getString("description");

            Exhibit exhibit = new Exhibit(id, name, description);
            exhibits.add(exhibit);
        }
        rs.close();
        statement.close();
        return exhibits;
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "DELETE FROM exhibit WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(Exhibit exhibit) throws Exception {
        Connection connection = MyConnection.getInstance().getConnection();
        String query = "UPDATE exhibit SET name=?, description=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, exhibit.getName());
        ps.setString(2, exhibit.getDescription());
        ps.setLong(3, exhibit.getId());
        ps.executeUpdate();
        ps.close();
    }

}
