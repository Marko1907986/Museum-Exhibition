package museumexhibition.ui.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import museumexhibition.domain.Exhibition;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitionDistinctTableModel extends AbstractTableModel {

    private List<Exhibition> exhibitions;
    private String[] attributes = new String[]{"MUSEUM", "TITLE OF THE EXHIBITION", "OPEN AT", "DURATION IN DAYS"};

    public ExhibitionDistinctTableModel(List<Exhibition> exhibitions) {
        this.exhibitions = exhibitions;
    }

    @Override
    public int getRowCount() {
        return exhibitions.size();
    }

    @Override
    public int getColumnCount() {
        return attributes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exhibition exhibition = exhibitions.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return exhibition.getMuseum();
            case 1:
                return exhibition.getName();
            case 2:
                return exhibition.getOpening();
            case 3:
                return exhibition.getDurationInDays();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return attributes[column];
    }

    public Exhibition getExhibition(int rowIndex) {
        return exhibitions.get(rowIndex);
    }
}
