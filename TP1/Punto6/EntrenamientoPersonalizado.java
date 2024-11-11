package TP1.Punto6;

public class EntrenamientoPersonalizado extends ActividadFisica {
    private int duracionHoras;
    private String objetivosEntrenamiento;
    private String rutinaPersonalizada;

    public EntrenamientoPersonalizado(String nombreCentroEntrenamiento, String nombreActividadFisca, String instructor,
            boolean disponible,
            String diaSemana,
            int horaInicio, int duracionHoras, String objetivosEntrenamiento, String rutinaPersonalizada) {
        super(nombreCentroEntrenamiento, nombreActividadFisca, instructor, disponible, diaSemana, horaInicio);
        this.duracionHoras = duracionHoras;
        this.objetivosEntrenamiento = objetivosEntrenamiento;
        this.rutinaPersonalizada = rutinaPersonalizada;

    }

    public void mostarEntrenamiento() {
        super.mostrarDatos();
        System.out.println("Duración en horas:  " + this.duracionHoras);
        System.out.println("Objetivos del entrenamiento: " + this.objetivosEntrenamiento);
        System.out.println("Rutina personalizada: " + this.rutinaPersonalizada);
        System.out.println("-------------------------------------------------------------------");

    }
}
