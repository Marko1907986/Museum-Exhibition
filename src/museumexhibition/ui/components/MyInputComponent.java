package museumexhibition.ui.components;

import museumexhibition.validation.ValidationException;
import museumexhibition.validation.Validator;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MyInputComponent extends javax.swing.JPanel implements IMyInputPanel {

    private Validator validator;

    /**
     * Creates new form MyInputComponent
     */
    public MyInputComponent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblText = new javax.swing.JLabel();
        jtxtText = new javax.swing.JTextField();
        jlblError = new javax.swing.JLabel();

        jlblText.setText("jLabel1");

        jlblError.setForeground(new java.awt.Color(255, 0, 0));
        jlblError.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblText, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtText, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblText)
                    .addComponent(jtxtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlblError;
    private javax.swing.JLabel jlblText;
    private javax.swing.JTextField jtxtText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setStaticText(String text) {
        jlblText.setText(text);
    }

    @Override
    public void setInputText(String text) {
        jtxtText.setText(text);
    }

    @Override
    public void setErrorText(String text) {
        jlblError.setText(text);
    }

    @Override
    public String getValue() throws ValidationException {
        jlblError.setText("");
        String value = jtxtText.getText().trim();
        if (validator != null) {
            try {
                validator.validate(value);
            } catch (ValidationException e) {
                jlblError.setText(e.getMessage());
                throw e;
            }
        }
        return value;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

}