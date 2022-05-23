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
public class Vigilancia extends Trabajador{

    private int horasExtra;

    public Vigilancia(int horasExtra, String cedula, String apellidos, String nombres, double salarioBasico) {
        super(cedula, apellidos, nombres, salarioBasico);
        this.horasExtra = horasExtra;
        setSalarioTotal(calcularSalario());
    }
    
    public double calcularSalario(){
        return getSalarioBasico() + (horasExtra * (getSalarioBasico() / 30));
    }

    @Override
    public String toString() {
        return "Trabajador del área de Vigilancia: Nombres: " + getNombres() + ". Apellidos: " + getApellidos() + ". Número de Documento: " + getCedula() + ". Salario Devengado: " + calcularSalario() + "\n" ;
    }
    
    
    
}
