public class Dronliviano extends Dron {

    private double limiteHoras;

    private static final double PESO_MAXIMO   = 5.0;
    private static final double HORAS_MAXIMAS = 2.0;
    private static final double COSTO_BASE    = 3.00;

    public Dronliviano() {
        this.codigo      = "DL-000";
        this.modelo      = "LivianoX";
        this.distanciaKm = 5.0;
        this.pesoPaquete = 2.0;
        this.horasVuelo  = 1.0;
        this.costoBase   = COSTO_BASE;
        this.limiteHoras = HORAS_MAXIMAS;
    }

    public double getLimiteHoras() { return limiteHoras; }

    public void setLimiteHoras(double limiteHoras) {
        if (limiteHoras > 0) this.limiteHoras = limiteHoras;
    }

    @Override
    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0 && pesoPaquete <= PESO_MAXIMO) {
            this.pesoPaquete = pesoPaquete;
        } else if (pesoPaquete > PESO_MAXIMO) {
            System.out.println("ERROR: El peso excede el limite permitido (" + PESO_MAXIMO + " kg).");
            System.out.println("No se guardaron los cambios.");
        } else {
            System.out.println("ERROR: El peso debe ser mayor a 0.");
        }
    }

    @Override
    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0 && horasVuelo <= HORAS_MAXIMAS) {
            this.horasVuelo = horasVuelo;
        } else if (horasVuelo > HORAS_MAXIMAS) {
            System.out.println("ERROR: Las horas de vuelo exceden el limite (" + HORAS_MAXIMAS + " h).");
        } else {
            System.out.println("ERROR: Las horas de vuelo deben ser mayores a 0.");
        }
    }

    @Override
    public double calcularCostoEntrega() {
        return costoBase + (distanciaKm * 0.80) + (pesoPaquete * 0.50);
    }

    @Override
    public boolean validarDatos() {
        if (codigo == null || codigo.trim().isEmpty()) return false;
        if (modelo == null || modelo.trim().isEmpty()) return false;
        if (distanciaKm <= 0) return false;
        if (pesoPaquete <= 0 || pesoPaquete > PESO_MAXIMO) return false;
        if (horasVuelo <= 0 || horasVuelo > HORAS_MAXIMAS) return false;
        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON LIVIANO ======");
        System.out.println("Codigo       : " + codigo);
        System.out.println("Modelo       : " + modelo);
        System.out.println("Distancia    : " + distanciaKm + " km");
        System.out.println("Peso paquete : " + pesoPaquete + " kg");
        System.out.println("Horas vuelo  : " + horasVuelo + " h");
        System.out.println("Carga maxima : " + PESO_MAXIMO + " kg");
        System.out.println("Horas maximas: " + HORAS_MAXIMAS + " h");
        System.out.println("Costo base   : $" + costoBase);
        System.out.printf("Costo entrega: $%.2f%n", calcularCostoEntrega());
    }
}
