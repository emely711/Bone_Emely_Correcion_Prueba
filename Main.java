import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE ENTREGAS  ");
        System.out.println("=========================================\n");

        Dronliviano    dl = new Dronliviano();
        Droncarga      dc = new Droncarga();
        Dronemergencia de = new Dronemergencia();

        System.out.println("===== INFORMACION INICIAL DE DRONES =====\n");
        dl.mostrarInformacion();
        System.out.println();
        dc.mostrarInformacion();
        System.out.println();
        de.mostrarInformacion();
        System.out.println("\n==========================================\n");

        System.out.println("===== INGRESO DE NUEVOS DATOS =====\n");
        System.out.println("Que dron desea actualizar?");
        System.out.println("1. Dron Liviano");
        System.out.println("2. Dron Carga");
        System.out.println("3. Dron Emergencia");
        System.out.print("Opcion: ");
        int opcion = leerEntero();

        System.out.println();
        System.out.print("Ingrese codigo: ");
        String codigo = sc.nextLine().trim();

        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine().trim();

        System.out.print("Ingrese distancia (km): ");
        double distancia = leerDouble();

        System.out.print("Ingrese peso del paquete (kg): ");
        double peso = leerDouble();

        System.out.print("Ingrese horas de vuelo: ");
        double horas = leerDouble();

        System.out.println("\nValidando datos...");

        Dron dronSeleccionado = null;

        switch (opcion) {
            case 1:
                dl.setCodigo(codigo);
                dl.setModelo(modelo);
                dl.setDistanciaKm(distancia);
                dl.setPesoPaquete(peso);
                dl.setHorasVuelo(horas);
                dronSeleccionado = dl;
                break;
            case 2:
                dc.setCodigo(codigo);
                dc.setModelo(modelo);
                dc.setDistanciaKm(distancia);
                dc.setPesoPaquete(peso);
                dc.setHorasVuelo(horas);
                dronSeleccionado = dc;
                break;
            case 3:
                System.out.print("Ingrese nivel de prioridad (1-3): ");
                int nivel = leerEntero();
                de.setCodigo(codigo);
                de.setModelo(modelo);
                de.setDistanciaKm(distancia);
                de.setPesoPaquete(peso);
                de.setHorasVuelo(horas);
                de.setNivelPrioridad(nivel);
                dronSeleccionado = de;
                break;
            default:
                System.out.println("Opcion no valida. Usando Dron Liviano.");
                dronSeleccionado = dl;
        }

        if (dronSeleccionado.validarDatos()) {
            System.out.println("Datos correctos");
        } else {
            System.out.println("Datos con errores. Verifique los valores ingresados.");
        }

        System.out.println("\nCalculando costo...\n");
        System.out.println("------------------------------------------");
        System.out.println("           REPORTE DE ENTREGA             ");
        System.out.println("------------------------------------------");
        dronSeleccionado.mostrarInformacion();
        System.out.println("------------------------------------------\n");

        System.out.println("===== DEMOSTRACION DE SETTER =====\n");

        Droncarga dcDemo = new Droncarga();
        double costoInicial = dcDemo.calcularCostoEntrega();
        System.out.printf("Costo inicial DronCarga (peso=2 kg) -> $%.2f%n", costoInicial);

        dcDemo.setPesoPaquete(4.0);
        double costoNuevo = dcDemo.calcularCostoEntrega();
        System.out.printf("Despues de setPesoPaquete(4.0)      -> $%.2f%n", costoNuevo);
        System.out.printf("Diferencia de costo                 -> $%.2f%n", (costoNuevo - costoInicial));

        System.out.println("\nPrueba de validacion con peso invalido en DronCarga:");
        dcDemo.setPesoPaquete(50);

        System.out.println("\n===== DEMOSTRACION DE POLIMORFISMO =====\n");

        Dron[] drones = { dl, dc, de };

        System.out.println("Lista de drones (tipo Dron):");
        for (Dron d : drones) {
            System.out.printf("-> %-10s | Modelo: %-12s | Costo entrega: $%.2f%n",
                    d.getCodigo(), d.getModelo(), d.calcularCostoEntrega());
        }

        System.out.println("Llamando mostrarInformacion() desde referencia Dron:");
        for (Dron d : drones) {
            d.mostrarInformacion();
            System.out.println();
        }


        sc.close();
    }

    private static int leerEntero() {
        int valor = 0;
        try {
            valor = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Valor no numerico. Se usara 0.");
        }
        return valor;
    }

    private static double leerDouble() {
        double valor = 0;
        try {
            valor = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Valor no numerico. Se usara 0.");
        }
        return valor;
    }
}