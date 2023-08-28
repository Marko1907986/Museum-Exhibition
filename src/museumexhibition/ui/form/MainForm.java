package museumexhibition.ui.form;

import museumexhibition.ui.form.city.CityNewForm;
import museumexhibition.ui.form.exhibit.ExhibitNewForm;
import museumexhibition.ui.form.exhibit.ExhibitSearchForm;
import museumexhibition.ui.form.exhibition.ExhibitionNewMultiplyForm;
import museumexhibition.ui.form.exhibition.ExhibitionShowForm;
import museumexhibition.ui.form.museum.MuseumNewForm;
import museumexhibition.ui.form.museum.MuseumShowForm;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmCity = new javax.swing.JMenu();
        jmCityNewItem = new javax.swing.JMenuItem();
        jmExhibit = new javax.swing.JMenu();
        jmExhibitNewItem = new javax.swing.JMenuItem();
        jmExhibitSearchItem = new javax.swing.JMenuItem();
        jmMuseum = new javax.swing.JMenu();
        jmMuseumNewItem = new javax.swing.JMenuItem();
        jmMuseumShowItem = new javax.swing.JMenuItem();
        jmExhibition = new javax.swing.JMenu();
        jmExhibitionNewMultiplyItem = new javax.swing.JMenuItem();
        jmExhibitionShowItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome!");

        jmCity.setText("City");

        jmCityNewItem.setText("Add city");
        jmCityNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCityNewItemActionPerformed(evt);
            }
        });
        jmCity.add(jmCityNewItem);

        jMenuBar1.add(jmCity);

        jmExhibit.setText("Exhibit");

        jmExhibitNewItem.setText("Add exhibit");
        jmExhibitNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExhibitNewItemActionPerformed(evt);
            }
        });
        jmExhibit.add(jmExhibitNewItem);

        jmExhibitSearchItem.setText("Search");
        jmExhibitSearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExhibitSearchItemActionPerformed(evt);
            }
        });
        jmExhibit.add(jmExhibitSearchItem);

        jMenuBar1.add(jmExhibit);

        jmMuseum.setText("Museum");

        jmMuseumNewItem.setText("Add museum");
        jmMuseumNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMuseumNewItemActionPerformed(evt);
            }
        });
        jmMuseum.add(jmMuseumNewItem);

        jmMuseumShowItem.setText("Show all");
        jmMuseumShowItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMuseumShowItemActionPerformed(evt);
            }
        });
        jmMuseum.add(jmMuseumShowItem);

        jMenuBar1.add(jmMuseum);

        jmExhibition.setText("Exhibition");

        jmExhibitionNewMultiplyItem.setText("Add multiply");
        jmExhibitionNewMultiplyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExhibitionNewMultiplyItemActionPerformed(evt);
            }
        });
        jmExhibition.add(jmExhibitionNewMultiplyItem);

        jmExhibitionShowItem.setText("Show exhibitions");
        jmExhibitionShowItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmExhibitionShowItemActionPerformed(evt);
            }
        });
        jmExhibition.add(jmExhibitionShowItem);

        jMenuBar1.add(jmExhibition);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmCityNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCityNewItemActionPerformed
        new CityNewForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmCityNewItemActionPerformed

    private void jmExhibitNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExhibitNewItemActionPerformed
        new ExhibitNewForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmExhibitNewItemActionPerformed

    private void jmMuseumNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMuseumNewItemActionPerformed
        new MuseumNewForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmMuseumNewItemActionPerformed

    private void jmExhibitSearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExhibitSearchItemActionPerformed
        new ExhibitSearchForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmExhibitSearchItemActionPerformed

    private void jmMuseumShowItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMuseumShowItemActionPerformed
        new MuseumShowForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmMuseumShowItemActionPerformed

    private void jmExhibitionShowItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExhibitionShowItemActionPerformed
        new ExhibitionShowForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmExhibitionShowItemActionPerformed

    private void jmExhibitionNewMultiplyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmExhibitionNewMultiplyItemActionPerformed
        new ExhibitionNewMultiplyForm(this, true).setVisible(true);
    }//GEN-LAST:event_jmExhibitionNewMultiplyItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmCity;
    private javax.swing.JMenuItem jmCityNewItem;
    private javax.swing.JMenu jmExhibit;
    private javax.swing.JMenuItem jmExhibitNewItem;
    private javax.swing.JMenuItem jmExhibitSearchItem;
    private javax.swing.JMenu jmExhibition;
    private javax.swing.JMenuItem jmExhibitionNewMultiplyItem;
    private javax.swing.JMenuItem jmExhibitionShowItem;
    private javax.swing.JMenu jmMuseum;
    private javax.swing.JMenuItem jmMuseumNewItem;
    private javax.swing.JMenuItem jmMuseumShowItem;
    // End of variables declaration//GEN-END:variables
}
