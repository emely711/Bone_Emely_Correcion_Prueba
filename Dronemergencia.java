public class Dronemergencia extends Dron {

    private double recargoUrgencia;
    private int    nivelPrioridad;

    private static final double PESO_MAXIMO   = 10.0;
    private static final double HORAS_MAXIMAS = 3.0;
    private static final double COSTO_BASE    = 8.00;
    private static final double RECARGO_BASE  = 10.0;

    public Dronemergencia() {
        this.codigo          = "DE-000";
        this.modelo          = "Emergente";
        this.distanciaKm     = 5.0;
        this.pesoPaquete     = 2.0;
        this.horasVuelo      = 1.0;
        this.costoBase       = COSTO_BASE;
        this.recargoUrgencia = RECARGO_BASE;
        this.nivelPrioridad  = 2;
    }

    public double getRecargoUrgencia() { return recargoUrgencia; }
    public int    getNivelPrioridad()  { return nivelPrioridad; }

    public void setRecargoUrgencia(double recargoUrgencia) {
        if (recargoUrgencia >= 0) {
            this.recargoUrgencia = recargoUrgencia;
        } else {
            System.out.println("ERROR: El recargo de urgencia no puede ser negativo.");
        }
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad >= 1 && nivelPrioridad <= 3) {
            this.nivelPrioridad = nivelPrioridad;
        } else {
            System.out.println("ERROR: El nivel de prioridad debe estar entre 1 y 3.");
        }
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
        return costoBase + (distanciaKm * 1.50) + (pesoPaquete * 0.90) + recargoUrgencia;
    }

    @Override
    public boolean validarDatos() {
        if (codigo == null || codigo.trim().isEmpty()) return false;
        if (modelo == null || modelo.trim().isEmpty()) return false;
        if (distanciaKm <= 0) return false;
        if (pesoPaquete <= 0 || pesoPaquete > PESO_MAXIMO) return false;
        if (horasVuelo <= 0 || horasVuelo > HORAS_MAXIMAS) return false;
        if (nivelPrioridad < 1 || nivelPrioridad > 3) return false;
        return true;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON EMERGENCIA ======");
        System.out.println("Codigo          : " + codigo);
        System.out.println("Modelo          : " + modelo);
        System.out.println("Distancia       : " + distanciaKm + " km");
        System.out.println("Peso paquete    : " + pesoPaquete + " kg");
        System.out.println("Horas vuelo     : " + horasVuelo + " h");
        System.out.println("Carga maxima    : " + PESO_MAXIMO + " kg");
        System.out.println("Horas maximas   : " + HORAS_MAXIMAS + " h");
        System.out.println("Costo base      : $" + costoBase);
        System.out.println("Recargo urgencia: $" + recargoUrgencia);
        System.out.println("Nivel prioridad : " + nivelPrioridad);
        System.out.printf("Costo entrega   : $%.2f%n", calcularCostoEntrega());
    }
}