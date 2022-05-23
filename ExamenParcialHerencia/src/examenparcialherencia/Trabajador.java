/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcialherencia;

/**
 *
 * @author juanf
 */
public class Trabajador {
    
    private String cedula;
    private String apellidos;
    private String nombres;
    private double salarioBasico;
    private double salarioTotal;

    public Trabajador(String cedula, String apellidos, String nombres, double salarioBasico) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.salarioBasico = salarioBasico;
        this.salarioTotal = 0;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    
        
}
