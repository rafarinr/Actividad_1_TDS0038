package com.iudigital.crudfuncionarios.dominio;

public class Funcionario {
    
    private String FUN_ID;
    private int IDEN_ID;
    private String FUN_NOMBRE;
    private String FUN_APELLIDO_PATERNO;
    private String FUN_APELLIDO_MATERNO;
    private int EST_ID;
    private int SEX_ID;
    private String FUN_DIRECCION;
    private String FUN_TELEFONO;
    private String FUN_FECHA_NACIMIENTO;

    public String getFUN_ID() {
        return FUN_ID;
    }

    public void setFUN_ID(String FUN_ID) {
        this.FUN_ID = FUN_ID;
    }

    public int getIDEN_ID() {
        return IDEN_ID;
    }

    public void setIDEN_ID(int IDEN_ID) {
        this.IDEN_ID = IDEN_ID;
    }

    public String getFUN_NOMBRE() {
        return FUN_NOMBRE;
    }

    public void setFUN_NOMBRE(String FUN_NOMBRE) {
        this.FUN_NOMBRE = FUN_NOMBRE;
    }

    public String getFUN_APELLIDO_PATERNO() {
        return FUN_APELLIDO_PATERNO;
    }

    public void setFUN_APELLIDO_PATERNO(String FUN_APELLIDO_PATERNO) {
        this.FUN_APELLIDO_PATERNO = FUN_APELLIDO_PATERNO;
    }

    public String getFUN_APELLIDO_MATERNO() {
        return FUN_APELLIDO_MATERNO;
    }

    public void setFUN_APELLIDO_MATERNO(String FUN_APELLIDO_MATERNO) {
        this.FUN_APELLIDO_MATERNO = FUN_APELLIDO_MATERNO;
    }

    public int getEST_ID() {
        return EST_ID;
    }

    public void setEST_ID(int EST_ID) {
        this.EST_ID = EST_ID;
    }

    public int getSEX_ID() {
        return SEX_ID;
    }

    public void setSEX_ID(int SEX_ID) {
        this.SEX_ID = SEX_ID;
    }

    public String getFUN_DIRECCION() {
        return FUN_DIRECCION;
    }

    public void setFUN_DIRECCION(String FUN_DIRECCION) {
        this.FUN_DIRECCION = FUN_DIRECCION;
    }

    public String getFUN_TELEFONO() {
        return FUN_TELEFONO;
    }

    public void setFUN_TELEFONO(String FUN_TELEFONO) {
        this.FUN_TELEFONO = FUN_TELEFONO;
    }

    public String getFUN_FECHA_NACIMIENTO() {
        return FUN_FECHA_NACIMIENTO;
    }

    public void setFUN_FECHA_NACIMIENTO(String FUN_FECHA_NACIMIENTO) {
        this.FUN_FECHA_NACIMIENTO = FUN_FECHA_NACIMIENTO;
    }

    @Override
    public String toString(){
        return FUN_NOMBRE + " " + FUN_APELLIDO_PATERNO + " " + FUN_APELLIDO_MATERNO; 
    }

    
    
    
}
