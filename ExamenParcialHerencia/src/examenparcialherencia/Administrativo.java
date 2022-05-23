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
public class Administrativo extends Trabajador{
    
    private String tituloProfesional;
    private String nivelEstudios;

    public Administrativo(String tituloProfesional, String nivelEstudios, String cedula, String apellidos, String nombres, double salarioBasico) {
        super(cedula, apellidos, nombres, salarioBasico);
        this.tituloProfesional = tituloProfesional;
        this.nivelEstudios = nivelEstudios;
        setSalarioTotal(calcularSalario());
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }
    
    public double calcularSalario(){
        double salario = getSalarioBasico();
        if(this.nivelEstudios.equals("Técnico")){
            salario += getSalarioBasico()*0.3;
        }else if(this.nivelEstudios.equals("Tecnólogo")){
            salario += getSalarioBasico()*0.5;
        }else if(this.nivelEstudios.equals("Profesional")){
            salario *= 2;
        }else if(this.nivelEstudios.equals("Especialista") || this.nivelEstudios.equals("Magister") || this.nivelEstudios.equals("Doctor") ){
            salario *= 3;
        }
        return salario;
    }

    @Override
    public String toString() {
        return "Docente de Tiempo Completo: Nombres: " + getNombres() + ". Apellidos: " + getApellidos() + ". Número de Documento: " + getCedula() + "Título Profesional: " + getTituloProfesional() + ". Nivel de estudios: " + getNivelEstudios() + ". Salario Devengado: " + calcularSalario() + "\n";
    }    
    
}
