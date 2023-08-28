package museumexhibition.repository.impl;

import java.sql.*;
import museumexhibition.connection.MyConnection;
import museumexhibition.domain.*;
import museumexhibition.repository.UserRepository;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User login(String username, String password) throws Exception {
        String query = "SELECT * FROM user WHERE username=? and password=?";

        Connection connection = MyConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword("");

            Employer employer = new Employer();
            employer.setId(rs.getLong("employer_id"));

            user.setEmployer(employer);
            return user;
        } else {
            throw new Exception("User does not exist!");
        }
    }

}
