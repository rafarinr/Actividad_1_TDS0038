/*capa de logica de negocios*/

package com.iudigital.crudfuncionarios.controller;

import com.iudigital.crudfuncionarios.dao.FuncionariosDao;
import com.iudigital.crudfuncionarios.dominio.Funcionario;
import java.sql.SQLException;
import java.util.List;


public class FuncionariosController {
    
    private FuncionariosDao funcionariosDao; 
    
    public FuncionariosController(){
        funcionariosDao = new FuncionariosDao();
        
    }
    
    public void crear(Funcionario funcionario) throws SQLException {
        funcionariosDao.crear(funcionario);
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionariosDao.obtenerFuncionarios();
    }
    
    public Funcionario obtenerFuncionario(String id) throws SQLException {
       return funcionariosDao.obtenerFuncionario(id);
    }
    
    public void actualizarFuncionario(String id, Funcionario funcionario) throws SQLException {
        funcionariosDao.actualizarFuncionario(id, funcionario);
    }
    
    public void eliminarFuncionario(String id) throws SQLException {
        funcionariosDao.eliminarFuncionario(id);
    }
    
    
}
