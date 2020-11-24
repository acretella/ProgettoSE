/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniele
 */
public class InterfacciaGrafica extends javax.swing.JFrame {

    private final DefaultTableModel tb = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    ArrayList<String> materiali = new ArrayList<>();
    DefaultListModel listModel = new DefaultListModel();
    Planner p;

    /**
     * Creates new form InterfacciaGrafica
     */
    public InterfacciaGrafica() {
        try {
            p = new Planner("alessio", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(InterfacciaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        GestioneAttività = new javax.swing.JFrame();
        buttonCreaAttività = new javax.swing.JButton();
        buttonMostraAttività = new javax.swing.JButton();
        buttonCancellaAttività = new javax.swing.JButton();
        buttonModificaAttività = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaAttività = new javax.swing.JTable();
        creazioneAttività = new javax.swing.JFrame();
        tendinaTipoAttività = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldID = new javax.swing.JTextField();
        fieldFactorySite = new javax.swing.JTextField();
        fieldArea = new javax.swing.JTextField();
        fieldTime = new javax.swing.JTextField();
        fieldWeek = new javax.swing.JTextField();
        tendinaMateriali = new javax.swing.JComboBox<>();
        buttonAggiungiMateriale = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaWorkspace = new javax.swing.JTextArea();
        buttonCrea = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaDescrizioneAttività = new javax.swing.JTextArea();
        tendinaTipologia = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMateriali = new javax.swing.JList<>();
        tendinaInterrompibile = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        buttonGestManut = new javax.swing.JButton();

        GestioneAttività.setTitle("MENU' GESTIONE ATTIVITA'");
        GestioneAttività.setMinimumSize(new java.awt.Dimension(600, 600));

        buttonCreaAttività.setText("Crea attività");
        buttonCreaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreaAttivitàActionPerformed(evt);
            }
        });

        buttonMostraAttività.setText("Mostra elenco attività");

        buttonCancellaAttività.setText("Cancella attività");
        buttonCancellaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancellaAttivitàActionPerformed(evt);
            }
        });

        buttonModificaAttività.setText("Modifica attività");

        tabellaAttività.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabellaAttività.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabellaAttività.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(tabellaAttività);

        javax.swing.GroupLayout GestioneAttivitàLayout = new javax.swing.GroupLayout(GestioneAttività.getContentPane());
        GestioneAttività.getContentPane().setLayout(GestioneAttivitàLayout);
        GestioneAttivitàLayout.setHorizontalGroup(
            GestioneAttivitàLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestioneAttivitàLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(GestioneAttivitàLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCreaAttività, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMostraAttività, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancellaAttività, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonModificaAttività, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        GestioneAttivitàLayout.setVerticalGroup(
            GestioneAttivitàLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestioneAttivitàLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(GestioneAttivitàLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GestioneAttivitàLayout.createSequentialGroup()
                        .addComponent(buttonCreaAttività)
                        .addGap(18, 18, 18)
                        .addComponent(buttonMostraAttività)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCancellaAttività)
                        .addGap(18, 18, 18)
                        .addComponent(buttonModificaAttività)))
                .addContainerGap(230, Short.MAX_VALUE))
        );

        creazioneAttività.setMinimumSize(new java.awt.Dimension(1100, 500));
        creazioneAttività.getContentPane().setLayout(null);

        tendinaTipoAttività.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planned", "EWO", "Extra" }));
        tendinaTipoAttività.setToolTipText("");
        creazioneAttività.getContentPane().add(tendinaTipoAttività);
        tendinaTipoAttività.setBounds(164, 31, 89, 20);

        jLabel1.setText("Tipo di attività da creare");
        creazioneAttività.getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 34, 144, 14);

        jLabel2.setText("Activity ID");
        creazioneAttività.getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 90, 70, 14);

        jLabel3.setText("Factory site");
        creazioneAttività.getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 130, 80, 14);

        jLabel4.setText("Area");
        creazioneAttività.getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 170, 60, 14);

        jLabel5.setText("Typology");
        creazioneAttività.getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 210, 70, 14);

        jLabel6.setText("Activity description");
        creazioneAttività.getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 40, 140, 14);

        jLabel7.setText("Time");
        creazioneAttività.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 260, 50, 14);

        jLabel8.setText("Interruptible");
        creazioneAttività.getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 340, 80, 20);

        jLabel9.setText("Materials");
        creazioneAttività.getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 390, 70, 20);

        jLabel10.setText("Week");
        creazioneAttività.getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 300, 50, 14);

        jLabel11.setText("Workspace notes");
        creazioneAttività.getContentPane().add(jLabel11);
        jLabel11.setBounds(820, 40, 140, 14);
        creazioneAttività.getContentPane().add(fieldID);
        fieldID.setBounds(90, 80, 90, 30);

        fieldFactorySite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFactorySiteActionPerformed(evt);
            }
        });
        creazioneAttività.getContentPane().add(fieldFactorySite);
        fieldFactorySite.setBounds(90, 120, 90, 30);
        creazioneAttività.getContentPane().add(fieldArea);
        fieldArea.setBounds(90, 160, 90, 30);

        fieldTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTimeActionPerformed(evt);
            }
        });
        creazioneAttività.getContentPane().add(fieldTime);
        fieldTime.setBounds(90, 250, 90, 30);
        creazioneAttività.getContentPane().add(fieldWeek);
        fieldWeek.setBounds(90, 290, 90, 30);

        creazioneAttività.getContentPane().add(tendinaMateriali);
        tendinaMateriali.setBounds(90, 390, 90, 30);

        buttonAggiungiMateriale.setText("Aggiungi");
        buttonAggiungiMateriale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAggiungiMaterialeActionPerformed(evt);
            }
        });
        creazioneAttività.getContentPane().add(buttonAggiungiMateriale);
        buttonAggiungiMateriale.setBounds(200, 390, 82, 30);

        textAreaWorkspace.setColumns(20);
        textAreaWorkspace.setRows(5);
        jScrollPane2.setViewportView(textAreaWorkspace);

        creazioneAttività.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(740, 70, 250, 140);

        buttonCrea.setText("CREA ATTIVITA'");
        buttonCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreaActionPerformed(evt);
            }
        });
        creazioneAttività.getContentPane().add(buttonCrea);
        buttonCrea.setBounds(750, 320, 250, 81);

        textAreaDescrizioneAttività.setColumns(20);
        textAreaDescrizioneAttività.setRows(5);
        jScrollPane6.setViewportView(textAreaDescrizioneAttività);

        creazioneAttività.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(425, 69, 250, 140);

        tendinaTipologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electrical", "Electronic", "Hydraulic", "Mechanical" }));
        creazioneAttività.getContentPane().add(tendinaTipologia);
        tendinaTipologia.setBounds(90, 200, 90, 30);

        jScrollPane1.setViewportView(listaMateriali);

        creazioneAttività.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 300, 240, 130);

        tendinaInterrompibile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        creazioneAttività.getContentPane().add(tendinaInterrompibile);
        tendinaInterrompibile.setBounds(90, 340, 90, 30);

        jLabel12.setText("Material list");
        creazioneAttività.getContentPane().add(jLabel12);
        jLabel12.setBounds(520, 270, 100, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU' PRINCIPALE");

        buttonGestManut.setText("Gestione Manutenzione");
        buttonGestManut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestManutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(buttonGestManut)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(buttonGestManut)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGestManutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestManutActionPerformed

        GestioneAttività.setVisible(true);


    }//GEN-LAST:event_buttonGestManutActionPerformed

    private void buttonCreaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaAttivitàActionPerformed
        materiali.clear();

        creazioneAttività.setVisible(true);
        //*String[] opzioni ={"Planned","EWO","Extra"};
        //* JOptionPane.showOptionDialog(null, "Scegli il tipo di attività da creare","Selezione tipo di attività", WIDTH, HEIGHT, null, opzioni, EXIT_ON_CLOSE);
        //* creazioneAttività.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCreaAttivitàActionPerformed

    private void fieldTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTimeActionPerformed

    private void buttonCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaActionPerformed
        //*System.out.println(Integer.parseInt(fieldID.getText())+fieldFactorySite.getText()+fieldArea.getText()+tendinaTipologia.getSelectedItem().toString()+textAreaDescrizioneAttività.getText()
        //*+Integer.parseInt(fieldTime.getText())+Integer.parseInt(fieldWeek.getText())+ materiali+ textAreaWorkspace.getText());

        Activity a = new PlannedActivity(Integer.parseInt(fieldID.getText()), fieldFactorySite.getText(), fieldArea.getText(),
                tendinaTipologia.getSelectedItem().toString(),
                textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                Integer.parseInt(fieldWeek.getText()), materiali, textAreaWorkspace.getText());
        p.createActivity(a);


    }//GEN-LAST:event_buttonCreaActionPerformed

    private void buttonAggiungiMaterialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAggiungiMaterialeActionPerformed
        /*String materiale = fieldMateriale.getText();
        materiale = materiale.substring(0, 1).toUpperCase() + materiale.substring(1, materiale.length()).toLowerCase();
        if (materiale.equals("")) {
            JOptionPane.showMessageDialog(null, "INSERISCI UN MATERIALE DA AGGIUNGERE", "ERRORE", ERROR_MESSAGE);
        } else {
            materiali.add(materiale);
            listaMateriali.setModel(listModel);
            listModel.addElement(materiale);
            fieldMateriale.setText("");
        }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAggiungiMaterialeActionPerformed

    private void fieldFactorySiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFactorySiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFactorySiteActionPerformed

    private void buttonCancellaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancellaAttivitàActionPerformed

        
           int id=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserisci l'ID da cancellare"));
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancellaAttivitàActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacciaGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame GestioneAttività;
    private javax.swing.JButton buttonAggiungiMateriale;
    private javax.swing.JButton buttonCancellaAttività;
    private javax.swing.JButton buttonCrea;
    private javax.swing.JButton buttonCreaAttività;
    private javax.swing.JButton buttonGestManut;
    private javax.swing.JButton buttonModificaAttività;
    private javax.swing.JButton buttonMostraAttività;
    private javax.swing.JFrame creazioneAttività;
    private javax.swing.JTextField fieldArea;
    private javax.swing.JTextField fieldFactorySite;
    private javax.swing.JTextField fieldID;
    private javax.swing.JTextField fieldTime;
    private javax.swing.JTextField fieldWeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> listaMateriali;
    private javax.swing.JTable tabellaAttività;
    private javax.swing.JComboBox<String> tendinaInterrompibile;
    private javax.swing.JComboBox<String> tendinaMateriali;
    private javax.swing.JComboBox<String> tendinaTipoAttività;
    private javax.swing.JComboBox<String> tendinaTipologia;
    private javax.swing.JTextArea textAreaDescrizioneAttività;
    private javax.swing.JTextArea textAreaWorkspace;
    // End of variables declaration//GEN-END:variables
}
