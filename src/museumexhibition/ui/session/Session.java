package museumexhibition.ui.session;

import java.util.*;
import museumexhibition.domain.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class Session {

    private static final Session instance = new Session();
    private User user;
    private final Map<Object, Object> map = new HashMap<>();

    public static Session getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

}
