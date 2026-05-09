public abstract class Dron {

    protected String codigo;
    protected String modelo;
    protected double distanciaKm;
    protected double pesoPaquete;
    protected double horasVuelo;
    protected double costoBase;

    public Dron() {}

    public Dron(String codigo, String modelo, double distanciaKm,
                double pesoPaquete, double horasVuelo, double costoBase) {
        setCodigo(codigo);
        setModelo(modelo);
        setDistanciaKm(distanciaKm);
        setPesoPaquete(pesoPaquete);
        setHorasVuelo(horasVuelo);
        this.costoBase = costoBase;
    }

    public abstract double calcularCostoEntrega();
    public abstract boolean validarDatos();
    public abstract void setPesoPaquete(double pesoPaquete);

    public void mostrarInformacion() {
        System.out.println("Codigo       : " + codigo);
        System.out.println("Modelo       : " + modelo);
        System.out.println("Distancia    : " + distanciaKm + " km");
        System.out.println("Peso paquete : " + pesoPaquete + " kg");
        System.out.println("Horas vuelo  : " + horasVuelo + " h");
        System.out.println("Costo base   : $" + costoBase);
        System.out.printf("Costo entrega: $%.2f%n", calcularCostoEntrega());
    }

    public String getCodigo()      { return codigo; }
    public String getModelo()      { return modelo; }
    public double getDistanciaKm() { return distanciaKm; }
    public double getPesoPaquete() { return pesoPaquete; }
    public double getHorasVuelo()  { return horasVuelo; }
    public double getCostoBase()   { return costoBase; }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("ERROR: El codigo no puede estar vacio.");
        }
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.trim().isEmpty()) {
            this.modelo = modelo;
        } else {
            System.out.println("ERROR: El modelo no puede estar vacio.");
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm > 0) {
            this.distanciaKm = distanciaKm;
        } else {
            System.out.println("ERROR: La distancia debe ser mayor a 0.");
        }
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0) {
            this.horasVuelo = horasVuelo;
        } else {
            System.out.println("ERROR: Las horas de vuelo deben ser mayores a 0.");
        }
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
}
