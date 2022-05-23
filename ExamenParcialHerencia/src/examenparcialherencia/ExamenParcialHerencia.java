/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcialherencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ExamenParcialHerencia {

    private ArrayList<Trabajador> trabajadores;

    public ExamenParcialHerencia() {
        inicializar();
    }
    
    public void inicializar(){
        this.trabajadores = new ArrayList<>();
    }
    
    public void menu(){
        boolean menu = true;
        do {            
            
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al sistema de gestión de trabajadores de la Universidad Lorem Ipsum. \n"
                + "Seleccione la opción que desea ejecutar: \n"
                + "1. Ingresar datos de un trabajador. \n"
                + "2. Calcular nómina total por sección (Vigilancia, Administrativo y Docente Tiempo Completo. \n"
                + "3. Consultar nivel de estudios de trabajadores. \n"
                + "4. Acerca de. \n"
                    + "5. Salir"));
            
            switch(opcion){
                case 1:
                    agregarTrabajador();
                    break;
                case 2:
                    calcularNomina();
                    break;
                case 3:
                    consultarNivelEstudios();
                    break;
                case 4:
                    acercaDe();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta. Por favor intente de nuevo.");
            }
        } while (menu);
    }
    
    public void agregarTrabajador(){
        
        String nombres = JOptionPane.showInputDialog("Ingrese el nombre(s) del trabajador(a): ");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del trabajador(a): ");
        String cedula = JOptionPane.showInputDialog("Ingrese el número de documento del trabajador(a): ");
        double salarioBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario básico mensual del trabajador"));
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione que tipo de trabajador desea registrar: \n"
                + "1. Vigilancia \n"
                + "2. Administrativo \n"
                + "3. Docente Tiempo Completo"));
        switch(tipo){
            case 1:
                agregarVigilante(nombres, apellidos, cedula, salarioBasico);
                break;
            case 2:
                agregarAdministrativo(nombres, apellidos, cedula, salarioBasico);
                break;
            case 3:
                agregarDocenteTiempoCompleto(nombres, apellidos, cedula, salarioBasico);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción incorrecta. Por favor intente de nuevo.");
        }
    }
    
    public void agregarVigilante(String nombres, String apellidos, String cedula, double salarioBasico){
        int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de horas extras que ha realizado el trabajador:"));
        Vigilancia temp = new Vigilancia(horasExtra, cedula, apellidos, nombres, salarioBasico);
        if(temp != null){
            trabajadores.add(temp);
            JOptionPane.showMessageDialog(null, "Trabajador agregado satisfactoriamente!");
        }
    }
    
    public void agregarAdministrativo(String nombres, String apellidos, String cedula, double salarioBasico){
        String tituloProfesional = JOptionPane.showInputDialog("Ingrese título profesional del trabajador: ");
        String nivelEstudios = JOptionPane.showInputDialog("Ingrese el nivel de estudios del trabajador( Técnico, Tecnólogo, Profesional, Especialista, Magister o Doctor)");
        Administrativo temp = new Administrativo(tituloProfesional, nivelEstudios, cedula, apellidos, nombres, salarioBasico);
        if(temp != null){
            trabajadores.add(temp);
            JOptionPane.showMessageDialog(null, "Trabajador agregado satisfactoriamente!");
        }
    }
    
    public void agregarDocenteTiempoCompleto(String nombres, String apellidos, String cedula, double salarioBasico){
        String tituloProfesional = JOptionPane.showInputDialog("Ingrese título profesional del trabajador: ");
        String nivelEstudios = JOptionPane.showInputDialog("Ingrese el nivel de estudios del trabajador ( Profesional, Especialista, Magister o Doctor )");
        int opcion1 = Integer.parseInt(JOptionPane.showInputDialog("¿El docente asiste a grupos de investigación? \n"
                + "1. Si \n"
                + "2. No"));
        boolean asisteHoras = false;
        if(opcion1 == 1){
            asisteHoras = true;
        }
        int horas = 0;
        if(asisteHoras){
            horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de horas que asiste el docente a grupos de investigación"));
        }
        DocenteTiempoCompleto temp = new DocenteTiempoCompleto(tituloProfesional, nivelEstudios, asisteHoras, horas,  cedula, apellidos, nombres, salarioBasico);
        if(temp != null){
            trabajadores.add(temp);
            JOptionPane.showMessageDialog(null, "Trabajador agregado satisfactoriamente!");
        }
    }
    
    public void calcularNomina(){
        double nominaVigilancia = 0;
        double nominaAdministrativo = 0;
        double nominaDocentesTiempoCompleto = 0;
        for (int i = 0; i < trabajadores.size(); i++) {
            if(trabajadores.get(i) instanceof Vigilancia){
                nominaVigilancia += trabajadores.get(i).getSalarioTotal();
            }else if(trabajadores.get(i) instanceof Administrativo){
                nominaAdministrativo += trabajadores.get(i).getSalarioTotal();
            }else{
                nominaDocentesTiempoCompleto += trabajadores.get(i).getSalarioTotal();
            }
        }
        JOptionPane.showMessageDialog(null, "Nómina Total por área: \n"
                + "Nómina del área de Vigilancia: " + nominaVigilancia + "\n" + "Nómina del área Administrativa: " + nominaAdministrativo + "\n" + "Nómina del área Docentes de Tiempo Completo: " + nominaDocentesTiempoCompleto);
    }
    
    public void consultarNivelEstudios(){
        int cantidadTecnicos = 0;
        int cantidadtTecnologos = 0;
        int cantidadProfesionales = 0;
        int cantidadEspecialistas = 0;
        int cantidadMagister = 0;
        int cantidadDoctores = 0;
        
        for (int i = 0; i < trabajadores.size(); i++) {
            if(trabajadores.get(i) instanceof Administrativo){
                Administrativo temp = (Administrativo) trabajadores.get(i);
                if(temp.getNivelEstudios().equals("Técnico")){
                    cantidadTecnicos++;
                }else if(temp.getNivelEstudios().equals("Tecnólogo")){
                    cantidadtTecnologos++;
                }else if(temp.getNivelEstudios().equals("Profesional")){
                    cantidadProfesionales++;
                }else if(temp.getNivelEstudios().equals("Especialista")){
                    cantidadEspecialistas++;
                }else if(temp.getNivelEstudios().equals("Magister")){
                    cantidadMagister++;
                }else if(temp.getNivelEstudios().equals("Doctor")){
                    cantidadDoctores++;
                }
            }else if(trabajadores.get(i) instanceof DocenteTiempoCompleto){
                DocenteTiempoCompleto temp = (DocenteTiempoCompleto) trabajadores.get(i);
                if(temp.getNivelEstudios().equals("Técnico")){
                    cantidadTecnicos++;
                }else if(temp.getNivelEstudios().equals("Tecnólogo")){
                    cantidadtTecnologos++;
                }else if(temp.getNivelEstudios().equals("Profesional")){
                    cantidadProfesionales++;
                }else if(temp.getNivelEstudios().equals("Especialista")){
                    cantidadEspecialistas++;
                }else if(temp.getNivelEstudios().equals("Magister")){
                    cantidadMagister++;
                }else if(temp.getNivelEstudios().equals("Doctor")){
                    cantidadDoctores++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Número de técnicos registrados: " + cantidadTecnicos + "\n"
                    + "Número de tecnólogos registrados: " + cantidadtTecnologos + "\n"
                            + "Número de profesionales registrados: " + cantidadProfesionales + "\n"
                                    + "Número de especialistas registrados: " + cantidadEspecialistas + "\n"
                                            + "Número de magister registrados: " + cantidadMagister + "\n"
                                                    + "Número de doctores registrados: " + cantidadDoctores);
    }
    
    public void acercaDe(){
        JOptionPane.showMessageDialog(null, "Autor 1: " + "\n" + "Apellidos, Nombre" + "\n" + "Código" + "\n" + "Correo institucional" + 
                "\n" + 
                "Autor 2: " + "\n" + "Apellidos, Nombre" + "\n" + "Código" + "\n" + "Correo institucional");
    }
    
    
    public static void main(String[] args) {
        ExamenParcialHerencia prueba = new ExamenParcialHerencia();
        prueba.menu();  
    }
    
}
