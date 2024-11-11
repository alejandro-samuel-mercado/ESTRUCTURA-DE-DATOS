package TP1.Punto6;

public class ErjecicioGrupal extends ActividadFisica {
    private String nivelDificultad;
    private int cantidadParticipantes;
    private int diaFinalizacion;

    public ErjecicioGrupal(String nombreCentroEntrenamiento, String nombreActividadFisca, String instructor,
            boolean disponible,
            String diaSemana,
            int horaInicio, String nivelDificultad, int cantidadParticiantes, int diaFinalizacion) {
        super(nombreCentroEntrenamiento, nombreActividadFisca, instructor, disponible, diaSemana, horaInicio);
        this.nivelDificultad = nivelDificultad;
        this.cantidadParticipantes = cantidadParticiantes;
        this.diaFinalizacion = diaFinalizacion;

    }

    public void mostarEjecricioGrupal() {
        super.mostrarDatos();
        System.out.println("Dificultad:  " + this.nivelDificultad);
        System.out.println("Cantidad de participantes: " + this.cantidadParticipantes);
        System.out.println("Día de finalización: " + this.diaFinalizacion);

    }
}
