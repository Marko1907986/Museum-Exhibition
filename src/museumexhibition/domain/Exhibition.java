package museumexhibition.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class Exhibition {

    private Museum museum;
    private Exhibit exhibit;
    private Date opening;
    private String name;
    private int durationInDays;

    public Exhibition() {
    }

    public Exhibition(Museum museum, Exhibit exhibit, Date opening, String name, int durationInDays) {
        this.museum = museum;
        this.exhibit = exhibit;
        this.opening = opening;
        this.name = name;
        this.durationInDays = durationInDays;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public Exhibit getExhibit() {
        return exhibit;
    }

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    public Date getOpening() {
        return opening;
    }

    public void setOpening(Date opening) {
        this.opening = opening;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.museum);
        hash = 97 * hash + Objects.hashCode(this.exhibit);
        hash = 97 * hash + Objects.hashCode(this.opening);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.durationInDays;
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
        final Exhibition other = (Exhibition) obj;
        if (this.durationInDays != other.durationInDays) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.museum, other.museum)) {
            return false;
        }
        if (!Objects.equals(this.exhibit, other.exhibit)) {
            return false;
        }
        return Objects.equals(this.opening, other.opening);
    }

    @Override
    public String toString() {
        return "Exhibition{" + "museum=" + museum + ", exhibit=" + exhibit + ", opening=" + opening + ", name=" + name + ", durationInDays=" + durationInDays + '}';
    }

}
