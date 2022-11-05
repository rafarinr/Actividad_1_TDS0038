 package com.iudigital.crudfuncionarios.dao;

import com.iudigital.crudfuncionarios.dominio.Funcionario;
import com.iudigital.crudfuncionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDao {

    private static final String GET_FUNCIONARIOS = "select * from FUNCIONARIOS";
    private static final String CREATE_FUNCIONARIO = "insert into FUNCIONARIOS"
            + "(FUN_ID,IDEN_ID,FUN_NOMBRE,FUN_APELLIDO_PATERNO,FUN_APELLIDO_MATERNO,"
            + "EST_ID,SEX_ID,FUN_DIRECCION,FUN_TELEFONO,FUN_FECHA_NACIMIENTO) values"
            + "(?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_FUNCIONARIO_POR_DOCUMENTO = "select * from FUNCIONARIOS where FUN_ID = ?";
    private static final String UPDATE_FUNCIONARIO = "update FUNCIONARIOS set IDEN_ID = ?,FUN_NOMBRE = ?,FUN_APELLIDO_PATERNO = ?,FUN_APELLIDO_MATERNO = ?,"
            + "EST_ID = ?,SEX_ID = ?,FUN_DIRECCION = ?,FUN_TELEFONO = ?,FUN_FECHA_NACIMIENTO = ? where FUN_ID = ?";
    private static final String DELETE_FUNCIONARIO = "delete from FUNCIONARIOS where FUN_ID = ?";

    
    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1,funcionario.getFUN_ID()); 
            preparedStatement.setInt(2, funcionario.getIDEN_ID());
            preparedStatement.setString(3, funcionario.getFUN_NOMBRE());
            preparedStatement.setString(4, funcionario.getFUN_APELLIDO_PATERNO());
            preparedStatement.setString(5, funcionario.getFUN_APELLIDO_MATERNO());
            preparedStatement.setInt(6, funcionario.getEST_ID());
            preparedStatement.setInt(7, funcionario.getSEX_ID());
            preparedStatement.setString(8, funcionario.getFUN_DIRECCION());
            preparedStatement.setString(9, funcionario.getFUN_TELEFONO());
            preparedStatement.setString(10, funcionario.getFUN_FECHA_NACIMIENTO());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }
    
    
   public List<Funcionario> obtenerFuncionarios() throws SQLException {
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       List<Funcionario> funcionarios = new ArrayList<>();
       
       try {
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
           resultSet = preparedStatement.executeQuery();
           while ( resultSet.next()) {
               Funcionario funcionario = new Funcionario();
               funcionario.setFUN_ID(resultSet.getString("FUN_ID"));
               funcionario.setIDEN_ID(resultSet.getInt("IDEN_ID"));
               funcionario.setFUN_NOMBRE(resultSet.getString("FUN_NOMBRE"));
               funcionario.setFUN_APELLIDO_PATERNO(resultSet.getString("FUN_APELLIDO_PATERNO"));
               funcionario.setFUN_APELLIDO_MATERNO(resultSet.getString("FUN_APELLIDO_MATERNO"));
               funcionario.setEST_ID(resultSet.getInt("EST_ID"));
               funcionario.setSEX_ID(resultSet.getInt("SEX_ID"));
               funcionario.setFUN_DIRECCION(resultSet.getString("FUN_DIRECCION"));
               funcionario.setFUN_TELEFONO(resultSet.getString("FUN_TELEFONO"));
               funcionario.setFUN_FECHA_NACIMIENTO(resultSet.getString("FUN_FECHA_NACIMIENTO"));
               funcionarios.add(funcionario);
           }
           
           return funcionarios;
       } finally {
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
       }
    } 
    
    
    public Funcionario obtenerFuncionario (String id) throws SQLException {
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       Funcionario funcionario = null;
       
       try {
           connection = ConnectionUtil.getConnection();
           preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_POR_DOCUMENTO);
           preparedStatement.setString(1, id);
           resultSet = preparedStatement.executeQuery();
           
           if (resultSet.next()) {
               funcionario = new Funcionario();
               funcionario.setFUN_ID(resultSet.getString("FUN_ID"));
               funcionario.setIDEN_ID(resultSet.getInt("IDEN_ID"));
               funcionario.setFUN_NOMBRE(resultSet.getString("FUN_NOMBRE"));
               funcionario.setFUN_APELLIDO_PATERNO(resultSet.getString("FUN_APELLIDO_PATERNO"));
               funcionario.setFUN_APELLIDO_MATERNO(resultSet.getString("FUN_APELLIDO_MATERNO"));
               funcionario.setEST_ID(resultSet.getInt("EST_ID"));
               funcionario.setSEX_ID(resultSet.getInt("SEX_ID"));
               funcionario.setFUN_DIRECCION(resultSet.getString("FUN_DIRECCION"));
               funcionario.setFUN_TELEFONO(resultSet.getString("FUN_TELEFONO"));
               funcionario.setFUN_FECHA_NACIMIENTO(resultSet.getString("FUN_FECHA_NACIMIENTO"));
           }
           
           return funcionario;
           
       } finally {
           if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
       }
       
       
    }
    
    public void actualizarFuncionario(String id, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
             
            preparedStatement.setInt(1, funcionario.getIDEN_ID());
            preparedStatement.setString(2, funcionario.getFUN_NOMBRE());
            preparedStatement.setString(3, funcionario.getFUN_APELLIDO_PATERNO());
            preparedStatement.setString(4, funcionario.getFUN_APELLIDO_MATERNO());
            preparedStatement.setInt(5, funcionario.getEST_ID());
            preparedStatement.setInt(6, funcionario.getSEX_ID());
            preparedStatement.setString(7, funcionario.getFUN_DIRECCION());
            preparedStatement.setString(8, funcionario.getFUN_TELEFONO());
            preparedStatement.setString(9, funcionario.getFUN_FECHA_NACIMIENTO());
            preparedStatement.setString( 10,id);    
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(String id) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
        }
        
        
    }
    
    
    
}
