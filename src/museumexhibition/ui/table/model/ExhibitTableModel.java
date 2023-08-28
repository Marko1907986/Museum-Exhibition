package museumexhibition.ui.table.model;

import museumexhibition.domain.Exhibit;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitTableModel extends AbstractTableModel {

    private List<Exhibit> exhibits;
    private String[] attributes = new String[]{"ID", "NAME", "DESCRIPTION"};

    public ExhibitTableModel(List<Exhibit> exhibits) {
        this.exhibits = exhibits;
    }

    @Override
    public int getRowCount() {
        return exhibits.size();
    }

    @Override
    public int getColumnCount() {
        return attributes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exhibit exhibit = exhibits.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return exhibit.getId();
            case 1:
                return exhibit.getName();
            case 2:
                return exhibit.getDescription();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return attributes[column];
    }

    public Exhibit getExhibit(int rowIndex) {
        return exhibits.get(rowIndex);
    }

}
