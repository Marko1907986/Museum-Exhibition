package museumexhibition.ui.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import museumexhibition.domain.Museum;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MuseumTableModel extends AbstractTableModel {

    private List<Museum> museums;
    private String[] attributes = new String[]{"ID", "NAME", "ADDRESS", "ZIPCODE", "CITY"};

    public MuseumTableModel(List<Museum> museums) {
        this.museums = museums;
    }

    @Override
    public int getRowCount() {
        return museums.size();
    }

    @Override
    public int getColumnCount() {
        return attributes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Museum museum = museums.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return museum.getId();
            case 1:
                return museum.getName();
            case 2:
                return museum.getAddress();
            case 3:
                return museum.getCity().getZipcode();
            case 4:
                return museum.getCity().getName();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return attributes[column];
    }

    public Museum getMuseum(int rowIndex) {
        return museums.get(rowIndex);
    }

}
