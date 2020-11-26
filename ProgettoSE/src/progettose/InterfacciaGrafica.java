/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.awt.event.WindowEvent;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
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
    String tipo = "";
    String interrompibile = "";
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel listModelVis = new DefaultListModel();
    Planner p;
    List<String> materiali = new ArrayList<>();

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

        for (String m : p.getAllMaterials()) {
            tendinaMateriali.addItem(m);

        }

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
        buttonVisualizzaInfo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaDescrizioneAttivitàVis = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaWorkspaceNotesVis = new javax.swing.JTextArea();
        labelLM = new javax.swing.JLabel();
        labelDE = new javax.swing.JLabel();
        labelWO = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaMaterialiVis = new javax.swing.JList<>();
        creazioneAttività = new javax.swing.JFrame();
        tendinaTipoAttività = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
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
        buttonRimuoviMateriale = new javax.swing.JButton();
        labelAttivitàOra = new javax.swing.JLabel();
        labelTipologiaOra = new javax.swing.JLabel();
        labelInterrompibileOra = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        buttonGestManut = new javax.swing.JButton();

        GestioneAttività.setTitle("MENU' GESTIONE ATTIVITA'");
        GestioneAttività.setMinimumSize(new java.awt.Dimension(1400, 600));
        GestioneAttività.getContentPane().setLayout(null);

        buttonCreaAttività.setText("Crea attività");
        buttonCreaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreaAttivitàActionPerformed(evt);
            }
        });
        GestioneAttività.getContentPane().add(buttonCreaAttività);
        buttonCreaAttività.setBounds(50, 40, 160, 40);

        buttonMostraAttività.setText("Mostra elenco attività");
        buttonMostraAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostraAttivitàActionPerformed(evt);
            }
        });
        GestioneAttività.getContentPane().add(buttonMostraAttività);
        buttonMostraAttività.setBounds(50, 90, 160, 40);

        buttonCancellaAttività.setText("Cancella attività");
        buttonCancellaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancellaAttivitàActionPerformed(evt);
            }
        });
        GestioneAttività.getContentPane().add(buttonCancellaAttività);
        buttonCancellaAttività.setBounds(50, 140, 160, 40);

        buttonModificaAttività.setText("Modifica attività");
        buttonModificaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificaAttivitàActionPerformed(evt);
            }
        });
        GestioneAttività.getContentPane().add(buttonModificaAttività);
        buttonModificaAttività.setBounds(970, 230, 160, 30);

        tabellaAttività.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabellaAttività.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabellaAttività.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(tabellaAttività);

        GestioneAttività.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(524, 31, 610, 188);

        buttonVisualizzaInfo.setText("Visualizza informazioni aggiuntive");
        buttonVisualizzaInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisualizzaInfoActionPerformed(evt);
            }
        });
        GestioneAttività.getContentPane().add(buttonVisualizzaInfo);
        buttonVisualizzaInfo.setBounds(530, 230, 242, 30);

        textAreaDescrizioneAttivitàVis.setEditable(false);
        textAreaDescrizioneAttivitàVis.setColumns(20);
        textAreaDescrizioneAttivitàVis.setRows(5);
        textAreaDescrizioneAttivitàVis.setBorder(null);
        jScrollPane5.setViewportView(textAreaDescrizioneAttivitàVis);

        GestioneAttività.getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(580, 330, 260, 150);

        textAreaWorkspaceNotesVis.setEditable(false);
        textAreaWorkspaceNotesVis.setColumns(20);
        textAreaWorkspaceNotesVis.setRows(5);
        textAreaWorkspaceNotesVis.setBorder(null);
        jScrollPane7.setViewportView(textAreaWorkspaceNotesVis);

        GestioneAttività.getContentPane().add(jScrollPane7);
        jScrollPane7.setBounds(870, 330, 270, 150);

        labelLM.setText("LISTA MATERIALI");
        GestioneAttività.getContentPane().add(labelLM);
        labelLM.setBounds(370, 300, 166, 30);

        labelDE.setText("DESCRIPTION");
        GestioneAttività.getContentPane().add(labelDE);
        labelDE.setBounds(670, 300, 166, 30);

        labelWO.setText("WORKSPACE NOTES");
        GestioneAttività.getContentPane().add(labelWO);
        labelWO.setBounds(940, 300, 166, 30);

        jScrollPane8.setViewportView(listaMaterialiVis);

        GestioneAttività.getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(290, 330, 250, 150);

        creazioneAttività.setMinimumSize(new java.awt.Dimension(1100, 600));
        creazioneAttività.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                creazioneAttivitàWindowClosing(evt);
            }
        });
        creazioneAttività.getContentPane().setLayout(null);

        tendinaTipoAttività.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planned", "EWO", "Extra" }));
        tendinaTipoAttività.setToolTipText("");
        creazioneAttività.getContentPane().add(tendinaTipoAttività);
        tendinaTipoAttività.setBounds(90, 30, 89, 30);

        jLabel1.setText("Tipo di attività");
        creazioneAttività.getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 40, 144, 14);

        labelID.setText("Activity ID");
        creazioneAttività.getContentPane().add(labelID);
        labelID.setBounds(10, 90, 70, 14);

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

        fieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIDActionPerformed(evt);
            }
        });
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

        buttonCrea.setText("ATTIVITA'");
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

        buttonRimuoviMateriale.setText("Rimuovi");
        buttonRimuoviMateriale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRimuoviMaterialeActionPerformed(evt);
            }
        });
        creazioneAttività.getContentPane().add(buttonRimuoviMateriale);
        buttonRimuoviMateriale.setBounds(500, 440, 90, 30);

        labelAttivitàOra.setText("(Now is");
        creazioneAttività.getContentPane().add(labelAttivitàOra);
        labelAttivitàOra.setBounds(200, 30, 170, 30);

        labelTipologiaOra.setText("(Now is");
        creazioneAttività.getContentPane().add(labelTipologiaOra);
        labelTipologiaOra.setBounds(210, 200, 170, 30);

        labelInterrompibileOra.setText("(Now is");
        creazioneAttività.getContentPane().add(labelInterrompibileOra);
        labelInterrompibileOra.setBounds(210, 340, 170, 30);

        jLabel14.setText("jLabel14");

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
        disattivaVis();
    }//GEN-LAST:event_buttonGestManutActionPerformed

    private void buttonCreaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaAttivitàActionPerformed
        labelTipologiaOra.setVisible(false);
        labelAttivitàOra.setVisible(false);
        labelInterrompibileOra.setVisible(false);
        fieldID.setEnabled(true);
        labelID.setEnabled(true);
        creazioneAttività.setVisible(true);
        buttonModificaAttività.setEnabled(false);
        labelTipologiaOra.setEnabled(false);
        labelAttivitàOra.setEnabled(false);
        labelInterrompibileOra.setEnabled(false);
        buttonCrea.setText("CREA ATTIVITA'");
        //*String[] opzioni ={"Planned","EWO","Extra"};
        //* JOptionPane.showOptionDialog(null, "Scegli il tipo di attività da creare","Selezione tipo di attività", WIDTH, HEIGHT, null, opzioni, EXIT_ON_CLOSE);
        //* creazioneAttività.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCreaAttivitàActionPerformed

    private void fieldTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTimeActionPerformed

    private void buttonCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaActionPerformed

        if (fieldID.getText().equals("") || fieldFactorySite.getText().equals("") || fieldArea.getText().equals("")
                || textAreaDescrizioneAttività.getText().equals("")
                || fieldTime.getText().equals("") || fieldWeek.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ALCUNI CAMPI OBBLIGATORI NON SONO STATI COMPILATI", "ERRORE", ERROR_MESSAGE);
        } else {
            Activity a = buildActivity(tendinaTipoAttività.getSelectedItem().toString());
            if (a == null) {
                JOptionPane.showMessageDialog(null, "Input non corretti!", "ERRORE", ERROR_MESSAGE);
            } else if (buttonCrea.getText().equals("CREA ATTIVITA'")) {
                if (!p.createActivity(a)) {
                    JOptionPane.showMessageDialog(null, "ATTIVITA' NON CREATA CORRETTAMENTE", "ERRORE", ERROR_MESSAGE);
                } else {
                    svuota();
                    JOptionPane.showMessageDialog(null, "Hai creato l'attività correttamente!", "ATTIVITA' CREATA", INFORMATION_MESSAGE);

                }

            } else {
                if (!p.modifyActivity(a)) {
                    JOptionPane.showMessageDialog(null, "ATTIVITA' NON MODIFICATA", "ERRORE", ERROR_MESSAGE);

                } else {
                    svuota();
                    JOptionPane.showMessageDialog(null, "Hai modificato l'attività correttamente!", "ATTIVITA' MODIFICATA", INFORMATION_MESSAGE);
                    creazioneAttività.dispatchEvent(new WindowEvent(creazioneAttività, WindowEvent.WINDOW_CLOSING));
                }
            }
        }
    }//GEN-LAST:event_buttonCreaActionPerformed

    private void buttonAggiungiMaterialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAggiungiMaterialeActionPerformed

        String materiale = tendinaMateriali.getSelectedItem().toString();
        materiali.add(materiale);
        if (listModel.contains(materiale) == false) {
            listModel.addElement(materiale);
        } else {
            JOptionPane.showMessageDialog(null, "Materiale già inserito", "ERRORE", ERROR_MESSAGE);
        }

        listaMateriali.setModel(listModel);


    }//GEN-LAST:event_buttonAggiungiMaterialeActionPerformed

    private void fieldFactorySiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFactorySiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFactorySiteActionPerformed

    private void buttonCancellaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancellaAttivitàActionPerformed

        String s = JOptionPane.showInputDialog(null, "Inserisci l'ID da cancellare");
        if (s == null) {
        } else if (s.isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo ID vuoto", "ERRORE", ERROR_MESSAGE);
        } else {
            try {
                int id = Integer.parseInt(s);
                if (!p.deleteActivity(id)) {
                    JOptionPane.showMessageDialog(null, "Non è stato possibile cancellare l'attività", "ERRORE", ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Attività cancellata con successo!", "CANCELLAZIONE EFFETTUATA", INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inserisci un ID valido", "ERRORE", ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_buttonCancellaAttivitàActionPerformed


    private void buttonMostraAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostraAttivitàActionPerformed
        buttonVisualizzaInfo.setVisible(true);
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        riempiTabella();
        if (tb.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nessuna attività trovata", "ERRORE", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonMostraAttivitàActionPerformed

    private void fieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIDActionPerformed

    private void buttonVisualizzaInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVisualizzaInfoActionPerformed
        listModelVis.clear();
        DefaultTableModel tb = (DefaultTableModel) tabellaAttività.getModel();
        listaMaterialiVis.setModel(listModel);
        int indice = tabellaAttività.getSelectedRow();
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "SELEZIONA UNA RIGA DELLA TABELLA!", "ERROR", ERROR_MESSAGE);
        } else {
            abilitaVis();
            Object temp = tb.getValueAt(indice, 0);
            String s = temp.toString();
            int id = Integer.parseInt(s);
            Activity a = p.getActivity(id);
            textAreaDescrizioneAttivitàVis.setText(a.getActivityDescription());
            textAreaWorkspaceNotesVis.setText(a.getWorkSpaceNote());
            List<String> materiali = a.getMaterials();
            for (String m : materiali) {
                listModelVis.addElement(m);
            }
            listaMaterialiVis.setModel(listModelVis);
        }
    }//GEN-LAST:event_buttonVisualizzaInfoActionPerformed

    private void buttonRimuoviMaterialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRimuoviMaterialeActionPerformed
        if (listaMateriali.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selezione un materiale dalla lista dei materiali da rimuovere", "ERROR", ERROR_MESSAGE);
        } else {
            materiali.remove(listaMateriali.getSelectedValue());
            listModel.removeElement(listaMateriali.getSelectedValue());
            listaMateriali.setModel(listModel);
        }
    }//GEN-LAST:event_buttonRimuoviMaterialeActionPerformed

    private void buttonModificaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificaAttivitàActionPerformed
        labelAttivitàOra.setText(("(Now is"));
        labelTipologiaOra.setText(("(Now is"));
        labelInterrompibileOra.setText(("(Now is"));
        labelInterrompibileOra.setVisible(true);
        labelAttivitàOra.setVisible(true);
        labelTipologiaOra.setVisible(true);
        int indice = tabellaAttività.getSelectedRow();
        listModel.clear();
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "SELEZIONA UNA RIGA DELLA TABELLA!", "ERROR", ERROR_MESSAGE);
        } else {
            creazioneAttività.setVisible(true);
            buttonModificaAttività.setEnabled(true);
            labelTipologiaOra.setEnabled(true);
            labelAttivitàOra.setEnabled(true);
            labelInterrompibileOra.setEnabled(true);
            fieldID.setEnabled(false);
            labelID.setEnabled(false);
            buttonCrea.setText("MODIFICA ATTIVITA'");
            buttonCreaAttività.setEnabled(false);
            Object temp = tb.getValueAt(indice, 0);
            String s = temp.toString();
            int id = Integer.parseInt(s);
            Activity a = p.getActivity(id);
            materiali = a.getMaterials();
            String tipo = "";
            switch (a.getType()) {
                case 0:
                    tipo = "Planned";
                    break;
                case 1:
                    tipo = "EWO";
                    break;
                default:
                    tipo = "Extra";
                    break;
            }
            fieldID.setText(String.valueOf(a.getId()));
            labelAttivitàOra.setText(labelAttivitàOra.getText() + " " + tipo.toLowerCase() + ")");
            fieldFactorySite.setText(a.getFactorySite());
            fieldArea.setText(a.getArea());
            labelTipologiaOra.setText((labelTipologiaOra.getText()) + " " + a.getTypology().toLowerCase() + ")");
            fieldTime.setText(String.valueOf(a.getEstimatedTime()));
            fieldWeek.setText(String.valueOf(a.getWeek()));
            labelInterrompibileOra.setText(labelInterrompibileOra.getText() + " " + a.isInterruptable() + ")");
            textAreaDescrizioneAttività.setText(a.getActivityDescription());
            textAreaWorkspace.setText(a.getWorkSpaceNote());
            for (String m : a.getMaterials()) {
                listModel.addElement(m);
            }
            listaMateriali.setModel(listModel);
        }

    }//GEN-LAST:event_buttonModificaAttivitàActionPerformed

    private void creazioneAttivitàWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_creazioneAttivitàWindowClosing
        buttonModificaAttività.setEnabled(true);
        buttonCrea.setText("ATTIVITA'");
        buttonCreaAttività.setEnabled(true);
        riempiTabella();
        svuota();
        // TODO add your handling code here:
    }//GEN-LAST:event_creazioneAttivitàWindowClosing

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

    private void svuota() {
        materiali.clear();
        fieldID.setText("");
        fieldFactorySite.setText("");
        fieldTime.setText("");
        fieldWeek.setText("");
        textAreaDescrizioneAttività.setText("");
        textAreaWorkspace.setText("");
        listModel.clear();
        fieldArea.setText("");
    }

    private void disattivaVis() {
        labelWO.setVisible(false);
        labelDE.setVisible(false);
        labelLM.setVisible(false);
        textAreaDescrizioneAttivitàVis.setVisible(false);
        textAreaWorkspaceNotesVis.setVisible(false);
        listaMaterialiVis.setVisible(false);
        buttonVisualizzaInfo.setVisible(false);
    }

    private Activity buildActivity(String tipoAttività) {
        Activity a;
        boolean b;
        if (tendinaInterrompibile.getSelectedItem().toString().equals("Si")) {
            b = true;
        } else {
            b = false;
        }
        try {
            switch (tipoAttività) {
                case "Planned":
                    a = new PlannedActivity(Integer.parseInt(fieldID.getText()), fieldFactorySite.getText(), fieldArea.getText(),
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText());
                    break;
                case "EWO":
                    a = new EwoActivity(Integer.parseInt(fieldID.getText()), fieldFactorySite.getText(), fieldArea.getText(),
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText());
                    break;
                default:
                    a = new ExtraActivity(Integer.parseInt(fieldID.getText()), fieldFactorySite.getText(), fieldArea.getText(),
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText());
                    break;
            }
        } catch (NumberFormatException e) {

            return null;
        }
        return a;
    }

    private void abilitaVis() {
        labelWO.setVisible(true);
        labelDE.setVisible(true);
        labelLM.setVisible(true);
        textAreaDescrizioneAttivitàVis.setVisible(true);
        textAreaWorkspaceNotesVis.setVisible(true);
        listaMaterialiVis.setVisible(true);

    }

    private void riempiTabella() {
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String[] nomi = {"ID", "Factory Site", "Area", "Typology", "Estimated Time", "Week", "Tipo", "Interrompibile"};
        tb.setColumnIdentifiers(nomi);
        tabellaAttività.setModel(tb);
        List<Activity> a;
        a = p.getAllActivities();
        for (Activity x : a) {
            switch (x.getType()) {
                case 0:
                    tipo = "Planned";
                    break;
                case 1:
                    tipo = "EWO";
                    break;
                default:
                    tipo = "Extra";
                    break;
            }
            if (x.isInterruptable() == true) {
                interrompibile = "Si";
            } else {
                interrompibile = "No";
            }

            String[] inserimento = {String.valueOf(x.getId()), x.getFactorySite(), x.getArea(), x.getTypology(),
                String.valueOf(x.getEstimatedTime()), String.valueOf(x.getWeek()), tipo, interrompibile};
            tb.addRow(inserimento);
        }
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
    private javax.swing.JButton buttonRimuoviMateriale;
    private javax.swing.JButton buttonVisualizzaInfo;
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
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel labelAttivitàOra;
    private javax.swing.JLabel labelDE;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelInterrompibileOra;
    private javax.swing.JLabel labelLM;
    private javax.swing.JLabel labelTipologiaOra;
    private javax.swing.JLabel labelWO;
    private javax.swing.JList<String> listaMateriali;
    private javax.swing.JList<String> listaMaterialiVis;
    private javax.swing.JTable tabellaAttività;
    private javax.swing.JComboBox<String> tendinaInterrompibile;
    private javax.swing.JComboBox<String> tendinaMateriali;
    private javax.swing.JComboBox<String> tendinaTipoAttività;
    private javax.swing.JComboBox<String> tendinaTipologia;
    private javax.swing.JTextArea textAreaDescrizioneAttività;
    private javax.swing.JTextArea textAreaDescrizioneAttivitàVis;
    private javax.swing.JTextArea textAreaWorkspace;
    private javax.swing.JTextArea textAreaWorkspaceNotesVis;
    // End of variables declaration//GEN-END:variables
}
