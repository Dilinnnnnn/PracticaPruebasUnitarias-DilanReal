package ec.edu.epn.smartwallet;

public class SmartWallet {

    private double saldo;
    private String tipoUsuario;
    private boolean activa;

    public SmartWallet(String tipoUsuario, double saldoInicial) {
        this.tipoUsuario = tipoUsuario;
        this.saldo = saldoInicial;
        this.activa = true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (tipoUsuario.equals("Standard") && (saldo + amount) > 5000) {
            return false;
        }

        if (amount > 100) {
            saldo += amount + (amount * 0.01);
        } else {
            saldo += amount;
        }

        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > saldo) {
            return false;
        }

        saldo -= amount;

        if (saldo == 0) {
            activa = false;
        }

        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }
}
