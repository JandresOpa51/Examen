
public class CuentaBancaria {

    private String titular;
    private String numeroCuenta;
    private double saldo;
    private double limiteRetiro;

    public CuentaBancaria() {
        titular = "Sin asignar";
        numeroCuenta = "0000";
        saldo = 0;
        limiteRetiro = 500000;
    }

    public CuentaBancaria(String titular, String numeroCuenta,
            double saldo, double limiteRetiro) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.limiteRetiro = limiteRetiro;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteRetiro() {
        return limiteRetiro;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Nombre no valido.");
        }
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && !numeroCuenta.trim().isEmpty()) {
            this.numeroCuenta = numeroCuenta;
        } else {
            System.out.println("Numero de cuenta no valido.");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo no puede ser negativo.");
        }
    }

    public void setLimiteRetiro(double limiteRetiro) {
        if (limiteRetiro >= 0) {
            this.limiteRetiro = limiteRetiro;
        } else {
            System.out.println("El limite no puede ser negativo.");
        }
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente.");
        } else if (monto > limiteRetiro) {
            System.out.println("Supera el limite de retiro.");
        } else {
            saldo = saldo - monto;
            System.out.println("Retiro realizado correctamente.");
            System.out.println("Saldo actual: $" + saldo);
        }
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
        } else {
            saldo = saldo + monto;

            if (monto > 2000000) {
                double bonificacion = monto * 0.01;
                saldo = saldo + bonificacion;
                System.out.println("Bonificacion del 1%: $" + bonificacion);
            }

            System.out.println("Deposito realizado correctamente.");
            System.out.println("Saldo actual: $" + saldo);
        }
    }

    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Limite de retiro: $" + limiteRetiro);
    }
}
