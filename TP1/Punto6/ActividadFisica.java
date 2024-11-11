package TP1.Punto6;

public class ActividadFisica {
    private String nombreCentroEntrenamiento;
    private String nombreActividadFisica;
    private String instructor;
    private boolean disponible;
    private String diaSemana;
    private int horaInicio;

    public ActividadFisica(String nombreCentroEntrenamiento, String nombreActividadFisca, String instructor,
            boolean disponible,
            String diaSemana,
            int horaInicio) {

        this.nombreCentroEntrenamiento = nombreCentroEntrenamiento;
        this.nombreActividadFisica = nombreActividadFisca;
        this.instructor = instructor;
        this.disponible = disponible;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;

    }

    public void mostrarDatos() {
        System.out.println("Centro de entrenamiento: " + this.nombreCentroEntrenamiento);
        System.out.println("Actividad:  " + this.nombreActividadFisica);
        System.out.println("Instructor: " + this.instructor);
        System.out.println("Disponible:  " + this.disponible);
        System.out.println("Día de la semana: " + this.diaSemana);
        System.out.println("Hora de inicio: " + this.horaInicio);
    }

    public void verificarDisponibilidad() {
        if (this.disponible) {
            System.out.println("Está disonible");
        } else {
            System.out.println("No está disponible");
        }
    }
}
