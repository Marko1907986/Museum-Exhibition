package museumexhibition.domain;

import java.util.Objects;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class User {

    private String username;
    private String password;
    private Employer employer;

    public User() {
    }

    public User(String username, String password, Employer employer) {
        this.username = username;
        this.password = password;
        this.employer = employer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.employer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.employer, other.employer);
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", employer=" + employer + '}';
    }

}
