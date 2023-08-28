package museumexhibition.repository.impl;

import java.sql.*;
import museumexhibition.connection.MyConnection;
import museumexhibition.domain.Employer;
import museumexhibition.repository.EmployerRepository;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class EmployerRepositoryImpl implements EmployerRepository {

    @Override
    public Employer findById(Long id) throws Exception {
        String query = "SELECT * FROM employer WHERE id = ?";
        Connection connection = MyConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Employer(rs.getLong("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"));

        } else {
            return null;
        }
    }

}
