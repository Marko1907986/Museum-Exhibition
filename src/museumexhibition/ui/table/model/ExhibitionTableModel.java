package museumexhibition.ui.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import museumexhibition.domain.Exhibition;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitionTableModel extends AbstractTableModel {

    private List<Exhibition> exhibitions;
    private String[] attributes = new String[]{"OPEN AT", "DURATION IN DAYS", "EXHIBITION", "MUSEUM", "EXHIBIT"};

    public ExhibitionTableModel(List<Exhibition> exhibitions) {
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
                return exhibition.getOpening();
            case 1:
                return exhibition.getDurationInDays();
            case 2:
                return exhibition.getName();
            case 3:
                return exhibition.getMuseum().getName();
            case 4:
                return exhibition.getExhibit().getName();
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

    public void addRow(Exhibition exhibition) {
        exhibitions.add(exhibition);
        fireTableDataChanged();
    }

    public List<Exhibition> getData() {
        return exhibitions;
    }
}
