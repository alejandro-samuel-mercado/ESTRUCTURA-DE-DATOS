import PARCIAL.Resuelto.Empleado;

public class Main {

    public static void main(String[] args) {
        Empleado[] empleados = null;
        empleados = agregarEmpleados();

        for (int i = 0; i < empleados.length; i++) {
            System.out.println(empleados[i]);
        }
    }

    public static Empleado[] agregarEmpleados() {
        Empleado[] empleados = new Empleado[5];
        empleados[0] = new Empleado(0, 0, null, null, null, 0, null);
        return empleados;
    }
}