/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iudigital.crudfuncionarios.presentacion;

import com.iudigital.crudfuncionarios.controller.FuncionariosController;
import com.iudigital.crudfuncionarios.dominio.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Main2 extends javax.swing.JFrame {

    private final FuncionariosController funcionarioController;
    private static final String[] COLUMNAS = {"DOCUMENTO", "TIPO DOCUMENTO", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "ESTADO CIVIL", "SEXO", "DIRECCIÓN", "TELÉFONO", "FECHA NACIMIENTO"};
    private static final String SELECCIONE = "--SELECCIONE--";

    /**
     * Creates new form Main2
     */
    public Main2() {
        initComponents();
        txtDocumentoEditar.setEditable(false);
        funcionarioController = new FuncionariosController();
        listarFuncionarios();
        addListener();
    }

    private void listarFuncionarios() {

        cbxFuncionarios.removeAllItems();
        
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setFUN_NOMBRE(SELECCIONE);
        funcionario1.setFUN_APELLIDO_PATERNO("");
        funcionario1.setFUN_APELLIDO_MATERNO("");
        cbxFuncionarios.addItem(funcionario1);
        tblFuncionarios.removeAll();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMNAS : COLUMNAS) {
            defaultTableModel.addColumn(COLUMNAS);
        }

        tblFuncionarios.setModel(defaultTableModel);

        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getFUN_ID(), row, 0);
                defaultTableModel.setValueAt(funcionario.getIDEN_ID(), row, 1);
                defaultTableModel.setValueAt(funcionario.getFUN_NOMBRE(), row, 2);
                defaultTableModel.setValueAt(funcionario.getFUN_APELLIDO_PATERNO(), row, 3);
                defaultTableModel.setValueAt(funcionario.getFUN_APELLIDO_MATERNO(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEST_ID(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSEX_ID(), row, 6);
                defaultTableModel.setValueAt(funcionario.getFUN_DIRECCION(), row, 7);
                defaultTableModel.setValueAt(funcionario.getFUN_TELEFONO(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFUN_FECHA_NACIMIENTO(), row, 9);
                row++;
                cbxFuncionarios.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getFUN_NOMBRE().equals(SELECCIONE)) {
                txtDocumentoEditar.setText("");
                txtTipoIdentificacionEditar.setText("");
                txtNombreEditar.setText("");
                txtApellidoPaternoEditar.setText("");
                txtApellidoMaternoEditar.setText("");
                txtEstadoCivilEditar.setText("");
                txtSexoEditar.setText("");
                txtDireccionEditar.setText("");
                txtTelefonoEditar.setText("");
                txtFechaNacimientoEditar.setText("");
            }else{
                txtDocumentoEditar.setText(selectedFuncionario.getFUN_ID());
                txtTipoIdentificacionEditar.setText(String.valueOf(selectedFuncionario.getIDEN_ID()));
                txtNombreEditar.setText(selectedFuncionario.getFUN_NOMBRE());
                txtApellidoPaternoEditar.setText(selectedFuncionario.getFUN_APELLIDO_PATERNO());
                txtApellidoMaternoEditar.setText(selectedFuncionario.getFUN_APELLIDO_MATERNO());
                txtEstadoCivilEditar.setText(String.valueOf(selectedFuncionario.getEST_ID()));
                txtSexoEditar.setText(String.valueOf(selectedFuncionario.getSEX_ID()));
                txtDireccionEditar.setText(selectedFuncionario.getFUN_DIRECCION());
                txtTelefonoEditar.setText(selectedFuncionario.getFUN_TELEFONO());
                txtFechaNacimientoEditar.setText(selectedFuncionario.getFUN_FECHA_NACIMIENTO());
                
                System.out.println("selectedFuncionario = "+ selectedFuncionario);
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

        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFuncionario = new javax.swing.JPanel();
        jPFuncionario1 = new javax.swing.JPanel();
        lblDocumento = new javax.swing.JLabel();
        lblTipoIdentificacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtTipoIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jpEditar = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblDocumentoEditar = new javax.swing.JLabel();
        lblTipoIdentificacionEditar = new javax.swing.JLabel();
        lblNombreEditar = new javax.swing.JLabel();
        lblApellidoPaternoEditar = new javax.swing.JLabel();
        lblApellidoMaternoEditar = new javax.swing.JLabel();
        lblEstadoCivilEditar = new javax.swing.JLabel();
        lblSexoEditar = new javax.swing.JLabel();
        lblDireccionEditar = new javax.swing.JLabel();
        lblTelefonoEditar = new javax.swing.JLabel();
        lblFechaNacimientoEditar = new javax.swing.JLabel();
        txtDocumentoEditar = new javax.swing.JTextField();
        txtTipoIdentificacionEditar = new javax.swing.JTextField();
        txtNombreEditar = new javax.swing.JTextField();
        txtApellidoPaternoEditar = new javax.swing.JTextField();
        txtApellidoMaternoEditar = new javax.swing.JTextField();
        txtEstadoCivilEditar = new javax.swing.JTextField();
        txtSexoEditar = new javax.swing.JTextField();
        txtDireccionEditar = new javax.swing.JTextField();
        txtTelefonoEditar = new javax.swing.JTextField();
        txtFechaNacimientoEditar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("GESTION DE FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jPFuncionario1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblDocumento.setText("DOCUMENTO:");

        lblTipoIdentificacion.setText("TIPO DE IDENTIFICACIÓN:");

        lblNombre.setText("NOMBRE:");

        lblApellidoPaterno.setText("APELLIDO PATERNO:");

        lblApellidoMaterno.setText("APELLIDO MATERNO:");

        lblEstadoCivil.setText("ESTADO CIVIL:");

        lblSexo.setText("SEXO:");

        lblDireccion.setText("DIRECCIÓN:");

        lblTelefono.setText("TELÉFONO:");

        lblFechaNacimiento.setText("FECHA DE NACIMIENTO (año/mes/dia):");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        txtTipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoIdentificacionActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        txtEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoCivilActionPerformed(evt);
            }
        });

        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFuncionario1Layout = new javax.swing.GroupLayout(jPFuncionario1);
        jPFuncionario1.setLayout(jPFuncionario1Layout);
        jPFuncionario1Layout.setHorizontalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPFuncionario1Layout.setVerticalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(lblEstadoCivil)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoIdentificacion)
                    .addComponent(lblSexo)
                    .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblDireccion)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(lblTelefono)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidoMaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFuncionario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPanels.addTab("Crear Funcionario", jPFuncionario);

        lblFuncionarios.setText("FUNCIONARIOS");

        lblDocumentoEditar.setText("DOCUMENTO:");

        lblTipoIdentificacionEditar.setText("TIPO DE IDENTIFICACIÓN:");

        lblNombreEditar.setText("NOMBRE:");

        lblApellidoPaternoEditar.setText("APELLIDO PATERNO:");

        lblApellidoMaternoEditar.setText("APELLIDO MATERNO:");

        lblEstadoCivilEditar.setText("ESTADO CIVIL:");

        lblSexoEditar.setText("SEXO:");

        lblDireccionEditar.setText("DIRECCIÓN:");

        lblTelefonoEditar.setText("TELÉFONO:");

        lblFechaNacimientoEditar.setText("FECHA DE NACIMIENTO (año/mes/dia):");

        txtDireccionEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEditarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEditarLayout = new javax.swing.GroupLayout(jpEditar);
        jpEditar.setLayout(jpEditarLayout);
        jpEditarLayout.setHorizontalGroup(
            jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditarLayout.createSequentialGroup()
                .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditarLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionarios)
                            .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDocumentoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoPaternoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoMaternoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipoIdentificacionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDocumentoEditar)
                            .addComponent(txtTipoIdentificacionEditar)
                            .addComponent(txtNombreEditar)
                            .addComponent(txtApellidoPaternoEditar)
                            .addComponent(txtApellidoMaternoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFechaNacimientoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDireccionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefonoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoCivilEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTelefonoEditar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionEditar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSexoEditar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstadoCivilEditar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaNacimientoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                    .addGroup(jpEditarLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpEditarLayout.setVerticalGroup(
            jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblFuncionarios)
                .addGap(18, 18, 18)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditarLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDocumentoEditar)
                            .addComponent(lblEstadoCivilEditar)
                            .addComponent(txtDocumentoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoCivilEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoIdentificacionEditar)
                            .addComponent(lblSexoEditar)
                            .addComponent(txtTipoIdentificacionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreEditar)
                            .addComponent(lblDireccionEditar)
                            .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellidoPaternoEditar)
                            .addComponent(lblTelefonoEditar)
                            .addComponent(txtApellidoPaternoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaNacimientoEditar)
                            .addComponent(lblApellidoMaternoEditar)
                            .addComponent(txtApellidoMaternoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimientoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnActualizar))
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar Funcionario", jPanel2);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1010, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtTipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoIdentificacionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void txtEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoCivilActionPerformed

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if(txtDocumento.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el número de documento");
            txtDocumento.requestFocus();
            return;
        }
        
        if(txtTipoIdentificacion.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el tipo de identificación");
            txtTipoIdentificacion.requestFocus();
            return;
        }
        
        if(txtNombre.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el nombre");
            txtNombre.requestFocus();
            return;
        }
        
        if(txtApellidoPaterno.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el apellido paterno");
            txtApellidoPaterno.requestFocus();
            return;
        }
        
        if(txtApellidoMaterno.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el apellido materno");
            txtApellidoMaterno.requestFocus();
            return;
        }
        
        if(txtEstadoCivil.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el estado civil");
            txtEstadoCivil.requestFocus();
            return;
        }
        
        if(txtSexo.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el sexo");
            txtSexo.requestFocus();
            return;
        }
        
        if(txtDireccion.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite la dirección");
            txtDireccion.requestFocus();
            return;
        }
        
        if(txtTelefono.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el teléfono");
            txtTelefono.requestFocus();
            return;
        }
        
        if(txtFechaNacimiento.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite la fecha de nacimiento");
            txtFechaNacimiento.requestFocus();
            return;
        }
        
        Funcionario funcionario = new Funcionario();
        funcionario.setFUN_ID(txtDocumento.getText().trim());
        funcionario.setIDEN_ID(Integer.parseInt(txtTipoIdentificacion.getText().trim()));
        funcionario.setFUN_NOMBRE(txtNombre.getText().trim());
        funcionario.setFUN_APELLIDO_PATERNO(txtApellidoPaterno.getText().trim());
        funcionario.setFUN_APELLIDO_MATERNO(txtApellidoMaterno.getText().trim());
        funcionario.setEST_ID(Integer.parseInt(txtEstadoCivil.getText().trim()));
        funcionario.setSEX_ID(Integer.parseInt(txtSexo.getText().trim()));
        funcionario.setFUN_DIRECCION(txtDireccion.getText().trim());
        funcionario.setFUN_TELEFONO(txtTelefono.getText().trim());
        funcionario.setFUN_FECHA_NACIMIENTO(txtFechaNacimiento.getText().trim());
        
        try {
            funcionarioController.crear(funcionario);
            txtDocumento.setText("");
            txtTipoIdentificacion.setText("");
            txtNombre.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");
            listarFuncionarios();
            JOptionPane.showMessageDialog(null,"El funcionario fue creado con exito");
            
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"El funcionario no pudo ser creado.");
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDireccionEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(txtDocumentoEditar.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la lista");
            txtDocumentoEditar.requestFocus();
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(null,"¿Está segura de eliminar el funcionario?", "Confirmar salida", 
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(opt==0){
            
            try{
                funcionarioController.eliminarFuncionario(txtDocumentoEditar.getText());
                txtTipoIdentificacionEditar.setText("");
                txtNombreEditar.setText("");
                txtApellidoPaternoEditar.setText("");
                txtApellidoMaternoEditar.setText("");
                txtEstadoCivilEditar.setText("");
                txtSexoEditar.setText("");
                txtDireccionEditar.setText("");
                txtTelefonoEditar.setText("");
                txtFechaNacimientoEditar.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null,"El funcionario se eliminó con exito.");
                
            } catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"El funcionario no pudo ser eliminado.");
            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(txtDocumentoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Seleccionar un funcionario de la lista");
            txtDocumentoEditar.requestFocus();
            return;
        }
        
        if(txtTipoIdentificacionEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el tipo de identificación");
            txtTipoIdentificacionEditar.requestFocus();
            return;
        }
        
        if(txtNombreEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el nombre");
            txtNombreEditar.requestFocus();
            return;
        }
        
        if(txtApellidoPaternoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el apellido paterno");
            txtApellidoPaternoEditar.requestFocus();
            return;
        }
        
        if(txtApellidoMaternoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el apellido materno");
            txtApellidoMaternoEditar.requestFocus();
            return;
        }
        
        if(txtEstadoCivilEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el estado civil");
            txtEstadoCivilEditar.requestFocus();
            return;
        }
        
        if(txtSexoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el sexo");
            txtSexoEditar.requestFocus();
            return;
        }
        
        if(txtDireccionEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite la dirección");
            txtDireccionEditar.requestFocus();
            return;
        }
        
        if(txtTelefonoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite el teléfono");
            txtTelefonoEditar.requestFocus();
            return;
        }
        
        if(txtFechaNacimientoEditar.getText().trim().length()==0) {
            JOptionPane.showMessageDialog(null,"Digite la fecha de nacimiento");
            txtFechaNacimientoEditar.requestFocus();
            return;
        }
        
        Funcionario funcionario = new Funcionario();
        funcionario.setFUN_ID(txtDocumentoEditar.getText().trim());
        funcionario.setIDEN_ID(Integer.parseInt(txtTipoIdentificacionEditar.getText().trim()));
        funcionario.setFUN_NOMBRE(txtNombreEditar.getText().trim());
        funcionario.setFUN_APELLIDO_PATERNO(txtApellidoPaternoEditar.getText().trim());
        funcionario.setFUN_APELLIDO_MATERNO(txtApellidoMaternoEditar.getText().trim());
        funcionario.setEST_ID(Integer.parseInt(txtEstadoCivilEditar.getText().trim()));
        funcionario.setSEX_ID(Integer.parseInt(txtSexoEditar.getText().trim()));
        funcionario.setFUN_DIRECCION(txtDireccionEditar.getText().trim());
        funcionario.setFUN_TELEFONO(txtTelefonoEditar.getText().trim());
        funcionario.setFUN_FECHA_NACIMIENTO(txtFechaNacimientoEditar.getText().trim());
        
        int opt = JOptionPane.showConfirmDialog(null,"Desea actualizar el funcionario", "Confirmar salida", 
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(opt==0){
            
            try{
                funcionarioController.actualizarFuncionario((txtDocumentoEditar.getText()), funcionario);
                txtTipoIdentificacionEditar.setText("");
                txtNombreEditar.setText("");
                txtApellidoPaternoEditar.setText("");
                txtApellidoMaternoEditar.setText("");
                txtEstadoCivilEditar.setText("");
                txtSexoEditar.setText("");
                txtDireccionEditar.setText("");
                txtTelefonoEditar.setText("");
                txtFechaNacimientoEditar.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null,"El funcionario se actualizó con exito.");
                
            } catch(SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"El funcionario no pudo ser actualizado.");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPFuncionario1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JPanel jpEditar;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoMaternoEditar;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblApellidoPaternoEditar;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEditar;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblDocumentoEditar;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivilEditar;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaNacimientoEditar;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEditar;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEditar;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEditar;
    private javax.swing.JLabel lblTipoIdentificacion;
    private javax.swing.JLabel lblTipoIdentificacionEditar;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoMaternoEditar;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtApellidoPaternoEditar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEditar;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDocumentoEditar;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtEstadoCivilEditar;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEditar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEditar;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEditar;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEditar;
    private javax.swing.JTextField txtTipoIdentificacion;
    private javax.swing.JTextField txtTipoIdentificacionEditar;
    // End of variables declaration//GEN-END:variables
}
