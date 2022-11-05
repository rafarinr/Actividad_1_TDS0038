package com.iudigital.crudfuncionarios.presentacion;

import com.iudigital.crudfuncionarios.controller.FuncionariosController;
import com.iudigital.crudfuncionarios.dominio.Funcionario;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void obtenerFuncionarios(FuncionariosController funcionariosController) {
        try {
            List<Funcionario> funcionarios = funcionariosController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(funcionario -> {

                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("----------------------CONSULTA DE FUNCIONARIOS--------------------");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Documento: " + funcionario.getFUN_ID());
                    System.out.println("Tipo de documento: " + funcionario.getIDEN_ID());
                    System.out.println("Nombre: " + funcionario.getFUN_NOMBRE());
                    System.out.println("Apellido paterno: " + funcionario.getFUN_APELLIDO_PATERNO());
                    System.out.println("Apellido materno: " + funcionario.getFUN_APELLIDO_MATERNO());
                    System.out.println("Estado Civil: " + funcionario.getEST_ID());
                    System.out.println("Sexo: " + funcionario.getSEX_ID());
                    System.out.println("Dirección: " + funcionario.getFUN_DIRECCION());
                    System.out.println("Teléfono: " + funcionario.getFUN_TELEFONO());
                    System.out.println("Fecha de nacimiento: " + funcionario.getFUN_FECHA_NACIMIENTO());
                    System.out.println("---------------------------------------------");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void crearFuncionario(FuncionariosController funcionariosController) throws ParseException {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("-----------------------------------------------------------------");
            System.out.println("----------------------REGISTRO DE FUNCIONARIO--------------------");
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Digite el número de documento: ");
            String documento = sc.nextLine();
            System.out.println("El número de documento es: " + documento);
            System.out.println("--------------------------- ");

            System.out.println("Digite número para el tipo de documento : ");
            System.out.println("1- Cédula de ciudadania");
            System.out.println("2- Tarjeta identidad");
            System.out.println("3- Registro civil");
            System.out.println("4- Cédula Extranjeria");
            System.out.println("5- Pasaporte");
            int tipoDocumento = sc.nextInt();
            sc.nextLine();
            System.out.println("El tipo de documento es: " + tipoDocumento);
            System.out.println("--------------------------- ");

            System.out.println("Digite el nombre : ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("--------------------------- ");

            System.out.println("Digite el apellido paterno : ");
            String apellidoPaterno = sc.nextLine();
            System.out.println("El apellido paterno es: " + apellidoPaterno);
            System.out.println("--------------------------- ");

            System.out.println("Digite el apellido materno : ");
            String apellidoMaterno = sc.nextLine();
            System.out.println("El apellido materno es: " + apellidoMaterno);
            System.out.println("--------------------------- ");

            System.out.println("Digite número para el estado civil : ");
            System.out.println("1- Soltero/a");
            System.out.println("2- Casado/a");
            System.out.println("3- Divorciado/a");
            System.out.println("4- Viudo/a");
            int estadoCivil = sc.nextInt();
            sc.nextLine();
            System.out.println("El estado civil es: " + estadoCivil);
            System.out.println("--------------------------- ");

            System.out.println("Digite número para el sexo : ");
            System.out.println("1- Masculino");
            System.out.println("2- Femenino");
            int sexo = sc.nextInt();
            sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("--------------------------- ");

            System.out.println("Digite la dirección : ");
            String direccion = sc.nextLine();
            System.out.println("La dirección es: " + direccion);
            System.out.println("--------------------------- ");

            System.out.println("Digite el teléfono : ");
            String telefono = sc.nextLine();
            System.out.println("El teléfono es: " + telefono);
            System.out.println("--------------------------- ");

            System.out.println("Digite la fecha de nacimiento en formato yyyy/mm/dd : ");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fechaNacimiento);
            System.out.println("--------------------------- ");

            Funcionario funcionario = new Funcionario();
            funcionario.setFUN_ID(documento);
            funcionario.setIDEN_ID(tipoDocumento);
            funcionario.setFUN_NOMBRE(nombre);
            funcionario.setFUN_APELLIDO_PATERNO(apellidoPaterno);
            funcionario.setFUN_APELLIDO_MATERNO(apellidoMaterno);
            funcionario.setEST_ID(estadoCivil);
            funcionario.setSEX_ID(sexo);
            funcionario.setFUN_DIRECCION(direccion);
            funcionario.setFUN_TELEFONO(telefono);
            funcionario.setFUN_FECHA_NACIMIENTO(fechaNacimiento);

            funcionariosController.crear(funcionario);
            System.out.println("Funcionario creado con exito: ");
            obtenerFuncionarios(funcionariosController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void editarFuncionario(FuncionariosController funcionariosController) throws ParseException {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("--------------------EDITAR DATOS DE FUNCIONARIO------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Digite el número de documento del funcionario para editar: ");
            String FUN_ID = sc.nextLine();
            System.out.println("El número de documento es: " + FUN_ID);
            System.out.println("-----------------------------------------------------------------");
            Funcionario funcionariosExits = funcionariosController.obtenerFuncionario(FUN_ID);
            if (funcionariosExits == null) {
                System.out.println("El funcionario no está registrado");
                System.out.println("-----------------------------------------------------------------");
                return;
            }

            System.out.println("Digite número para el tipo de documento : ");
            System.out.println("1- Cédula de ciudadania");
            System.out.println("2- Tarjeta identidad");
            System.out.println("3- Registro civil");
            System.out.println("4- Cédula Extranjeria");
            System.out.println("5- Pasaporte");
            int tipoDocumento = sc.nextInt();
            sc.nextLine();
            System.out.println("El tipo de documento es: " + tipoDocumento);
            System.out.println("--------------------------- ");

            System.out.println("Digite el nombre : ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("--------------------------- ");

            System.out.println("Digite el apellido paterno : ");
            String apellidoPaterno = sc.nextLine();
            System.out.println("El apellido paterno es: " + apellidoPaterno);
            System.out.println("--------------------------- ");

            System.out.println("Digite el apellido materno : ");
            String apellidoMaterno = sc.nextLine();
            System.out.println("El apellido materno es: " + apellidoMaterno);
            System.out.println("--------------------------- ");

            System.out.println("Digite número para el estado civil : ");
            System.out.println("1- Soltero/a");
            System.out.println("2- Casado/a");
            System.out.println("3- Divorciado/a");
            System.out.println("4- Viudo/a");
            int estadoCivil = sc.nextInt();
            sc.nextLine();
            System.out.println("El estado civil es: " + estadoCivil);
            System.out.println("--------------------------- ");

            System.out.println("Digite número para el sexo : ");
            System.out.println("1- Masculino");
            System.out.println("2- Femenino");
            int sexo = sc.nextInt();
            sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("--------------------------- ");

            System.out.println("Digite la dirección : ");
            String direccion = sc.nextLine();
            System.out.println("La dirección es: " + direccion);
            System.out.println("--------------------------- ");

            System.out.println("Digite el teléfono : ");
            String telefono = sc.nextLine();
            System.out.println("El teléfono es: " + telefono);
            System.out.println("--------------------------- ");

            System.out.println("Digite la fecha de nacimiento en formato yyyy/mm/dd : ");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fechaNacimiento);
            System.out.println("--------------------------- ");

            Funcionario funcionario = new Funcionario();
            funcionario.setIDEN_ID(tipoDocumento);
            funcionario.setFUN_NOMBRE(nombre);
            funcionario.setFUN_APELLIDO_PATERNO(apellidoPaterno);
            funcionario.setFUN_APELLIDO_MATERNO(apellidoMaterno);
            funcionario.setEST_ID(estadoCivil);
            funcionario.setSEX_ID(sexo);
            funcionario.setFUN_DIRECCION(direccion);
            funcionario.setFUN_TELEFONO(telefono);
            funcionario.setFUN_FECHA_NACIMIENTO(fechaNacimiento);
            funcionariosController.actualizarFuncionario(FUN_ID, funcionario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void eliminarFuncionario(FuncionariosController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("----------------------ELIMINAR FUNCIONARIO-----------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Digite el número de documento del funcionario para eliminar: ");
            String FUN_ID = sc.nextLine();
            System.out.println("El número de documento es: " + FUN_ID);
            System.out.println("-----------------------------------------------------------------");
            Funcionario funcionariosExits = funcionarioController.obtenerFuncionario(FUN_ID);

            if (funcionariosExits == null) {
                System.out.println("El funcionario no está registrado");
                System.out.println("-----------------------------------------------------------------");
                return;
            }

            funcionarioController.eliminarFuncionario(FUN_ID);
            System.out.println("Funcionario eliminado.");
            System.out.println("-----------------------------------------------------------------");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public static void obtenerFuncionario(FuncionariosController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------");
            System.out.println("----------------------CONSULTA DE FUNCIONARIO--------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Digite el número de documento del funcionario para consulta: ");
            String FUN_ID = sc.nextLine();
            System.out.println("El número de documento es: " + FUN_ID);
            System.out.println("-----------------------------------------------------------");
            
            Funcionario funcionariosExits = funcionarioController.obtenerFuncionario(FUN_ID);

            if (funcionariosExits == null) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("El funcionario no está registrado");
                System.out.println("-----------------------------------------------------------------");
                return;
            }
            
            Funcionario funcionario = funcionarioController.obtenerFuncionario(FUN_ID);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("----------------------DATOS DEL FUNCIONARIO----------------------");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Documento: " + funcionario.getFUN_ID());
                    System.out.println("Tipo de documento: " + funcionario.getIDEN_ID());
                    System.out.println("Nombre: " + funcionario.getFUN_NOMBRE());
                    System.out.println("Apellido paterno: " + funcionario.getFUN_APELLIDO_PATERNO());
                    System.out.println("Apellido materno: " + funcionario.getFUN_APELLIDO_MATERNO());
                    System.out.println("Estado Civil: " + funcionario.getEST_ID());
                    System.out.println("Sexo: " + funcionario.getSEX_ID());
                    System.out.println("Dirección: " + funcionario.getFUN_DIRECCION());
                    System.out.println("Teléfono: " + funcionario.getFUN_TELEFONO());
                    System.out.println("Fecha de nacimiento: " + funcionario.getFUN_FECHA_NACIMIENTO());
                    System.out.println("---------------------------------------------");
            

            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) throws ParseException {
        FuncionariosController funcionariosController = new FuncionariosController();
        boolean salir = false;
        
        Scanner sc =new Scanner(System.in);
        
        while(!salir){
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("-------------------MENU GESTIÓN FUNCIONARIOS---------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1- Consultar funcionarios");
            System.out.println("2- Consultar funcionario por documento");
            System.out.println("3- Crear funcionario");
            System.out.println("4- Editar funcionario");
            System.out.println("5- Eliminar funcionario");
            System.out.println("6- Salir");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Digite una opción");
            int opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion){
                case 1:
                    obtenerFuncionarios(funcionariosController);
                    break;
                case 2:
                    obtenerFuncionario(funcionariosController);
                    break;
                case 3:
                    crearFuncionario(funcionariosController);
                    break;
                case 4:
                    editarFuncionario(funcionariosController);
                    break;
                case 5:
                    eliminarFuncionario(funcionariosController);
                    break;
                case 6:
                    System.out.println("Ha salido de la aplicación.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida.");
                    break;
            }
        }
    }
}
