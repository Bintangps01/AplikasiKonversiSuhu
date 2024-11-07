/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *\ * @author MyBook Z Series
 */
public class AplikasiKonversiSuhu extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiKonversiSuhu
     */
    public AplikasiKonversiSuhu() {
        initComponents();
        
        ((AbstractDocument) jTextField1.getDocument()).setDocumentFilter(new NumericDocumentFilter());

        // Menambahkan DocumentListener pada jTextField1
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateConversionResult();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateConversionResult();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateConversionResult();
            }
        });
        
        // Menambahkan ActionListener pada radio buttons untuk memperbarui hasil konversi saat memilih arah
        jRadioButton1.addActionListener(evt -> updateConversionResult());  // Kiri ke Kanan
        jRadioButton2.addActionListener(evt -> updateConversionResult());  // Kanan ke Kiri
    }

    // Metode untuk menghitung dan mengupdate hasil konversi
    private void updateConversionResult() {
        try {
            double suhu = Double.parseDouble(jTextField1.getText()); // Mengambil input suhu
            DecimalFormat numberFormat = new DecimalFormat("#.00"); // Format hasil dua angka desimal

            // Menentukan arah konversi (Kiri ke Kanan atau Kanan ke Kiri)
            boolean isLeftToRight = jRadioButton1.isSelected();  // true jika Kiri ke Kanan, false jika Kanan ke Kiri

            // Mendapatkan pilihan dari jComboBox1
            String selectedConversion = (String) jComboBox1.getSelectedItem();

            // Konversi suhu berdasarkan pilihan dan arah konversi
            double hasil = 0.0;
            if (selectedConversion.equals("Celcius dan Fahrenheit")) {
                if (isLeftToRight) {
                    hasil = (suhu * 9 / 5) + 32;  // Celcius ke Fahrenheit
                } else {
                    hasil = (suhu - 32) * 5 / 9;  // Fahrenheit ke Celcius
                }
            } else if (selectedConversion.equals("Celcius dan Kelvin")) {
                if (isLeftToRight) {
                    hasil = suhu + 273.15;  // Celcius ke Kelvin
                } else {
                    hasil = suhu - 273.15;  // Kelvin ke Celcius
                }
            } else if (selectedConversion.equals("Celcius dan Reamur")) {
                if (isLeftToRight) {
                    hasil = (4.0 / 5.0) * suhu;  // Celcius ke Reamur
                } else {
                    hasil = (suhu * 5) / 4;  // Reamur ke Celcius
                }
            } else if (selectedConversion.equals("Fahrenheit dan Kelvin")) {
                if (isLeftToRight) {
                    hasil = (suhu - 32) * 5 / 9 + 273.15;  // Fahrenheit ke Kelvin
                } else {
                    hasil = (suhu - 273.15) * 9 / 5 + 32;  // Kelvin ke Fahrenheit
                }
            } else if (selectedConversion.equals("Fahrenheit dan Reamur")) {
                if (isLeftToRight) {
                    hasil = (suhu - 32) * 4 / 9;  // Fahrenheit ke Reamur
                } else {
                    hasil = (suhu * 9 / 4) + 32;  // Reamur ke Fahrenheit
                }
            } else if (selectedConversion.equals("Kelvin dan Reamur")) {
                if (isLeftToRight) {
                    hasil = (suhu - 273.15) * 4 / 5;  // Kelvin ke Reamur
                } else {
                    hasil = (suhu * 5 / 4) + 273.15;  // Reamur ke Kelvin
                }
            }

            // Menampilkan hasil konversi di jTextField2
            jTextField2.setText(numberFormat.format(hasil));

        } catch (NumberFormatException e) {
            // Menangani jika input bukan angka yang valid
            jTextField2.setText("Input tidak valid");
        }
    }
    
    private static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (isNumeric(fb.getDocument().getText(0, fb.getDocument().getLength()) + string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isNumeric(fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset) + text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        // Cek apakah input hanya berupa angka dan satu desimal
        private boolean isNumeric(String text) {
            return text.matches("\\d*\\.?\\d*"); // Hanya angka dan satu titik desimal
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiKonversiSuhu().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 255, 153));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Aplikasi Konversi Suhu");
        jPanel3.add(jLabel5);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Masukan Suhu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 3, 3);
        jPanel1.add(jLabel1, gridBagConstraints);
        jLabel1.getAccessibleContext().setAccessibleName("Masukan Suhu Awal");

        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jTextField1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Hasil Konversi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(9, 3, 3, 3);
        jPanel1.add(jLabel2, gridBagConstraints);

        jTextField2.setEditable(false);
        jTextField2.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 19, 3);
        jPanel1.add(jTextField2, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celcius dan Fahrenheit", "Celcius dan Kelvin", "Celcius dan Reamur", "Fahrenheit dan Kelvin", "Fahrenheit dan Reamur", "Kelvin dan Reamur" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 16, 3);
        jPanel1.add(jComboBox1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Skala Suhu Konversi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Arah Konversi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel4, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jRadioButton1.setBackground(new java.awt.Color(153, 255, 204));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("Kiri Ke Kanan");
        jPanel2.add(jRadioButton1);

        jRadioButton2.setBackground(new java.awt.Color(153, 255, 204));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setLabel("Kanan ke Kiri");
        jPanel2.add(jRadioButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 16;
        jPanel1.add(jPanel2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1PropertyChange

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1InputMethodTextChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
