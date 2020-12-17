/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettose;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Locale;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Daniele
 */
public class InterfacciaGrafica extends javax.swing.JFrame {
//RENDO TUTTI I TABLE MODEL NON EDITABILI

    private final DefaultTableModel tb = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private final DefaultTableModel tb3 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final DefaultTableModel tb2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final DefaultTableModel tbEWO = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final DefaultTableModel tbStateEWO = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

//INIZIALIZZAZIONI DI VARIE VARIABILI GLOBALI E INIZIALIZZAZIONE DEI LIST MODEL UTILI
    String tipo = "";
    String interrompibile = "";
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel listModelVis = new DefaultListModel();
    DefaultListModel listModelComp = new DefaultListModel();
    DefaultListModel listModelSkills = new DefaultListModel();
    DefaultListModel listModelSkillsEwo = new DefaultListModel();
    DefaultListModel listModelSkillsEwo2 = new DefaultListModel();
    DefaultListModel listModelCompetence = new DefaultListModel();
    DefaultListModel listModelMaterial = new DefaultListModel();
    DefaultListModel listModelSite = new DefaultListModel();
    LocalDate date = LocalDate.now();//prendo la data attuale
    String giorno = String.valueOf(date.getDayOfWeek());//prendo il giorno attuale da 1 a 7
    Planner p;
    Admin a;
    List<String> materiali = new ArrayList<>();
    int id;
    List<String> skills = new ArrayList<>();
    Calendar cal = Calendar.getInstance(Locale.ITALY);

    /**
     * Creates new form InterfacciaGrafica
     */
    public InterfacciaGrafica() {

        initComponents();

        //rendo le prime 2 colonne delle 2 tabelle non selezionabili
        tabellaDisponibilità2.getColumnModel().setSelectionModel(new DefaultListSelectionModel() {
            private boolean isSelectable(int indice) {
                return !(indice == 1 || indice == 0);
            }

            @Override
            public void setSelectionInterval(int indice1, int indice2) {
                if (isSelectable(indice2) && isSelectable(indice1)) {
                    super.setSelectionInterval(indice1, indice2);
                } else {
                }
            }

            @Override
            public void addSelectionInterval(int indice1, int indice2) {
                if (isSelectable(indice1) && isSelectable(indice2)) {
                    super.addSelectionInterval(indice1, indice2);
                }
            }

        });
        tabellaDisponibilità.getColumnModel().setSelectionModel(new DefaultListSelectionModel() {
            private boolean isSelectable(int indice) {
                return !(indice == 1 || indice == 0);
            }

            @Override
            public void setSelectionInterval(int indice1, int indice2) {
                if (isSelectable(indice2) && isSelectable(indice1)) {
                    super.setSelectionInterval(indice1, indice2);
                } else {
                }
            }

            @Override
            public void addSelectionInterval(int indice1, int indice2) {
                if (isSelectable(indice1) && isSelectable(indice2)) {
                    super.addSelectionInterval(indice1, indice2);
                }
            }

        });

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
        panelCopertura = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabellaAttività = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panelCopertura2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaMaterialiVis = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaDescrizioneAttivitàVis = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaCompetenze = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaWorkspaceNotesVis = new javax.swing.JTextArea();
        buttonAssegna = new javax.swing.JButton();
        labelDE = new javax.swing.JLabel();
        buttonSMP = new javax.swing.JButton();
        labelCO = new javax.swing.JLabel();
        labelWO = new javax.swing.JLabel();
        labelML = new javax.swing.JLabel();
        buttonGestisciMateriali = new javax.swing.JButton();
        buttonModificaAttività = new javax.swing.JButton();
        buttonCreaAttività = new javax.swing.JButton();
        buttonMostraAttività = new javax.swing.JButton();
        buttonShowEWOState = new javax.swing.JButton();
        buttonCancellaAttività = new javax.swing.JButton();
        creazioneAttività = new javax.swing.JFrame();
        panelDX = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaDescrizioneAttività = new javax.swing.JTextArea();
        buttonCrea = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaWorkspace = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMateriali = new javax.swing.JList<>();
        buttonRimuoviMateriale = new javax.swing.JButton();
        panelSX = new javax.swing.JPanel();
        labelID = new javax.swing.JLabel();
        fieldID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tendinaTipologia = new javax.swing.JComboBox<>();
        labelTipologiaOra = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldTime = new javax.swing.JTextField();
        labelWeek = new javax.swing.JLabel();
        fieldWeek = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tendinaInterrompibile = new javax.swing.JComboBox<>();
        labelInterrompibileOra = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tendinaMateriali = new javax.swing.JComboBox<>();
        buttonAggiungiMateriale = new javax.swing.JButton();
        labelAttivitàOra = new javax.swing.JLabel();
        tendinaTipoAttività = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        fieldDay = new javax.swing.JTextField();
        labelID1 = new javax.swing.JLabel();
        tendinaSite = new javax.swing.JComboBox<>();
        labelSiteOra = new javax.swing.JLabel();
        assegnaAttività = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textWeekAssegnata = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textAttivitàDaAssegnare = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabellaDisponibilità = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        listaSkills = new javax.swing.JList<>();
        jButtonAssegnaAttività2 = new javax.swing.JButton();
        assegnaAttività2 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        labelWeekDisp = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldActivityToAssign2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        textAreaWorkspaceNotes2 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabellaDisponibilità2 = new javax.swing.JTable();
        labelDisponibilità = new javax.swing.JLabel();
        labelDayDisp = new javax.swing.JLabel();
        buttonForward = new javax.swing.JButton();
        labelSkillsEWO2 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        listSkillsEWO2 = new javax.swing.JList<>();
        labelOccupato = new javax.swing.JLabel();
        attivitàEWO = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        labelWeekEWO = new javax.swing.JLabel();
        labelDayEWO = new javax.swing.JLabel();
        labelActivityEWO = new javax.swing.JLabel();
        textFieldActivityEWO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        textAreaWNEWO = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        textAreaDescrizioneEWO = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        textFieldEstimatedtimeewo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        listSkillsEWO = new javax.swing.JList<>();
        buttonConfermaEwo = new javax.swing.JButton();
        buttonAddSkill = new javax.swing.JButton();
        buttonRemoveSkill = new javax.swing.JButton();
        tendinaSkills = new javax.swing.JComboBox<>();
        GestioneMateriali = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        materialList = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        buttonAddMaterial = new javax.swing.JButton();
        buttonRemoveMaterial = new javax.swing.JButton();
        buttonConfermaMateriale = new javax.swing.JButton();
        fieldInserisciMateriale = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        buttonModifyMaterial = new javax.swing.JButton();
        fieldMaterialeSelezionato = new javax.swing.JTextField();
        administrator = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        buttonGestisciCompetenze = new javax.swing.JButton();
        buttonManageSide = new javax.swing.JButton();
        manageCompetence = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        buttonAddCompetence = new javax.swing.JButton();
        buttonRemoveCompetence = new javax.swing.JButton();
        buttonModifyCompetence = new javax.swing.JButton();
        textFieldModifyCompetence = new javax.swing.JTextField();
        fieldInserisciCompetence = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        competenceList = new javax.swing.JList<>();
        buttonConfirmModifyCompetence = new javax.swing.JButton();
        manageSite = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        buttonAddSite = new javax.swing.JButton();
        buttonRemoveSite = new javax.swing.JButton();
        buttonModifySite = new javax.swing.JButton();
        fieldModifyFactorySite = new javax.swing.JTextField();
        fieldAddFactorySite = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        listSite = new javax.swing.JList<>();
        buttonConfirmModifySite = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        fieldAddArea = new javax.swing.JTextField();
        fieldModifyArea = new javax.swing.JTextField();
        EwoState = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tableEWO = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        tableStateEWO = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
                Object value = getModel().getValueAt(rowIndex,columnIndex);
                component.setBackground(Color.WHITE);
                component.setForeground(Color.BLACK);

                if (value!="-"){
                    if ((String)value == "Not Started"){
                        component.setBackground(Color.RED);
                    }
                    else if ((String)value == "In progress"){
                        component.setBackground(Color.YELLOW);
                    }
                    else if ((String)value == "Closed"){
                        component.setBackground(Color.GREEN);
                    }

                };
                return component;    }

        };
        labelDayState = new javax.swing.JLabel();
        labelWeekState = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buttonGestManut = new javax.swing.JButton();
        buttonAdministratorArea = new javax.swing.JButton();

        GestioneAttività.setTitle("MENU' GESTIONE ATTIVITA'");
        GestioneAttività.setMinimumSize(new java.awt.Dimension(1246, 650));
        GestioneAttività.setResizable(false);
        GestioneAttività.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                GestioneAttivitàWindowClosing(evt);
            }
        });
        GestioneAttività.getContentPane().setLayout(null);

        panelCopertura.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelCoperturaLayout = new javax.swing.GroupLayout(panelCopertura);
        panelCopertura.setLayout(panelCoperturaLayout);
        panelCoperturaLayout.setHorizontalGroup(
            panelCoperturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        panelCoperturaLayout.setVerticalGroup(
            panelCoperturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        GestioneAttività.getContentPane().add(panelCopertura);
        panelCopertura.setBounds(340, 20, 850, 280);

        tabellaAttività.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tabellaAttività.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tabellaAttività.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabellaAttività.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabellaAttività.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabellaAttività.setRowHeight(30);
        tabellaAttività.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaAttivitàMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabellaAttività);

        GestioneAttività.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(400, 30, 760, 250);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1400, 650));
        jPanel1.setLayout(null);

        panelCopertura2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelCopertura2Layout = new javax.swing.GroupLayout(panelCopertura2);
        panelCopertura2.setLayout(panelCopertura2Layout);
        panelCopertura2Layout.setHorizontalGroup(
            panelCopertura2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        panelCopertura2Layout.setVerticalGroup(
            panelCopertura2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(panelCopertura2);
        panelCopertura2.setBounds(0, 360, 1070, 240);

        jScrollPane8.setViewportView(listaMaterialiVis);

        jPanel1.add(jScrollPane8);
        jScrollPane8.setBounds(560, 450, 240, 150);

        textAreaDescrizioneAttivitàVis.setEditable(false);
        textAreaDescrizioneAttivitàVis.setColumns(20);
        textAreaDescrizioneAttivitàVis.setRows(5);
        textAreaDescrizioneAttivitàVis.setBorder(null);
        textAreaDescrizioneAttivitàVis.setDisabledTextColor(new java.awt.Color(102, 102, 255));
        textAreaDescrizioneAttivitàVis.setSelectionColor(new java.awt.Color(153, 153, 153));
        jScrollPane5.setViewportView(textAreaDescrizioneAttivitàVis);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(0, 450, 270, 150);

        jScrollPane4.setViewportView(listaCompetenze);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(810, 450, 240, 150);

        textAreaWorkspaceNotesVis.setEditable(false);
        textAreaWorkspaceNotesVis.setColumns(20);
        textAreaWorkspaceNotesVis.setRows(5);
        textAreaWorkspaceNotesVis.setBorder(null);
        jScrollPane7.setViewportView(textAreaWorkspaceNotesVis);

        jPanel1.add(jScrollPane7);
        jScrollPane7.setBounds(280, 450, 270, 150);

        buttonAssegna.setText("Assign Activity");
        buttonAssegna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssegnaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAssegna);
        buttonAssegna.setBounds(10, 260, 240, 40);

        labelDE.setBackground(new java.awt.Color(153, 204, 255));
        labelDE.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelDE.setForeground(new java.awt.Color(0, 0, 102));
        labelDE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDE.setText("DESCRIPTION");
        labelDE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        labelDE.setOpaque(true);
        jPanel1.add(labelDE);
        labelDE.setBounds(0, 420, 270, 30);

        buttonSMP.setText("Show SMP");
        buttonSMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSMPActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSMP);
        buttonSMP.setBounds(70, 380, 120, 30);

        labelCO.setBackground(new java.awt.Color(153, 204, 255));
        labelCO.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelCO.setForeground(new java.awt.Color(0, 0, 102));
        labelCO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCO.setText("NEEDED SKILLS");
        labelCO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        labelCO.setOpaque(true);
        jPanel1.add(labelCO);
        labelCO.setBounds(810, 420, 240, 30);

        labelWO.setBackground(new java.awt.Color(153, 204, 255));
        labelWO.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelWO.setForeground(new java.awt.Color(0, 0, 102));
        labelWO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWO.setText("WORKSPACE NOTES ");
        labelWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        labelWO.setOpaque(true);
        jPanel1.add(labelWO);
        labelWO.setBounds(280, 420, 270, 30);

        labelML.setBackground(new java.awt.Color(153, 204, 255));
        labelML.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelML.setForeground(new java.awt.Color(0, 0, 102));
        labelML.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelML.setText("MATERIAL LIST");
        labelML.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        labelML.setOpaque(true);
        jPanel1.add(labelML);
        labelML.setBounds(560, 420, 240, 30);

        buttonGestisciMateriali.setText("Manage materials");
        buttonGestisciMateriali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestisciMaterialiActionPerformed(evt);
            }
        });
        jPanel1.add(buttonGestisciMateriali);
        buttonGestisciMateriali.setBounds(10, 110, 240, 40);

        buttonModificaAttività.setText("Modify Activity");
        buttonModificaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificaAttivitàActionPerformed(evt);
            }
        });
        jPanel1.add(buttonModificaAttività);
        buttonModificaAttività.setBounds(10, 210, 240, 40);

        buttonCreaAttività.setText("Create Activity");
        buttonCreaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreaAttivitàActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCreaAttività);
        buttonCreaAttività.setBounds(10, 10, 240, 40);

        buttonMostraAttività.setText("Show Activity List");
        buttonMostraAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostraAttivitàActionPerformed(evt);
            }
        });
        jPanel1.add(buttonMostraAttività);
        buttonMostraAttività.setBounds(10, 60, 240, 40);

        buttonShowEWOState.setText("Show EWO State");
        buttonShowEWOState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowEWOStateActionPerformed(evt);
            }
        });
        jPanel1.add(buttonShowEWOState);
        buttonShowEWOState.setBounds(10, 160, 240, 40);

        buttonCancellaAttività.setText("Delete Activity");
        buttonCancellaAttività.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancellaAttivitàActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCancellaAttività);
        buttonCancellaAttività.setBounds(10, 310, 240, 40);

        GestioneAttività.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1230, 610);

        creazioneAttività.setMinimumSize(new java.awt.Dimension(1248, 573));
        creazioneAttività.setResizable(false);
        creazioneAttività.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                creazioneAttivitàWindowClosing(evt);
            }
        });
        creazioneAttività.getContentPane().setLayout(null);

        panelDX.setBackground(new java.awt.Color(0, 153, 153));
        panelDX.setLayout(null);

        jLabel12.setBackground(new java.awt.Color(255, 255, 204));
        jLabel12.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel12.setText("ACTIVITY DESCRIPTION");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel12.setOpaque(true);
        panelDX.add(jLabel12);
        jLabel12.setBounds(80, 40, 250, 30);

        jLabel19.setBackground(new java.awt.Color(255, 255, 204));
        jLabel19.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("MATERIAL LIST");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel19.setOpaque(true);
        panelDX.add(jLabel19);
        jLabel19.setBounds(80, 270, 240, 30);

        jLabel20.setBackground(new java.awt.Color(255, 255, 204));
        jLabel20.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("WORKSPACE NOTES");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel20.setOpaque(true);
        panelDX.add(jLabel20);
        jLabel20.setBounds(390, 40, 250, 30);

        textAreaDescrizioneAttività.setColumns(20);
        textAreaDescrizioneAttività.setRows(5);
        jScrollPane6.setViewportView(textAreaDescrizioneAttività);

        panelDX.add(jScrollPane6);
        jScrollPane6.setBounds(80, 70, 250, 140);

        buttonCrea.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonCrea.setText("ACTIVITY");
        buttonCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreaActionPerformed(evt);
            }
        });
        panelDX.add(buttonCrea);
        buttonCrea.setBounds(400, 320, 250, 81);

        textAreaWorkspace.setColumns(20);
        textAreaWorkspace.setRows(5);
        jScrollPane2.setViewportView(textAreaWorkspace);

        panelDX.add(jScrollPane2);
        jScrollPane2.setBounds(390, 70, 250, 140);

        jScrollPane1.setViewportView(listaMateriali);

        panelDX.add(jScrollPane1);
        jScrollPane1.setBounds(80, 300, 240, 130);

        buttonRimuoviMateriale.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonRimuoviMateriale.setText("Remove");
        buttonRimuoviMateriale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRimuoviMaterialeActionPerformed(evt);
            }
        });
        panelDX.add(buttonRimuoviMateriale);
        buttonRimuoviMateriale.setBounds(150, 440, 90, 30);

        creazioneAttività.getContentPane().add(panelDX);
        panelDX.setBounds(490, 0, 1030, 570);

        panelSX.setBackground(new java.awt.Color(255, 255, 204));
        panelSX.setLayout(null);

        labelID.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelID.setText("Activity ID");
        panelSX.add(labelID);
        labelID.setBounds(50, 90, 90, 20);

        fieldID.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        panelSX.add(fieldID);
        fieldID.setBounds(180, 80, 140, 30);

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel5.setText("Typology");
        panelSX.add(jLabel5);
        jLabel5.setBounds(50, 200, 80, 20);

        tendinaTipologia.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tendinaTipologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electrical", "Electronic", "Hydraulic", "Mechanical" }));
        panelSX.add(tendinaTipologia);
        tendinaTipologia.setBounds(180, 190, 140, 30);

        labelTipologiaOra.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelTipologiaOra.setText("(Now is");
        panelSX.add(labelTipologiaOra);
        labelTipologiaOra.setBounds(340, 190, 200, 30);

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel7.setText("Time");
        panelSX.add(jLabel7);
        jLabel7.setBounds(50, 250, 60, 20);

        fieldTime.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        panelSX.add(fieldTime);
        fieldTime.setBounds(180, 240, 140, 30);

        labelWeek.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelWeek.setText("Week");
        panelSX.add(labelWeek);
        labelWeek.setBounds(50, 290, 60, 32);

        fieldWeek.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        panelSX.add(fieldWeek);
        fieldWeek.setBounds(180, 290, 140, 30);

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel8.setText("Interruptible");
        panelSX.add(jLabel8);
        jLabel8.setBounds(50, 340, 110, 30);

        tendinaInterrompibile.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tendinaInterrompibile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        panelSX.add(tendinaInterrompibile);
        tendinaInterrompibile.setBounds(180, 340, 140, 30);

        labelInterrompibileOra.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelInterrompibileOra.setText("(Now is");
        panelSX.add(labelInterrompibileOra);
        labelInterrompibileOra.setBounds(340, 340, 210, 30);

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel9.setText("Materials");
        panelSX.add(jLabel9);
        jLabel9.setBounds(50, 410, 90, 20);

        tendinaMateriali.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        panelSX.add(tendinaMateriali);
        tendinaMateriali.setBounds(180, 400, 140, 30);

        buttonAggiungiMateriale.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonAggiungiMateriale.setText("Add");
        buttonAggiungiMateriale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAggiungiMaterialeActionPerformed(evt);
            }
        });
        panelSX.add(buttonAggiungiMateriale);
        buttonAggiungiMateriale.setBounds(340, 400, 82, 30);

        labelAttivitàOra.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelAttivitàOra.setText("(Now is");
        panelSX.add(labelAttivitàOra);
        labelAttivitàOra.setBounds(340, 40, 170, 30);

        tendinaTipoAttività.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tendinaTipoAttività.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planned", "EWO", "Extra" }));
        tendinaTipoAttività.setToolTipText("");
        tendinaTipoAttività.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tendinaTipoAttivitàItemStateChanged(evt);
            }
        });
        panelSX.add(tendinaTipoAttività);
        tendinaTipoAttività.setBounds(180, 40, 140, 30);

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setText("Tipo di attività");
        panelSX.add(jLabel1);
        jLabel1.setBounds(50, 40, 130, 30);

        labelDay.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelDay.setText("Day");
        labelDay.setEnabled(false);
        panelSX.add(labelDay);
        labelDay.setBounds(340, 290, 50, 30);

        fieldDay.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        fieldDay.setEnabled(false);
        panelSX.add(fieldDay);
        fieldDay.setBounds(400, 290, 90, 30);

        labelID1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelID1.setText("Site");
        panelSX.add(labelID1);
        labelID1.setBounds(50, 140, 90, 20);

        tendinaSite.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        panelSX.add(tendinaSite);
        tendinaSite.setBounds(180, 130, 140, 30);

        labelSiteOra.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        labelSiteOra.setText("(Now is");
        panelSX.add(labelSiteOra);
        labelSiteOra.setBounds(340, 130, 210, 30);

        creazioneAttività.getContentPane().add(panelSX);
        panelSX.setBounds(-30, 0, 590, 580);

        assegnaAttività.setMinimumSize(new java.awt.Dimension(1058, 350));
        assegnaAttività.setResizable(false);
        assegnaAttività.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                assegnaAttivitàWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                assegnaAttivitàWindowOpened(evt);
            }
        });
        assegnaAttività.getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 102, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(1058, 350));
        jPanel2.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 102));
        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WEEK");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 10, 80, 30);

        textWeekAssegnata.setEditable(false);
        jPanel2.add(textWeekAssegnata);
        textWeekAssegnata.setBounds(130, 10, 54, 30);

        jLabel13.setBackground(new java.awt.Color(255, 255, 102));
        jLabel13.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ACTIVITY TO ASSIGN");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel13.setOpaque(true);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(310, 10, 270, 40);

        textAttivitàDaAssegnare.setEditable(false);
        textAttivitàDaAssegnare.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jPanel2.add(textAttivitàDaAssegnare);
        textAttivitàDaAssegnare.setBounds(590, 10, 420, 40);

        jLabel15.setBackground(new java.awt.Color(255, 255, 102));
        jLabel15.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SKILLS NEEDED");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel15.setOpaque(true);
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 100, 230, 28);

        jLabel16.setBackground(new java.awt.Color(255, 255, 102));
        jLabel16.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("MAINTAINER AVAILABILITY");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel16.setOpaque(true);
        jPanel2.add(jLabel16);
        jLabel16.setBounds(310, 90, 700, 30);

        tabellaDisponibilità.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tabellaDisponibilità.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabellaDisponibilità.setRowHeight(30);
        jScrollPane10.setViewportView(tabellaDisponibilità);

        jPanel2.add(jScrollPane10);
        jScrollPane10.setBounds(307, 123, 700, 190);

        jScrollPane11.setViewportView(listaSkills);

        jPanel2.add(jScrollPane11);
        jScrollPane11.setBounds(10, 125, 229, 188);

        jButtonAssegnaAttività2.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jButtonAssegnaAttività2.setText("ASSIGN");
        jButtonAssegnaAttività2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssegnaAttività2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAssegnaAttività2);
        jButtonAssegnaAttività2.setBounds(40, 50, 171, 40);

        assegnaAttività.getContentPane().add(jPanel2);
        jPanel2.setBounds(-4, 0, 1060, 350);

        assegnaAttività2.setMinimumSize(new java.awt.Dimension(1233, 428));
        assegnaAttività2.setResizable(false);
        assegnaAttività2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                assegnaAttività2WindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                assegnaAttività2WindowOpened(evt);
            }
        });
        assegnaAttività2.getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));
        jPanel3.setMinimumSize(new java.awt.Dimension(1233, 428));
        jPanel3.setLayout(null);

        labelWeekDisp.setBackground(new java.awt.Color(255, 255, 102));
        labelWeekDisp.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelWeekDisp.setText("WEEK:");
        labelWeekDisp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        labelWeekDisp.setOpaque(true);
        jPanel3.add(labelWeekDisp);
        labelWeekDisp.setBounds(10, 13, 220, 26);

        jLabel17.setBackground(new java.awt.Color(255, 255, 102));
        jLabel17.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Activity to assign");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel17.setOpaque(true);
        jPanel3.add(jLabel17);
        jLabel17.setBounds(240, 10, 230, 30);

        jTextFieldActivityToAssign2.setEditable(false);
        jPanel3.add(jTextFieldActivityToAssign2);
        jTextFieldActivityToAssign2.setBounds(480, 10, 334, 30);

        jLabel18.setBackground(new java.awt.Color(255, 255, 102));
        jLabel18.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Workspace Notes");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel18.setOpaque(true);
        jPanel3.add(jLabel18);
        jLabel18.setBounds(10, 120, 220, 30);

        textAreaWorkspaceNotes2.setColumns(20);
        textAreaWorkspaceNotes2.setRows(5);
        jScrollPane9.setViewportView(textAreaWorkspaceNotes2);

        jPanel3.add(jScrollPane9);
        jScrollPane9.setBounds(10, 150, 222, 90);

        tabellaDisponibilità2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tabellaDisponibilità2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tabellaDisponibilità2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabellaDisponibilità2.setRowHeight(30);
        jScrollPane12.setViewportView(tabellaDisponibilità2);

        jPanel3.add(jScrollPane12);
        jScrollPane12.setBounds(239, 150, 937, 166);

        labelDisponibilità.setBackground(new java.awt.Color(255, 255, 102));
        labelDisponibilità.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelDisponibilità.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDisponibilità.setText("AVAILABILITY OF");
        labelDisponibilità.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        labelDisponibilità.setOpaque(true);
        jPanel3.add(labelDisponibilità);
        labelDisponibilità.setBounds(240, 120, 937, 30);

        labelDayDisp.setBackground(new java.awt.Color(255, 255, 102));
        labelDayDisp.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelDayDisp.setText("DAY:");
        labelDayDisp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        labelDayDisp.setOpaque(true);
        jPanel3.add(labelDayDisp);
        labelDayDisp.setBounds(10, 63, 220, 30);

        buttonForward.setText("FORWARD");
        buttonForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonForwardActionPerformed(evt);
            }
        });
        jPanel3.add(buttonForward);
        buttonForward.setBounds(590, 50, 128, 37);

        labelSkillsEWO2.setBackground(new java.awt.Color(255, 255, 102));
        labelSkillsEWO2.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelSkillsEWO2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSkillsEWO2.setText("SKILLS NEEDED");
        labelSkillsEWO2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelSkillsEWO2.setOpaque(true);
        jPanel3.add(labelSkillsEWO2);
        labelSkillsEWO2.setBounds(10, 240, 220, 30);

        jScrollPane17.setViewportView(listSkillsEWO2);

        jPanel3.add(jScrollPane17);
        jScrollPane17.setBounds(10, 270, 220, 130);

        labelOccupato.setBackground(new java.awt.Color(255, 255, 102));
        labelOccupato.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelOccupato.setText("*=OCCUPIED");
        labelOccupato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelOccupato.setOpaque(true);
        jPanel3.add(labelOccupato);
        labelOccupato.setBounds(650, 320, 120, 30);

        assegnaAttività2.getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1233, 428);

        attivitàEWO.setTitle("Additional info EWO");
        attivitàEWO.setMinimumSize(new java.awt.Dimension(812, 340));
        attivitàEWO.setResizable(false);
        attivitàEWO.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                attivitàEWOWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                attivitàEWOWindowOpened(evt);
            }
        });
        attivitàEWO.getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        jPanel5.setLayout(null);

        labelWeekEWO.setBackground(new java.awt.Color(255, 255, 153));
        labelWeekEWO.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelWeekEWO.setText("WEEK N°");
        labelWeekEWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelWeekEWO.setOpaque(true);
        jPanel5.add(labelWeekEWO);
        labelWeekEWO.setBounds(10, 16, 170, 25);

        labelDayEWO.setBackground(new java.awt.Color(255, 255, 153));
        labelDayEWO.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelDayEWO.setText("DAY");
        labelDayEWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelDayEWO.setOpaque(true);
        jPanel5.add(labelDayEWO);
        labelDayEWO.setBounds(10, 57, 170, 27);

        labelActivityEWO.setBackground(new java.awt.Color(255, 255, 153));
        labelActivityEWO.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelActivityEWO.setText("ACTIVITY TO ASSIGN");
        labelActivityEWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelActivityEWO.setOpaque(true);
        jPanel5.add(labelActivityEWO);
        labelActivityEWO.setBounds(250, 20, 180, 30);

        textFieldActivityEWO.setEditable(false);
        jPanel5.add(textFieldActivityEWO);
        textFieldActivityEWO.setBounds(430, 20, 260, 30);

        jLabel6.setBackground(new java.awt.Color(255, 255, 153));
        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel6.setText("WORKSPACE NOTES");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel6.setOpaque(true);
        jPanel5.add(jLabel6);
        jLabel6.setBounds(10, 110, 170, 31);

        textAreaWNEWO.setColumns(20);
        textAreaWNEWO.setRows(5);
        jScrollPane13.setViewportView(textAreaWNEWO);

        jPanel5.add(jScrollPane13);
        jScrollPane13.setBounds(10, 139, 170, 125);

        jLabel11.setBackground(new java.awt.Color(255, 255, 153));
        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel11.setText("INTERVENT DESCRIPTION");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel11.setOpaque(true);
        jPanel5.add(jLabel11);
        jLabel11.setBounds(250, 110, 210, 31);

        textAreaDescrizioneEWO.setColumns(20);
        textAreaDescrizioneEWO.setRows(5);
        jScrollPane14.setViewportView(textAreaDescrizioneEWO);

        jPanel5.add(jScrollPane14);
        jScrollPane14.setBounds(251, 139, 210, 110);

        jLabel22.setBackground(new java.awt.Color(255, 255, 153));
        jLabel22.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel22.setText("ESTIMATED TIME");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel22.setOpaque(true);
        jPanel5.add(jLabel22);
        jLabel22.setBounds(250, 250, 150, 30);
        jPanel5.add(textFieldEstimatedtimeewo);
        textFieldEstimatedtimeewo.setBounds(410, 250, 50, 30);

        jLabel23.setBackground(new java.awt.Color(255, 255, 153));
        jLabel23.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel23.setText("      SKILLS NEEDED");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel23.setOpaque(true);
        jPanel5.add(jLabel23);
        jLabel23.setBounds(510, 110, 180, 31);

        jScrollPane15.setViewportView(listSkillsEWO);

        jPanel5.add(jScrollPane15);
        jScrollPane15.setBounds(509, 139, 182, 121);

        buttonConfermaEwo.setText("CONFIRM");
        buttonConfermaEwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfermaEwoActionPerformed(evt);
            }
        });
        jPanel5.add(buttonConfermaEwo);
        buttonConfermaEwo.setBounds(530, 70, 142, 35);

        buttonAddSkill.setText("ADD");
        buttonAddSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSkillActionPerformed(evt);
            }
        });
        jPanel5.add(buttonAddSkill);
        buttonAddSkill.setBounds(510, 260, 80, 23);

        buttonRemoveSkill.setText("REMOVE");
        buttonRemoveSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveSkillActionPerformed(evt);
            }
        });
        jPanel5.add(buttonRemoveSkill);
        buttonRemoveSkill.setBounds(610, 260, 80, 23);

        tendinaSkills.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jPanel5.add(tendinaSkills);
        tendinaSkills.setBounds(700, 110, 100, 30);

        attivitàEWO.getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 810, 310);

        GestioneMateriali.setTitle("Material Management");
        GestioneMateriali.setMinimumSize(new java.awt.Dimension(480, 270));
        GestioneMateriali.setResizable(false);
        GestioneMateriali.getContentPane().setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));
        jPanel6.setLayout(null);

        materialList.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jScrollPane16.setViewportView(materialList);

        jPanel6.add(jScrollPane16);
        jScrollPane16.setBounds(280, 50, 178, 177);

        jLabel10.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MATERIAL LIST");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel10.setOpaque(true);
        jPanel6.add(jLabel10);
        jLabel10.setBounds(280, 10, 178, 36);

        buttonAddMaterial.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonAddMaterial.setText("Add material");
        buttonAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddMaterialActionPerformed(evt);
            }
        });
        jPanel6.add(buttonAddMaterial);
        buttonAddMaterial.setBounds(10, 30, 130, 30);

        buttonRemoveMaterial.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonRemoveMaterial.setText("Remove material");
        buttonRemoveMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveMaterialActionPerformed(evt);
            }
        });
        jPanel6.add(buttonRemoveMaterial);
        buttonRemoveMaterial.setBounds(10, 90, 130, 30);

        buttonConfermaMateriale.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonConfermaMateriale.setText("Confirm");
        buttonConfermaMateriale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfermaMaterialeActionPerformed(evt);
            }
        });
        jPanel6.add(buttonConfermaMateriale);
        buttonConfermaMateriale.setBounds(150, 190, 120, 30);

        fieldInserisciMateriale.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jPanel6.add(fieldInserisciMateriale);
        fieldInserisciMateriale.setBounds(150, 30, 120, 30);

        jLabel21.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MATERIAL");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel21.setOpaque(true);
        jPanel6.add(jLabel21);
        jLabel21.setBounds(150, 10, 120, 20);

        buttonModifyMaterial.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        buttonModifyMaterial.setText("Modify material");
        buttonModifyMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyMaterialActionPerformed(evt);
            }
        });
        jPanel6.add(buttonModifyMaterial);
        buttonModifyMaterial.setBounds(10, 150, 130, 30);

        fieldMaterialeSelezionato.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jPanel6.add(fieldMaterialeSelezionato);
        fieldMaterialeSelezionato.setBounds(150, 150, 120, 30);

        GestioneMateriali.getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 0, 630, 290);

        administrator.setTitle("Administrator Panel");
        administrator.setMinimumSize(new java.awt.Dimension(370, 200));
        administrator.setResizable(false);

        jPanel7.setBackground(new java.awt.Color(255, 0, 51));
        jPanel7.setMinimumSize(new java.awt.Dimension(370, 200));

        buttonGestisciCompetenze.setText("Manage Competence");
        buttonGestisciCompetenze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestisciCompetenzeActionPerformed(evt);
            }
        });

        buttonManageSide.setText("Manage Site");
        buttonManageSide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManageSideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonGestisciCompetenze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonManageSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(buttonGestisciCompetenze, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonManageSide, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout administratorLayout = new javax.swing.GroupLayout(administrator.getContentPane());
        administrator.getContentPane().setLayout(administratorLayout);
        administratorLayout.setHorizontalGroup(
            administratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        administratorLayout.setVerticalGroup(
            administratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        manageCompetence.setTitle("Competence management");
        manageCompetence.setMinimumSize(new java.awt.Dimension(499, 251));
        manageCompetence.getContentPane().setLayout(null);

        jPanel8.setBackground(new java.awt.Color(255, 0, 51));
        jPanel8.setMinimumSize(new java.awt.Dimension(500, 230));
        jPanel8.setName(""); // NOI18N
        jPanel8.setLayout(null);

        buttonAddCompetence.setText("Add competence");
        buttonAddCompetence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCompetenceActionPerformed(evt);
            }
        });
        jPanel8.add(buttonAddCompetence);
        buttonAddCompetence.setBounds(10, 32, 150, 30);

        buttonRemoveCompetence.setText("Remove competence");
        buttonRemoveCompetence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveCompetenceActionPerformed(evt);
            }
        });
        jPanel8.add(buttonRemoveCompetence);
        buttonRemoveCompetence.setBounds(10, 79, 150, 32);

        buttonModifyCompetence.setText("Modify competence");
        buttonModifyCompetence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyCompetenceActionPerformed(evt);
            }
        });
        jPanel8.add(buttonModifyCompetence);
        buttonModifyCompetence.setBounds(10, 129, 150, 33);
        jPanel8.add(textFieldModifyCompetence);
        textFieldModifyCompetence.setBounds(176, 129, 95, 33);
        jPanel8.add(fieldInserisciCompetence);
        fieldInserisciCompetence.setBounds(176, 32, 95, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("COMPETENCE");
        jPanel8.add(jLabel24);
        jLabel24.setBounds(180, 10, 95, 15);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("COMPETENCE LIST");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(335, 22, 140, 17);

        jScrollPane18.setViewportView(competenceList);

        jPanel8.add(jScrollPane18);
        jScrollPane18.setBounds(335, 45, 135, 130);

        buttonConfirmModifyCompetence.setText("Confirm");
        buttonConfirmModifyCompetence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmModifyCompetenceActionPerformed(evt);
            }
        });
        jPanel8.add(buttonConfirmModifyCompetence);
        buttonConfirmModifyCompetence.setBounds(176, 173, 95, 23);

        manageCompetence.getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 0, 500, 230);

        manageSite.setTitle("Site management");
        manageSite.setMinimumSize(new java.awt.Dimension(676, 282));
        manageSite.setResizable(false);
        manageSite.getContentPane().setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 0, 51));
        jPanel9.setLayout(null);

        buttonAddSite.setText("Add Site");
        buttonAddSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSiteActionPerformed(evt);
            }
        });
        jPanel9.add(buttonAddSite);
        buttonAddSite.setBounds(30, 30, 121, 30);

        buttonRemoveSite.setText("Remove Site");
        buttonRemoveSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveSiteActionPerformed(evt);
            }
        });
        jPanel9.add(buttonRemoveSite);
        buttonRemoveSite.setBounds(30, 70, 121, 32);

        buttonModifySite.setText("Modify Site");
        buttonModifySite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifySiteActionPerformed(evt);
            }
        });
        jPanel9.add(buttonModifySite);
        buttonModifySite.setBounds(30, 110, 121, 33);
        jPanel9.add(fieldModifyFactorySite);
        fieldModifyFactorySite.setBounds(180, 110, 110, 30);
        jPanel9.add(fieldAddFactorySite);
        fieldAddFactorySite.setBounds(180, 30, 110, 30);

        jLabel26.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel26.setText("FACTORY SITE");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(190, 10, 90, 24);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("SITE LIST");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(530, 20, 71, 17);

        jScrollPane19.setViewportView(listSite);

        jPanel9.add(jScrollPane19);
        jScrollPane19.setBounds(480, 40, 170, 150);

        buttonConfirmModifySite.setText("Confirm");
        buttonConfirmModifySite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmModifySiteActionPerformed(evt);
            }
        });
        jPanel9.add(buttonConfirmModifySite);
        buttonConfirmModifySite.setBounds(250, 150, 95, 23);

        jLabel14.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel14.setText("AREA");
        jPanel9.add(jLabel14);
        jLabel14.setBounds(350, 10, 34, 24);
        jPanel9.add(fieldAddArea);
        fieldAddArea.setBounds(310, 30, 110, 30);
        jPanel9.add(fieldModifyArea);
        fieldModifyArea.setBounds(310, 110, 110, 30);

        manageSite.getContentPane().add(jPanel9);
        jPanel9.setBounds(0, 0, 680, 300);

        EwoState.setTitle("EWO State");
        EwoState.setMinimumSize(new java.awt.Dimension(799, 398));
        EwoState.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                EwoStateWindowClosing(evt);
            }
        });
        EwoState.getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 153, 51));
        jPanel10.setLayout(null);

        tableEWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tableEWO.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tableEWO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableEWO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableEWO.setRowHeight(30);
        tableEWO.setRowSelectionAllowed(false);
        jScrollPane21.setViewportView(tableEWO);

        jPanel10.add(jScrollPane21);
        jScrollPane21.setBounds(0, 170, 510, 200);

        tableStateEWO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tableStateEWO.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        tableStateEWO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DEPARTMENT","MAINTAINER","STATE"
            }
        ));
        tableStateEWO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableStateEWO.setRowHeight(30);
        tableStateEWO.setRowSelectionAllowed(false);
        jScrollPane20.setViewportView(tableStateEWO);

        jPanel10.add(jScrollPane20);
        jScrollPane20.setBounds(510, 170, 270, 200);

        labelDayState.setBackground(new java.awt.Color(255, 255, 102));
        labelDayState.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelDayState.setText("DAY:");
        labelDayState.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelDayState.setOpaque(true);
        jPanel10.add(labelDayState);
        labelDayState.setBounds(10, 50, 160, 40);

        labelWeekState.setBackground(new java.awt.Color(255, 255, 102));
        labelWeekState.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelWeekState.setText("WEEK: ");
        labelWeekState.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelWeekState.setOpaque(true);
        jPanel10.add(labelWeekState);
        labelWeekState.setBounds(10, 10, 160, 40);

        jLabel29.setBackground(new java.awt.Color(255, 51, 51));
        jLabel29.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("ASSIGNED TICKETS");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel29.setOpaque(true);
        jPanel10.add(jLabel29);
        jLabel29.setBounds(270, 10, 500, 80);

        jLabel30.setBackground(new java.awt.Color(255, 255, 102));
        jLabel30.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("EWO");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel30.setOpaque(true);
        jPanel10.add(jLabel30);
        jLabel30.setBounds(0, 140, 510, 30);

        jLabel31.setBackground(new java.awt.Color(255, 255, 102));
        jLabel31.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("STATE");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel31.setOpaque(true);
        jPanel10.add(jLabel31);
        jLabel31.setBounds(510, 140, 270, 30);

        EwoState.getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 810, 410);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU' PRINCIPALE");
        setMinimumSize(new java.awt.Dimension(410, 210));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(null);

        buttonGestManut.setText(" Maintenance Management");
        buttonGestManut.setName(""); // NOI18N
        buttonGestManut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGestManutActionPerformed(evt);
            }
        });
        jPanel4.add(buttonGestManut);
        buttonGestManut.setBounds(80, 40, 210, 30);

        buttonAdministratorArea.setText("Administrator Area");
        buttonAdministratorArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdministratorAreaActionPerformed(evt);
            }
        });
        jPanel4.add(buttonAdministratorArea);
        buttonAdministratorArea.setBounds(80, 90, 210, 33);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 410, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGestManutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestManutActionPerformed
        try {
            p = new Planner("alessio", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(InterfacciaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        tendinaMateriali.removeAllItems();
        for (String m : p.getAllMaterials()) {
            tendinaMateriali.addItem(m);

        }
        tendinaSite.removeAllItems();
        for (Site s : p.getAllSites()) {
            tendinaSite.addItem(s.toString());
        }

        panelCopertura.setVisible(true);
        panelCopertura2.setVisible(true);
        GestioneAttività.setVisible(true);
        buttonModificaAttività.setVisible(false);
        buttonAssegna.setVisible(false);
        buttonCancellaAttività.setVisible(false);
        fieldDay.setText(giorno);

    }//GEN-LAST:event_buttonGestManutActionPerformed

    private void buttonCreaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaAttivitàActionPerformed
        //rendo la GUI organizzata per creare un'attività visto che è stato usato lo stesso JFRAME sia per la modifica che per la creazione
        disabilitaDay();
        fieldWeek.setEnabled(true);
        labelTipologiaOra.setVisible(false);
        labelAttivitàOra.setVisible(false);
        labelSiteOra.setVisible(false);
        labelInterrompibileOra.setVisible(false);
        fieldID.setEnabled(true);
        labelID.setEnabled(true);
        creazioneAttività.setVisible(true);
        buttonModificaAttività.setEnabled(false);
        labelTipologiaOra.setEnabled(false);
        labelAttivitàOra.setEnabled(false);
        labelSiteOra.setEnabled(false);
        labelInterrompibileOra.setEnabled(false);
        buttonCrea.setText("CREATE ACTIVITY");
        creazioneAttività.setTitle("Creazione Attività");

    }//GEN-LAST:event_buttonCreaAttivitàActionPerformed

    private void buttonCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreaActionPerformed

        if (fieldID.getText().equals("")
                || textAreaDescrizioneAttività.getText().equals("")
                || fieldTime.getText().equals("") || fieldWeek.getText().equals("")) {
            mostraErrore("ERRORE", "ALCUNI CAMPI OBBLIGATORI NON SONO STATI COMPILATI");
        } else {
            Activity a = buildActivity(tendinaTipoAttività.getSelectedItem().toString());
            if (a == null) {
                mostraErrore("ERRORE", "Input non corretti!");
            } else if (buttonCrea.getText().equals("CREATE ACTIVITY")) { //CASO IN CUI STO CREANDO L'ATTIVITA'
                try {
                    p.createActivity(a);
                    svuota();
                    mostraSuccesso("ATTIVITA' CREATA", "Hai creato l'attività correttamente!");
                } catch (Exception ex) {
                    mostraErrore("ERRORE", ex.getMessage());
                }
            } else {//CASO IN CUI STO MODIFICANDO L'ATTIVITA'
                a.setProcedure(p.getActivity(id).getProcedure());
                try {
                    p.modifyActivity(a);
                    svuota(); //resetto la gui usata
                    mostraSuccesso("ATTIVITA' MODIFICATA", "Hai modificato l'attività correttamente");
                    creazioneAttività.dispatchEvent(new WindowEvent(creazioneAttività, WindowEvent.WINDOW_CLOSING));
                } catch (Exception ex) {
                    mostraErrore("ERRORE", ex.getMessage());
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
            mostraErrore("ERRORE", "Materiale già inserito");
        }

        listaMateriali.setModel(listModel);


    }//GEN-LAST:event_buttonAggiungiMaterialeActionPerformed

    private void buttonCancellaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancellaAttivitàActionPerformed

        String s = JOptionPane.showInputDialog(null, "Inserisci l'ID da cancellare");
        if (s == null) {
        } else if (s.isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo ID vuoto", "ERRORE", ERROR_MESSAGE);
        } else {
            try {
                int id = Integer.parseInt(s);
                if (!p.deleteActivity(id)) {
                    mostraErrore("ERRORE", "Non è stato possibile cancellare l'attività");
                } else {
                    mostraSuccesso("CANCELLAZIONE EFFETTUATA", "Attività cancellata con successo!");
                    riempiTabella();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inserisci un ID valido", "ERRORE", ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_buttonCancellaAttivitàActionPerformed


    private void buttonMostraAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostraAttivitàActionPerformed
        panelCopertura.setVisible(false); //le finestre in basso sono coperte dal panel

        buttonCancellaAttività.setVisible(true);
        buttonModificaAttività.setVisible(true);
        buttonAssegna.setVisible(true);

        svuotaTabella(tb);
        riempiTabella();
        if (tb.getRowCount() == 0) {
            mostraErrore("ERRORE", "Nessuna attività trovata");
        }
    }//GEN-LAST:event_buttonMostraAttivitàActionPerformed

    private void buttonRimuoviMaterialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRimuoviMaterialeActionPerformed
        if (listaMateriali.getSelectedIndex() == -1) {
            mostraErrore("ERROR", "Seleziona un materiale dalla lista dei materiali da rimuovere");
        } else {
            materiali.remove(listaMateriali.getSelectedValue());
            listModel.removeElement(listaMateriali.getSelectedValue());
            listaMateriali.setModel(listModel);
        }
    }//GEN-LAST:event_buttonRimuoviMaterialeActionPerformed

    private void buttonModificaAttivitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificaAttivitàActionPerformed

        modifyActivitySet();//setto la finestra pronta per la modifica

        int indice = tabellaAttività.getSelectedRow();
        listModel.clear();
        if (indice == -1) {
            mostraErrore("ERRORE", "Seleziona una riga dalla tabella!");
        } else {
            if (!tabellaAttività.getValueAt(tabellaAttività.getSelectedRow(), 6).equals("EWO")) {
                disabilitaDay();
                fieldWeek.setEnabled(true);

            } else {
                fieldWeek.setEnabled(false);
                fieldDay.setVisible(true);
                labelDay.setVisible(true);
            }
            caseModifyActivity();//rendo visibili le giuste caselle
            id = Integer.parseInt(tb.getValueAt(tabellaAttività.getSelectedRow(), 0).toString());
            Activity a = p.getActivity(id);
            materiali = a.getMaterials();
            String tipo = "";
            switch (a.getType()) {//setto il tipo in base al type che ricevo
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

            setLabelModifyActivity();//riempio le text field con i dati attuali dell'attività

            if (tendinaTipoAttività.getSelectedItem().equals("EWO")) {
                fieldWeek.setEnabled(false);
                fieldWeek.setText(String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - 1));
                fieldDay.setText((date.getDayOfWeek().toString()));
                fieldDay.setVisible(true);
                fieldDay.setEnabled(false);
                labelDay.setVisible(true);
            } else {
                fieldWeek.setEnabled(true);
                fieldWeek.setText(String.valueOf(a.getWeek()));

            }

            for (String m : a.getMaterials()) {
                listModel.addElement(m);
            }
            listaMateriali.setModel(listModel);
        }

    }//GEN-LAST:event_buttonModificaAttivitàActionPerformed

    private void creazioneAttivitàWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_creazioneAttivitàWindowClosing
        buttonModificaAttività.setEnabled(true);
        if (buttonCrea.getText().equals(("MODIFY ACTIVITY"))) {
            riempiTabella(); //in caso di attività modificata riaggiorno la tabella
        }
        buttonCrea.setText("ACTIVITY");
        buttonCreaAttività.setEnabled(true);
        svuota();

    }//GEN-LAST:event_creazioneAttivitàWindowClosing

    private void buttonSMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSMPActionPerformed
        id = Integer.parseInt(tb.getValueAt(tabellaAttività.getSelectedRow(), 0).toString());
        Activity a = p.getActivity(id);
        if (a.getProcedure() == null) {
            mostraErrore("ERRORE", "Nessun SMP associato alla procedura");
        } else {
            try {
                Desktop.getDesktop().open(a.getProcedure().getSmp());
            } catch (IOException ex) {
                mostraErrore("ERRORE", "L'attività non ha associato nessuna SMP");
            } catch (IllegalArgumentException ex) {
                mostraErrore("ERRORE", "Path del PDF non esistente");
            }

        }


    }//GEN-LAST:event_buttonSMPActionPerformed

    private void tabellaAttivitàMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaAttivitàMouseClicked

        listModelVis.clear();
        listModelComp.clear();

        DefaultTableModel tb = (DefaultTableModel) tabellaAttività.getModel();
        listaCompetenze.setModel(listModelComp);
        listaMaterialiVis.setModel(listModel);
        int indice = tabellaAttività.getSelectedRow();
        if (indice == -1) {
            mostraErrore("ERRORE", "Seleziona una riga dalla tabella!");
        } else {

            panelCopertura2.setVisible(false);

            //mostro le info aggiuntive di ogni attività
            id = Integer.parseInt(tb.getValueAt(tabellaAttività.getSelectedRow(), 0).toString());
            showAdditionalInfo();
        }

    }//GEN-LAST:event_tabellaAttivitàMouseClicked

    private void buttonAssegnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssegnaActionPerformed

        int indice = tabellaAttività.getSelectedRow();
        if (indice == -1) {
            mostraErrore("ERRORE", "Seleziona un'attività dalla tabella!");
        } else {
            if (p.getActivity(id).getType() != 1) {//caso in cui l'attività da assegnare non è una EWO
                tabellaDisponibilità.setCellSelectionEnabled(true);
                tabellaDisponibilità.setRowSelectionAllowed(true);
                tabellaDisponibilità.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                labelOccupato.setVisible(false);
                casoNotEWO(); //qui gestisco il caso in cui non sia una EWO
            } else {

                if (date.getDayOfMonth() == p.getActivity(id).getDay()) {//GESTIONE DEL GIORNO DI ASSEGNAZIONE, LE EWO VANNO ASSEGNATE IL GIORNO IN CUI VENGONO CREATE
                    gestioneEWO();//caso in cui gestisco la EWO da assegnare
                    labelOccupato.setVisible(true);
                    tabellaDisponibilità.setEnabled(false);
                } else {
                    mostraErrore("ERRORE", "EWO Scaduto!");
                }

            }
        }
    }//GEN-LAST:event_buttonAssegnaActionPerformed

    private void jButtonAssegnaAttività2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssegnaAttività2ActionPerformed
        int indice = tabellaDisponibilità.getSelectedColumn();
        int colonna = tabellaDisponibilità.getSelectedColumn();
        int riga = tabellaDisponibilità.getSelectedRow();
        if (indice == -1) {
            mostraErrore("ERRORE", "Selezionare un giorno dalla tabella!");
        } else if (tabellaDisponibilità.getValueAt(riga, colonna).equals("0%")) {
            mostraErrore("ERRORE", "Il manutentore non ha disponibilità quel giorno, seleziona un altro giorno!");
        } else {
            resettaLabelDisp(); //resetto le label allo stato originale
            setFrameForAssign(riga, colonna); //setto il frame pronto per assegnare l'attività

        }

    }//GEN-LAST:event_jButtonAssegnaAttività2ActionPerformed

    private void buttonForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonForwardActionPerformed

        int riga;
        int c;
        if (p.getActivity(id).getType() != 1) {
            riga = tabellaDisponibilità.getSelectedRow();
            c = tabellaDisponibilità.getSelectedColumn();

        } else {

            riga = tabellaDisponibilità2.getSelectedRow();
            c = date.getDayOfWeek().getValue() + 2; //per concordanze con il DB, abbiamo dovuto modificare questo valore
            if (c == 9) { //c==9 significherebbe domenica per il metodo precedente
                c = 2; //c nelle prossime istruzioni verrà diminuito di 2 e quindi avrà valore "domenica"
            }
        }

        int[] oreSelezionate = tabellaDisponibilità2.getSelectedColumns();

        for (int i = 0; i < oreSelezionate.length; i++) {
            oreSelezionate[i] -= 2; //diminuiscono di 2 perchè le prime 2 colonne non vanno considerate

        }

        try {
            if (tabellaDisponibilità2.getSelectedRowCount() > 1) {
                mostraErrore("ERRORE", "Seleziona una riga alla volta");
            } else {
                p.assignedActivityToMaintainer(p.getAllMaintainers().get(riga), p.getActivity(id), c - 2, oreSelezionate); //c-2 poichè mi serve il giorno preciso da 0 domenica a 6 sabato
                mostraSuccesso("Attività assegnata!", "Attività assegnata con successo");
                aggiornaTabella2(); // aggiorno la prima tabella delle disponibilità
                resetPostEWO(); // resetto il frame dopo aver assegnato la ewo
                assegnaAttività2.setVisible(false);
                tabellaDisponibilità.setEnabled(true);
            }
        } catch (Exception ex) {

            mostraErrore("ERRORE", ex.getMessage());
        }


    }//GEN-LAST:event_buttonForwardActionPerformed

    private void GestioneAttivitàWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_GestioneAttivitàWindowClosing
        svuotaTabella(tb);
    }//GEN-LAST:event_GestioneAttivitàWindowClosing

    private void assegnaAttività2WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_assegnaAttività2WindowClosing
        tabellaDisponibilità.setEnabled(true); //sblocco la tabella delle disponibilità dopo aver assegnato l'attività
        tabellaAttività.setEnabled(true);
        resetPostEWO();

    }//GEN-LAST:event_assegnaAttività2WindowClosing

    private void buttonConfermaEwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfermaEwoActionPerformed

        Activity a = p.getActivity(id);
        try {
            //mi ricreo l'attività EWO
            EwoActivity b = new EwoActivity(a.getId(), a.getSite().getFactorySite(), a.getSite().getArea(), a.getTypology(), textAreaDescrizioneEWO.getText(),
                    Integer.parseInt(textFieldEstimatedtimeewo.getText()),
                    a.getWeek(), a.getMaterials(), a.isInterruptable(), textAreaWNEWO.getText(), a.getDay(), a.getProcedure());
            b.setSkills(skills);
            if (p.setEwoActivity(b)) {
                mostraSuccesso("EWO modificata!", "EWO modificata con successo");
                clearEwoFrame(); //pulisco il frame dopo aver confermato le modifiche
                attivitàEWO.setVisible(false);
                casoEWO();//caso di assegnazione di una EWO
            } else {
                mostraErrore("ERRORE", "Modifica non effettuata");
            }
        } catch (NumberFormatException e) {
            mostraErrore("ERRORE", "Campo estimated time non contiene tutti interi! ");
        }


    }//GEN-LAST:event_buttonConfermaEwoActionPerformed

    private void buttonAddSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSkillActionPerformed
        String skill = tendinaSkills.getSelectedItem().toString();
        skills.add(skill);
        if (listModelSkillsEwo.contains(skill) == false) {
            listModelSkillsEwo.addElement(skill);
        } else {
            mostraErrore("ERRORE", "Skill già inserita");
        }
        listSkillsEWO.setModel(listModelSkillsEwo);

    }//GEN-LAST:event_buttonAddSkillActionPerformed
    private void tendinaTipoAttivitàItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tendinaTipoAttivitàItemStateChanged

        //GESTIONE DEL CAMBIAMENTO DELLA TENDINA CON IL TIPO DI ATTIVITA'
        if (tendinaTipoAttività.getSelectedItem().equals("EWO")) {//CASO IN CUI SELEZIONO EWO, BLOCCO LA WEEK E IL GIORNO DA ASSEGNARE
            labelWeek.setEnabled(false);
            fieldWeek.setEnabled(false);
            fieldDay.setVisible(true);
            labelDay.setVisible(true);
            fieldDay.setText(giorno);
            fieldWeek.setText(String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - 1));

        } else {
            if (!buttonCrea.getText().equals(("MODIFY ACTIVITY"))) {
                labelWeek.setEnabled(true);
                fieldWeek.setEnabled(true);
                fieldDay.setVisible(false);
                labelDay.setVisible(false);
                fieldWeek.setText("");
                fieldDay.setText("");
            } else {
                labelWeek.setEnabled(true);
                fieldWeek.setEnabled(true);
                fieldDay.setVisible(false);
                labelDay.setVisible(false);
                fieldWeek.setText(String.valueOf(p.getActivity(id).getWeek()));
                fieldDay.setText("");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tendinaTipoAttivitàItemStateChanged

    private void attivitàEWOWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_attivitàEWOWindowClosing
        clearEwoFrame();
        tabellaAttività.setEnabled(true);
    }//GEN-LAST:event_attivitàEWOWindowClosing

    private void buttonRemoveSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveSkillActionPerformed
        if (listSkillsEWO.getSelectedIndex() == -1) {
            mostraErrore("ERROR", "Seleziona una skill dalla lista delle skills da rimuovere");
        } else {
            skills.remove(listSkillsEWO.getSelectedValue());
            listModelSkillsEwo.removeElement(listSkillsEWO.getSelectedValue());
            listSkillsEWO.setModel(listModelSkillsEwo);
        }
    }//GEN-LAST:event_buttonRemoveSkillActionPerformed

    private void buttonGestisciMaterialiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestisciMaterialiActionPerformed
        GestioneMateriali.setVisible(true);
        addMaterialsToList();
        materialList.setModel(listModelMaterial);
        fieldMaterialeSelezionato.setVisible(false);
        buttonConfermaMateriale.setVisible(false);
    }//GEN-LAST:event_buttonGestisciMaterialiActionPerformed

    private void buttonAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddMaterialActionPerformed
        fieldMaterialeSelezionato.setVisible(false);
        buttonConfermaMateriale.setVisible(false);
        if (fieldInserisciMateriale.getText().isBlank()) {
            mostraErrore("ERRORE", "Nessun materiale inserito");
        } else {
            String materiale = fieldInserisciMateriale.getText();
            if (!listModelMaterial.contains(materiale)) {
                p.createMaterial(materiale);
                listModelMaterial.addElement(materiale);
                fieldInserisciMateriale.setText("");
            } else {
                mostraErrore("ERRORE", "Materiale già presente");
            }
        }
    }//GEN-LAST:event_buttonAddMaterialActionPerformed

    private void buttonRemoveMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveMaterialActionPerformed
        fieldMaterialeSelezionato.setVisible(false);
        buttonConfermaMateriale.setVisible(false);
        if (materialList.getSelectedIndex() == -1) {
            mostraErrore("ERROR", "Seleziona un materiale dalla lista dei materiali da rimuovere");
        } else {
            listModelMaterial.removeElement(materialList.getSelectedValue());
            if (p.deleteMaterial(materialList.getSelectedValue())) {
                mostraSuccesso("Materiale rimosso", "Materiale rimosso con successo");
            }
        }
    }//GEN-LAST:event_buttonRemoveMaterialActionPerformed

    private void buttonModifyMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyMaterialActionPerformed
        if (materialList.getSelectedIndex() == -1) {
            mostraErrore("ERROR", "Seleziona un materiale dalla lista dei materiali");
        } else {
            fieldMaterialeSelezionato.setVisible(true);
            buttonConfermaMateriale.setVisible(true);
            fieldMaterialeSelezionato.setText(materialList.getSelectedValue());

        }
    }//GEN-LAST:event_buttonModifyMaterialActionPerformed

    private void buttonConfermaMaterialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfermaMaterialeActionPerformed
        if (p.modifyMaterial(materialList.getSelectedValue(), fieldMaterialeSelezionato.getText())) {
            mostraSuccesso("Materiale modificato!", "Materiale modificato con successo!");
            fieldMaterialeSelezionato.setVisible(false);
            buttonConfermaMateriale.setVisible(false);
            fieldMaterialeSelezionato.setText("");
            addMaterialsToList();
        } else {
            mostraErrore("ERRORE", "Materiale non modificato!");
        }

    }//GEN-LAST:event_buttonConfermaMaterialeActionPerformed

    private void buttonAdministratorAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdministratorAreaActionPerformed
        administrator.setVisible(true);
        try {
            a = new Admin("alessio", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(InterfacciaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAdministratorAreaActionPerformed

    private void buttonAddCompetenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCompetenceActionPerformed
        textFieldModifyCompetence.setVisible(false);
        buttonConfirmModifyCompetence.setVisible(false);
        if (fieldInserisciCompetence.getText().isBlank()) {
            mostraErrore("ERROR", "Nessuna competenza inserita");
        } else {
            String competenza = fieldInserisciCompetence.getText();
            if (!listModelCompetence.contains(competenza)) {
                a.createCompetence(competenza);
                listModelCompetence.addElement(competenza);
                fieldInserisciCompetence.setText("");
            } else {
                mostraErrore("ERROR", "Competenza già presente");
            }
        }
    }//GEN-LAST:event_buttonAddCompetenceActionPerformed

    private void buttonRemoveCompetenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveCompetenceActionPerformed
        textFieldModifyCompetence.setVisible(false);
        buttonConfirmModifyCompetence.setVisible(false);
        if (competenceList.getSelectedIndex() == -1) {
            mostraErrore("ERROR", "Seleziona una competenza dalla lista!");
        } else {
            listModelCompetence.removeElement(competenceList.getSelectedValue());
            a.deleteCompetence(competenceList.getSelectedValue());
        }
    }//GEN-LAST:event_buttonRemoveCompetenceActionPerformed

    private void buttonModifyCompetenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyCompetenceActionPerformed
        if (competenceList.getSelectedIndex() == -1) {
            mostraErrore("ERRORE", "Seleziona una competenza dalla lista!");
        } else {
            stateButtonCompetence(false);
            textFieldModifyCompetence.setVisible(true);
            buttonConfirmModifyCompetence.setVisible(true);
            textFieldModifyCompetence.setText(competenceList.getSelectedValue());
            competenceList.setEnabled(false);

        }
    }//GEN-LAST:event_buttonModifyCompetenceActionPerformed

    private void buttonConfirmModifyCompetenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmModifyCompetenceActionPerformed
        if (a.modifyCompetence(competenceList.getSelectedValue(), textFieldModifyCompetence.getText())) {
            mostraSuccesso("Materiale modificato!", "Materiale modificato con successo!");
            competenceList.setEnabled(true);
            stateButtonCompetence(true);
            textFieldModifyCompetence.setVisible(false);
            buttonConfirmModifyCompetence.setVisible(false);
            textFieldModifyCompetence.setText("");
            addSkillsToList();
        } else {
            mostraErrore("ERRORE", "Competenza non modificata!");
        }

    }//GEN-LAST:event_buttonConfirmModifyCompetenceActionPerformed

    private void buttonGestisciCompetenzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGestisciCompetenzeActionPerformed

        manageCompetence.setVisible(true);
        addSkillsToList();
        competenceList.setModel(listModelCompetence);
        textFieldModifyCompetence.setVisible(false);
        buttonConfirmModifyCompetence.setVisible(false);
    }//GEN-LAST:event_buttonGestisciCompetenzeActionPerformed

    private void buttonConfirmModifySiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmModifySiteActionPerformed
        Site nuovo = new Site(fieldModifyFactorySite.getText(), fieldModifyArea.getText());
        String[] x = listSite.getSelectedValue().split(", "); //prendo la stringa nella lista e la divido in 2 stringhe separate inizialmente da ", "

        Site vecchio = new Site(x[0], x[1]);
        if (a.modifySite(vecchio, nuovo)) {
            mostraSuccesso("Site modificato!", "Site modificato con successo!");
            stateButtonSite(true);
            addSitesToList();
            listSite.setEnabled(true);
            fieldModifyFactorySite.setText("");
            fieldModifyArea.setText("");
            stateModifySiteComp(false);

        } else {
            mostraErrore("ERRORE", "Site non modificato!");
        }

    }//GEN-LAST:event_buttonConfirmModifySiteActionPerformed

    private void buttonModifySiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifySiteActionPerformed
        if (listSite.getSelectedIndex() > -1) {
            stateModifySiteComp(true);
            listSite.setEnabled(false);
            String[] s = listSite.getSelectedValue().split(", ");
            fieldModifyFactorySite.setText(s[0]);
            fieldModifyArea.setText(s[1]);
            stateButtonSite(false);

        } else {
            mostraErrore("ERRORE", "Nessun site selezionato dalla lista da modificare!");
        }
    }//GEN-LAST:event_buttonModifySiteActionPerformed

    private void buttonRemoveSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveSiteActionPerformed
        if (listSite.getSelectedIndex() > -1) {
            String[] site = listSite.getSelectedValue().split(", ");
            Site s = new Site(site[0], site[1]);
            if (a.deleteSite(s)) {
                mostraSuccesso("Site eliminato", "Site eliminato con successo");
                listModelSite.removeElement(listSite.getSelectedValue());
            } else {
                mostraErrore("ERRORE!", "Non è stato possibile eliminare il site");
            }
        } else {
            mostraErrore("ERRORE", "Seleziona un site da rimuovere!");
        }

    }//GEN-LAST:event_buttonRemoveSiteActionPerformed

    private void buttonAddSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSiteActionPerformed
        stateModifySiteComp(false);
        if (fieldAddFactorySite.getText().isBlank() || fieldAddArea.getText().isBlank()) {
            mostraErrore("ERRORE", "Riempi i campi per la creazione del site!");
        } else {
            Site s = new Site(fieldAddFactorySite.getText(), fieldAddArea.getText());
            if (a.createSite(s)) {
                mostraSuccesso("SITE CREATO", "Site creato con successo!");
                fieldAddFactorySite.setText("");
                fieldAddArea.setText("");
                listModelSite.addElement(s.toString());
            } else {
                mostraErrore("ERRORE", "Site già presente!");
            }
        }
    }//GEN-LAST:event_buttonAddSiteActionPerformed

    private void buttonManageSideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManageSideActionPerformed
        manageSite.setVisible(true);

        addSitesToList();
        listSite.setModel(listModelSite);

        stateModifySiteComp(false);

    }//GEN-LAST:event_buttonManageSideActionPerformed

    private void buttonShowEWOStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowEWOStateActionPerformed

        resetStateEWO();

        labelWeekState.setText(labelWeekState.getText() + String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - 1));
        labelDayState.setText(labelDayState.getText() + date.getDayOfMonth());

        tableEWO.setModel(tbEWO);
        tableStateEWO.setModel(tbStateEWO);

        String[] nomiEWO = {"ID", "Area", "Type", "Estimated Time"};
        tbEWO.setColumnIdentifiers(nomiEWO);
        String[] nomiStateEWO = {"Department", "Area", "General State"};
        tbStateEWO.setColumnIdentifiers(nomiStateEWO);

        for (Activity a : p.getAllActivities()) {
            if (a.getType() == 1) {//prendo solamente le attività che sono di tipo EWO

                String[] ewo = {String.valueOf(a.getId()), a.getSite().getArea() + " - " + a.getSite().getFactorySite(), a.getTypology(), String.valueOf(a.getEstimatedTime())};
                tbEWO.addRow(ewo);
                String s = "";
                if (a.getDay() != date.getDayOfMonth()) {//se il giorno è diverso allora la EWO sarà terminata
                    s = "Closed";
                } else if (p.getEwoState(id)) {
                    s = "In progress";
                } else {
                    s = "Not Started";
                }
                String[] stato = {"-", "-", s};
                tbStateEWO.addRow(stato);
            }
        }
        if (tbEWO.getRowCount() > -1) {
            EwoState.setVisible(true);
        } else {
            mostraErrore("ERRORE", "Non esistono EWO");
        }

    }//GEN-LAST:event_buttonShowEWOStateActionPerformed

    private void EwoStateWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_EwoStateWindowClosing

        resetStateEWO();
    }//GEN-LAST:event_EwoStateWindowClosing

    private void assegnaAttivitàWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_assegnaAttivitàWindowOpened

        tabellaAttività.setEnabled(false);

    }//GEN-LAST:event_assegnaAttivitàWindowOpened

    private void assegnaAttività2WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_assegnaAttività2WindowOpened
        tabellaAttività.setEnabled(false);
        


    }//GEN-LAST:event_assegnaAttività2WindowOpened

    private void assegnaAttivitàWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_assegnaAttivitàWindowClosing
tabellaAttività.setEnabled(true);
    }//GEN-LAST:event_assegnaAttivitàWindowClosing

    private void attivitàEWOWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_attivitàEWOWindowOpened
tabellaAttività.setEnabled(false);

    }//GEN-LAST:event_attivitàEWOWindowOpened

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
            @Override
            public void run() {
                new InterfacciaGrafica().setVisible(true);
            }
        });
    }

    private void clearEwoFrame() {
        labelWeekEWO.setText("WEEK ");
        textFieldActivityEWO.setText("");
        textAreaWNEWO.setText("");
        textAreaDescrizioneEWO.setText("");
        listModelSkillsEwo.clear();
        textFieldEstimatedtimeewo.setText("");
        labelDayEWO.setText("DAY ");
        skills.clear();
        tendinaSkills.removeAllItems();
    }

    private void svuota() {
        materiali.clear();
        fieldID.setText("");
        fieldTime.setText("");
        fieldWeek.setText("");
        textAreaDescrizioneAttività.setText("");
        textAreaWorkspace.setText("");
        listModel.clear();
    }

    private Activity buildActivity(String tipoAttività) {
        Activity a;
        boolean b;
        if (tendinaInterrompibile.getSelectedItem().toString().equals("Si")) {
            b = true;
        } else {
            b = false;
        }

        String[] c = String.valueOf(tendinaSite.getSelectedItem()).split(", ");

        try {

            switch (tipoAttività) {
                case "Planned":
                    a = new PlannedActivity(Integer.parseInt(fieldID.getText()), c[0], c[1],
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText(), null);
                    break;
                case "EWO":
                    a = new EwoActivity(Integer.parseInt(fieldID.getText()), c[0], c[1],
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText(), date.getDayOfMonth(), null);
                    break;
                default:
                    a = new ExtraActivity(Integer.parseInt(fieldID.getText()), c[0], c[1],
                            tendinaTipologia.getSelectedItem().toString(),
                            textAreaDescrizioneAttività.getText(), Integer.parseInt(fieldTime.getText()),
                            Integer.parseInt(fieldWeek.getText()), materiali, b, textAreaWorkspace.getText(), null);
                    break;
            }
        } catch (NumberFormatException e) {

            return null;
        }
        return a;
    }

    private void riempiTabella() {
        svuotaTabella(tb);
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

            String[] inserimento = {String.valueOf(x.getId()), x.getSite().getFactorySite(), x.getSite().getArea(), x.getTypology(),
                String.valueOf(x.getEstimatedTime()), String.valueOf(x.getWeek()), tipo, interrompibile};
            tb.addRow(inserimento);
        }
    }

    private String[] calcolaPercentuale(int m[][]) { //Calcolo della percentuale di ogni manutentore durante i giorni
        String[] percentuali = new String[7];
        float sum = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                sum += m[i][j];
            }

            percentuali[i] = String.valueOf((int) (sum / 420 * 100)) + "%";
            sum = 0;

        }

        return percentuali;
    }

    private String contaCompetenze(List<String> competenzeAttività, List<String> competenzeMaintainer) {
        int count = 0;
        for (String c : competenzeAttività) {
            if (competenzeMaintainer.contains(c)) {
                count++;
            }
        }
        return count + "/" + competenzeAttività.size();
    }

    private void mostraErrore(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, ERROR_MESSAGE);
    }

    private void mostraSuccesso(String titolo, String messaggio) {
        JOptionPane.showMessageDialog(null, messaggio, titolo, INFORMATION_MESSAGE);
    }

    private String getComp(Activity a, Maintainer m) {
        String competenze;
        if (a.getProcedure() != null) {
            competenze = contaCompetenze(a.getProcedure().getCompetencies(), m.getCompetencies());
        } else // Se non è associata una procedura all'attività
        {
            competenze = "0/0";
        }
        return competenze;
    }

    private void svuotaTabella(DefaultTableModel tb) {
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
    }

    private void resettaLabelDisp() {
        labelWeekDisp.setText("WEEK:");
        labelDayDisp.setText("DAY:");
        labelDisponibilità.setText("AVAILABILITY OF");
    }

    private void aggiornaTabella3() {
        Activity a = p.getActivity(id);
        Maintainer m = p.getAllMaintainers().get(tabellaDisponibilità.getSelectedRow());
        int[][] disponibilità = m.getAvailability().get(a.getWeek());
        int[] ore;
        if (disponibilità == null) {
            ore = new int[7];
        } else {
            ore = disponibilità[tabellaDisponibilità.getSelectedColumn() - 2];
        }
        String[] nomi = {"Maintainer", "Skills", "08:00 to 9:00", "09:00 to 10:00", "10:00 to 11:00", "11:00 to 12:00", "12:00 to 13:00", "13:00 to 14:00", "14:00 to 15:00"};
        tb3.setColumnIdentifiers(nomi);
        String competenze = getComp(a, m);
        String[] inserimento = {m.getName(), competenze, String.valueOf(ore[0]) + " min",
            String.valueOf(ore[1]) + " min", String.valueOf(ore[2]) + " min",
            String.valueOf(ore[3]) + " min", String.valueOf(ore[4]) + " min",
            String.valueOf(ore[5]) + " min", String.valueOf(ore[6]) + " min"};
        tb3.addRow(inserimento);
        tabellaDisponibilità2.setModel(tb3);

    }

    private void aggiornaTabella2() {
        svuotaTabella(tb2);
        Activity a = p.getActivity(id);
        String[] nomi = {"Maintainer", "Skills", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        tb2.setColumnIdentifiers(nomi);
        tabellaDisponibilità.setModel(tb2);
        List<Maintainer> maintainers = p.getAllMaintainers();
        for (Maintainer m : maintainers) {
            int matrice[][] = m.getAvailability().get(a.getWeek());
            if (matrice != null) {
                String competenze = getComp(a, m);
                String[] percentuali = calcolaPercentuale(matrice);
                String[] inserimento
                        = {m.getName(), competenze,
                            percentuali[0], percentuali[1],
                            percentuali[2], percentuali[3],
                            percentuali[4], percentuali[5],
                            percentuali[6]};
                tb2.addRow(inserimento);
            }
        }

    }

    private void disabilitaDay() {
        fieldDay.setVisible(false);
        labelDay.setVisible(false);
    }

    private void gestioneEWO() {
        attivitàEWO.setVisible(true);
        id = Integer.parseInt(tb.getValueAt(tabellaAttività.getSelectedRow(), 0).toString());
        Activity a = p.getActivity(id);

        labelWeekEWO.setText(labelWeekEWO.getText() + " " + String.valueOf(a.getWeek()));
        labelDayEWO.setText(labelDay.getText() + " " + a.getDay());
        textFieldActivityEWO.setText(id + " - " + a.getSite().getFactorySite() + " - " + a.getSite().getArea() + " - " + a.getTypology());
        textAreaWNEWO.setText(String.valueOf(a.getWorkSpaceNote()));
        textAreaDescrizioneEWO.setText(String.valueOf(a.getActivityDescription()));
        textFieldEstimatedtimeewo.setText(String.valueOf(a.getEstimatedTime()));

        if (a.getProcedure() != null) {
            skills = a.getProcedure().getCompetencies();
            for (String s : a.getProcedure().getCompetencies()) {
                listModelSkillsEwo.addElement(s);
            }
        }

        listSkillsEWO.setModel(listModelSkillsEwo);

        for (String s : p.getAllSkills()) {
            tendinaSkills.addItem(s);
        }

    }

    private void casoNotEWO() {
        svuotaTabella(tb2);
        assegnaAttività.setTitle(("Disponibilità manutentori settimana " + tabellaAttività.getValueAt(tabellaAttività.getSelectedRow(), 5)));

        tabellaDisponibilità.setCellSelectionEnabled(true);
        Activity a = p.getActivity(id);
        listModelSkills.clear();
        if (a.getProcedure() != null) {
            List<String> competenze = a.getProcedure().getCompetencies();
            competenze.forEach(c -> {
                listModelSkills.addElement("·" + c);
            });
        }

        listaSkills.setModel(listModelSkills);
        textWeekAssegnata.setText(String.valueOf(a.getWeek()));
        textAttivitàDaAssegnare.setText(id + " - " + a.getSite().getFactorySite() + " - " + a.getSite().getArea() + " - " + a.getTypology() + " - " + a.getEstimatedTime() + " mins");

        aggiornaTabella2();

        if (tb2.getRowCount() == 0) {
            mostraErrore("ERRORE", "Nessun manutentore disponibile nella settimana " + a.getWeek());
            assegnaAttività.setVisible(false);
        } else {
            assegnaAttività.setVisible(true);
        }

    }

    private void casoEWO() {
        assegnaAttività2.setVisible(true);
        Activity a = p.getActivity(id);
        listSkillsEWO2.setVisible(true);
        labelSkillsEWO2.setVisible(true);
        labelDisponibilità.setText("MAINTAINERS AVAILABILITY");
        labelWeekDisp.setText(labelWeekDisp.getText() + " " + a.getWeek());
        labelDayDisp.setText((labelDayDisp.getText()) + " " + a.getDay());
        jTextFieldActivityToAssign2.setText(id + " - " + a.getSite().getFactorySite() + " - " + a.getSite().getArea() + " - "
                + a.getTypology() + " - " + a.getEstimatedTime() + " mins");
        textAreaWorkspaceNotes2.setText(a.getWorkSpaceNote());
        if (a.getProcedure() != null) {
            for (String s : a.getProcedure().getCompetencies()) {
                listModelSkillsEwo2.addElement(s);
            }
        }
        listSkillsEWO2.setModel(listModelSkillsEwo2);

        String[] nomi = {"Maintainer", "Skills", "08:00 to 9:00", "09:00 to 10:00", "10:00 to 11:00", "11:00 to 12:00", "12:00 to 13:00", "13:00 to 14:00", "14:00 to 15:00"};
        tb3.setColumnIdentifiers(nomi);
        tabellaDisponibilità2.setModel(tb3);
        tabellaDisponibilità2.setCellSelectionEnabled(true);
        tabellaDisponibilità2.setRowSelectionAllowed(true);
        tabellaDisponibilità2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        int n = 0;
        for (Maintainer m : p.getAllMaintainers()) {
            int[][] disp = m.getAvailability().get(a.getWeek());
            int[] ore;
            String competenze;

            if (disp == null) {
                ore = new int[7];
            } else {
                n = date.getDayOfWeek().getValue();
                if (n == 7) {
                    n = 0;
                }
                ore = disp[n];
            }

            String[] x = p.busyMaintainer(m, a.getWeek(), n);
            competenze = getComp(a, m);
            String[] inserimento = {m.getName(), competenze, String.valueOf(ore[0]) + " min" + x[0],
                String.valueOf(ore[1]) + " min" + x[1], String.valueOf(ore[2]) + " min" + x[2],
                String.valueOf(ore[3]) + " min" + x[3], String.valueOf(ore[4]) + " min" + x[4],
                String.valueOf(ore[5]) + " min" + x[5], String.valueOf(ore[6]) + " min" + x[6]};
            tb3.addRow(inserimento);

        }
    }

    private void resetPostEWO() {
        listModelSkillsEwo2.clear();
        labelWeekDisp.setText("WEEK: ");
        labelDayDisp.setText("DAY: ");
        svuotaTabella(tb3);
    }

    private void resetStateEWO() {
        labelWeekState.setText(("WEEK: "));
        labelDayState.setText("DAY: ");
        svuotaTabella(tbEWO);
        svuotaTabella(tbStateEWO);
    }

    private void stateModifySiteComp(boolean state) {
        fieldModifyFactorySite.setVisible(state);
        fieldModifyArea.setVisible(state);
        buttonConfirmModifySite.setVisible(state);
    }

    private void modifyActivitySet() {
        labelAttivitàOra.setText(("(Now is "));
        labelTipologiaOra.setText(("(Now is "));
        labelInterrompibileOra.setText(("(Now is "));
        labelSiteOra.setText(("(Now is "));
        labelInterrompibileOra.setVisible(true);
        labelAttivitàOra.setVisible(true);
        labelTipologiaOra.setVisible(true);
        labelSiteOra.setVisible(true);

    }

    private void caseModifyActivity() {
        creazioneAttività.setVisible(true);
        buttonModificaAttività.setEnabled(true);
        labelTipologiaOra.setEnabled(true);
        labelAttivitàOra.setEnabled(true);
        labelSiteOra.setEnabled(true);
        labelInterrompibileOra.setEnabled(true);
        fieldID.setEnabled(false);
        labelID.setEnabled(false);
        creazioneAttività.setTitle(("Modify Activity"));
        buttonCrea.setText("MODIFY ACTIVITY");
        buttonCreaAttività.setEnabled(false);
    }

    private void setLabelModifyActivity() {
        Activity a = p.getActivity(id);
        fieldID.setText(String.valueOf(a.getId()));
        labelAttivitàOra.setText(labelAttivitàOra.getText() + " " + tipo.toLowerCase() + ")");
        labelSiteOra.setText(labelSiteOra.getText() + a.getSite().toString() + ")");
        labelTipologiaOra.setText((labelTipologiaOra.getText()) + " " + a.getTypology().toLowerCase() + ")");
        fieldTime.setText(String.valueOf(a.getEstimatedTime()));
        fieldWeek.setText(String.valueOf(a.getWeek()));
        labelInterrompibileOra.setText(labelInterrompibileOra.getText() + " " + a.isInterruptable() + ")");
        textAreaDescrizioneAttività.setText(a.getActivityDescription());
        textAreaWorkspace.setText(a.getWorkSpaceNote());
    }

    private void showAdditionalInfo() {
        Activity a = p.getActivity(id);
        textAreaDescrizioneAttivitàVis.setText(a.getActivityDescription());
        textAreaWorkspaceNotesVis.setText(a.getWorkSpaceNote());
        List<String> materiali = a.getMaterials();
        for (String m : materiali) {
            listModelVis.addElement(m);
        }
        listaMaterialiVis.setModel(listModelVis);
        if (a.getProcedure() != null) {
            List<String> competenze = a.getProcedure().getCompetencies();
            for (String c : competenze) {
                listModelComp.addElement("·" + c);
            }
        }

    }

    private void setFrameForAssign(int riga, int colonna) {
        textAreaWorkspaceNotes2.setEditable(false);

        assegnaAttività2.setVisible(true);
        tabellaDisponibilità.setEnabled(false);
        Activity a = p.getActivity(id);

        //setto tutte le informazioni necessarie
        assegnaAttività2.setTitle("Disponibilità di " + tabellaDisponibilità.getValueAt(tabellaDisponibilità.getSelectedRow(), 0) + " "
                + "nel giorno  " + tb2.getColumnName(tabellaDisponibilità.getSelectedColumn()).toLowerCase());
        textAreaWorkspaceNotes2.setText(String.valueOf(a.getWorkSpaceNote()));
        labelWeekDisp.setText(labelWeekDisp.getText() + " " + String.valueOf(a.getWeek()));
        labelDayDisp.setText(labelDayDisp.getText() + " " + tabellaDisponibilità.getColumnName(colonna));
        labelDisponibilità.setText((labelDisponibilità.getText()) + " " + tabellaDisponibilità.getValueAt(riga, 0) + " "
                + tabellaDisponibilità.getValueAt(riga, colonna));
        jTextFieldActivityToAssign2.setText(id + " - " + a.getSite().getFactorySite() + " - " + a.getSite().getArea() + " - "
                + a.getTypology() + " - " + a.getEstimatedTime() + " mins");

        tabellaDisponibilità2.setCellSelectionEnabled(true);
        svuotaTabella(tb3);
        aggiornaTabella3(); //aggiorno la tabella delle disponibilità diverse per minuti
    }

    private void stateButtonCompetence(boolean state) {
        buttonRemoveCompetence.setEnabled(state);
        buttonAddCompetence.setEnabled(state);
    }

    private void stateButtonSite(boolean state) {
        buttonAddSite.setEnabled(state);
        buttonRemoveSite.setEnabled(state);
    }

    private void addSkillsToList() {
        listModelCompetence.clear();
        for (String c : a.getAllSkills()) {
            listModelCompetence.addElement(c);
        }
    }

    private void addSitesToList() {
        listModelSite.clear();
        for (Site s : a.getAllSites()) {
            listModelSite.addElement(s.toString());
        }
    }

    private void addMaterialsToList() {
        listModelMaterial.clear();
        for (String s : p.getAllMaterials()) {
            listModelMaterial.addElement(s);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame EwoState;
    private javax.swing.JFrame GestioneAttività;
    private javax.swing.JFrame GestioneMateriali;
    private javax.swing.JFrame administrator;
    private javax.swing.JFrame assegnaAttività;
    private javax.swing.JFrame assegnaAttività2;
    private javax.swing.JFrame attivitàEWO;
    private javax.swing.JButton buttonAddCompetence;
    private javax.swing.JButton buttonAddMaterial;
    private javax.swing.JButton buttonAddSite;
    private javax.swing.JButton buttonAddSkill;
    private javax.swing.JButton buttonAdministratorArea;
    private javax.swing.JButton buttonAggiungiMateriale;
    private javax.swing.JButton buttonAssegna;
    private javax.swing.JButton buttonCancellaAttività;
    private javax.swing.JButton buttonConfermaEwo;
    private javax.swing.JButton buttonConfermaMateriale;
    private javax.swing.JButton buttonConfirmModifyCompetence;
    private javax.swing.JButton buttonConfirmModifySite;
    private javax.swing.JButton buttonCrea;
    private javax.swing.JButton buttonCreaAttività;
    private javax.swing.JButton buttonForward;
    private javax.swing.JButton buttonGestManut;
    private javax.swing.JButton buttonGestisciCompetenze;
    private javax.swing.JButton buttonGestisciMateriali;
    private javax.swing.JButton buttonManageSide;
    private javax.swing.JButton buttonModificaAttività;
    private javax.swing.JButton buttonModifyCompetence;
    private javax.swing.JButton buttonModifyMaterial;
    private javax.swing.JButton buttonModifySite;
    private javax.swing.JButton buttonMostraAttività;
    private javax.swing.JButton buttonRemoveCompetence;
    private javax.swing.JButton buttonRemoveMaterial;
    private javax.swing.JButton buttonRemoveSite;
    private javax.swing.JButton buttonRemoveSkill;
    private javax.swing.JButton buttonRimuoviMateriale;
    private javax.swing.JButton buttonSMP;
    private javax.swing.JButton buttonShowEWOState;
    private javax.swing.JList<String> competenceList;
    private javax.swing.JFrame creazioneAttività;
    private javax.swing.JTextField fieldAddArea;
    private javax.swing.JTextField fieldAddFactorySite;
    private javax.swing.JTextField fieldDay;
    private javax.swing.JTextField fieldID;
    private javax.swing.JTextField fieldInserisciCompetence;
    private javax.swing.JTextField fieldInserisciMateriale;
    private javax.swing.JTextField fieldMaterialeSelezionato;
    private javax.swing.JTextField fieldModifyArea;
    private javax.swing.JTextField fieldModifyFactorySite;
    private javax.swing.JTextField fieldTime;
    private javax.swing.JTextField fieldWeek;
    private javax.swing.JButton jButtonAssegnaAttività2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextFieldActivityToAssign2;
    private javax.swing.JLabel labelActivityEWO;
    private javax.swing.JLabel labelAttivitàOra;
    private javax.swing.JLabel labelCO;
    private javax.swing.JLabel labelDE;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelDayDisp;
    private javax.swing.JLabel labelDayEWO;
    private javax.swing.JLabel labelDayState;
    private javax.swing.JLabel labelDisponibilità;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelID1;
    private javax.swing.JLabel labelInterrompibileOra;
    private javax.swing.JLabel labelML;
    private javax.swing.JLabel labelOccupato;
    private javax.swing.JLabel labelSiteOra;
    private javax.swing.JLabel labelSkillsEWO2;
    private javax.swing.JLabel labelTipologiaOra;
    private javax.swing.JLabel labelWO;
    private javax.swing.JLabel labelWeek;
    private javax.swing.JLabel labelWeekDisp;
    private javax.swing.JLabel labelWeekEWO;
    private javax.swing.JLabel labelWeekState;
    private javax.swing.JList<String> listSite;
    private javax.swing.JList<String> listSkillsEWO;
    private javax.swing.JList<String> listSkillsEWO2;
    private javax.swing.JList<String> listaCompetenze;
    private javax.swing.JList<String> listaMateriali;
    private javax.swing.JList<String> listaMaterialiVis;
    private javax.swing.JList<String> listaSkills;
    private javax.swing.JFrame manageCompetence;
    private javax.swing.JFrame manageSite;
    private javax.swing.JList<String> materialList;
    private javax.swing.JPanel panelCopertura;
    private javax.swing.JPanel panelCopertura2;
    private javax.swing.JPanel panelDX;
    private javax.swing.JPanel panelSX;
    private javax.swing.JTable tabellaAttività;
    private javax.swing.JTable tabellaDisponibilità;
    private javax.swing.JTable tabellaDisponibilità2;
    private javax.swing.JTable tableEWO;
    private javax.swing.JTable tableStateEWO;
    private javax.swing.JComboBox<String> tendinaInterrompibile;
    private javax.swing.JComboBox<String> tendinaMateriali;
    private javax.swing.JComboBox<String> tendinaSite;
    private javax.swing.JComboBox<String> tendinaSkills;
    private javax.swing.JComboBox<String> tendinaTipoAttività;
    private javax.swing.JComboBox<String> tendinaTipologia;
    private javax.swing.JTextArea textAreaDescrizioneAttività;
    private javax.swing.JTextArea textAreaDescrizioneAttivitàVis;
    private javax.swing.JTextArea textAreaDescrizioneEWO;
    private javax.swing.JTextArea textAreaWNEWO;
    private javax.swing.JTextArea textAreaWorkspace;
    private javax.swing.JTextArea textAreaWorkspaceNotes2;
    private javax.swing.JTextArea textAreaWorkspaceNotesVis;
    private javax.swing.JTextField textAttivitàDaAssegnare;
    private javax.swing.JTextField textFieldActivityEWO;
    private javax.swing.JTextField textFieldEstimatedtimeewo;
    private javax.swing.JTextField textFieldModifyCompetence;
    private javax.swing.JTextField textWeekAssegnata;
    // End of variables declaration//GEN-END:variables
}
