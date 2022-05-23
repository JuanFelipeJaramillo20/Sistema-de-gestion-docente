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
public class DocenteTiempoCompleto extends Trabajador{
    
    private String tituloProfesional;
    private String nivelEstudios;
    private boolean participaGruposInvestigacion;
    private int horasParticipacion;

    public DocenteTiempoCompleto(String tituloProfesional, String nivelEstudios, boolean participaGruposInvestigacion, int horasParticipacion, String cedula, String apellidos, String nombres, double salarioBasico) {
        super(cedula, apellidos, nombres, salarioBasico);
        this.tituloProfesional = tituloProfesional;
        this.nivelEstudios = nivelEstudios;
        this.participaGruposInvestigacion = participaGruposInvestigacion;
        this.horasParticipacion = horasParticipacion;
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
        if(participaGruposInvestigacion){
            double nuevoSalarioBasico = getSalarioBasico() +  (this.horasParticipacion * (getSalarioBasico() / 30));
            setSalarioBasico(nuevoSalarioBasico);
        }
        double salario = getSalarioBasico();
        if(this.nivelEstudios.equals("Profesional")){
            salario += getSalarioBasico() + (getSalarioBasico() * 0.5);
        }else if(this.nivelEstudios.equals("Especialista")){
            salario *= 3;
        }else if(this.nivelEstudios.equals("Magister")){
            salario *= 4;
        }else if(this.nivelEstudios.equals("Doctor")){
            salario *= 5;
        }
        return salario;
    }

    @Override
    public String toString() {
        return "Docente de Tiempo Completo: Nombres: " + getNombres() + ". Apellidos: " + getApellidos() + ". Número de Documento: " + getCedula() + "Título Profesional: " + getTituloProfesional() + ". Nivel de estudios: " + getNivelEstudios() + ". Salario Devengado: " + calcularSalario() ;
    }

    
    
    
}
