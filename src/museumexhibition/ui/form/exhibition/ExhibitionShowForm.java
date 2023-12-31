package museumexhibition.ui.form.exhibition;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import museumexhibition.domain.Exhibition;
import museumexhibition.service.ExhibitionService;
import museumexhibition.service.impl.ExhibitionServiceImpl;
import museumexhibition.ui.table.model.ExhibitionDistinctTableModel;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class ExhibitionShowForm extends javax.swing.JDialog {

    private ExhibitionService exhibitionService;

    /**
     * Creates new form ExhibitionShowForm1
     */
    public ExhibitionShowForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        exhibitionService = new ExhibitionServiceImpl();
        populateTable();
        btnDelete.setVisible(false);
        btnDetails.setVisible(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblExhibition = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exhibitions");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblExhibition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblExhibition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExhibitionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExhibition);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDetails.setText("Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetails)
                        .addGap(342, 342, 342)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnDelete)
                    .addComponent(btnDetails))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblExhibition.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please, select a exhibition from the list.");
        } else {
            TableModel tm = tblExhibition.getModel();
            ExhibitionDistinctTableModel edtm = (ExhibitionDistinctTableModel) tm;
            Exhibition exhibition = edtm.getExhibition(selectedRow);

            int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete exhibition?", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    exhibitionService.delete(exhibition.getMuseum().getId(), exhibition.getOpening());
                    JOptionPane.showMessageDialog(this, "Exhibition is successfully deleted!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error:" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        populateTable();
    }//GEN-LAST:event_formWindowActivated

    private void tblExhibitionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExhibitionMouseClicked
        btnDelete.setVisible(true);
        btnDetails.setVisible(true);
    }//GEN-LAST:event_tblExhibitionMouseClicked

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        int selectedRow = tblExhibition.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please, select a exhibition from the list.");
        } else {
            TableModel tm = tblExhibition.getModel();
            ExhibitionDistinctTableModel edtm = (ExhibitionDistinctTableModel) tm;
            Exhibition exhibition = edtm.getExhibition(selectedRow);

            ExhibitionDetailsForm edf;
            try {
                edf = new ExhibitionDetailsForm(null, true, exhibition);
                edf.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ExhibitionShowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExhibition;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        try {
            List<Exhibition> exhibitions = exhibitionService.getDistinct();
            TableModel tm = new ExhibitionDistinctTableModel(exhibitions);
            tblExhibition.setModel(tm);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
