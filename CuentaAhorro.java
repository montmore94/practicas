class CuentaAhorro extends Cliente {
    private double tasaInteres;

    public CuentaAhorro(String nombre, double saldoInicial, double tasaInteres) {
        super(nombre, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public void calcularIntereses() {
        double intereses = getSaldo() * tasaInteres / 100;
        depositar(intereses);
        System.out.println("Intereses calculados: $" + intereses);
    }
}