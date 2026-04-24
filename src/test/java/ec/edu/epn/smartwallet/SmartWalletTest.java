package ec.edu.epn.smartwallet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmartWalletTest {

    private SmartWallet wallet = null;

    @BeforeEach
    public void setUp() {
        wallet = new SmartWallet("Standard", 0);
    }

    // 1: Deposito valido
    @Test
    public void testDepositoValido() {
        boolean resultado = wallet.deposit(67);
        assertTrue(resultado);
        assertEquals(67, wallet.getSaldo(), 0.01);
    }

    // 2: Deposito con cashback (mayor a 100)
    @Test
    public void testDepositoConCashback() {
        boolean resultado = wallet.deposit(167);
        assertTrue(resultado);
        assertEquals(168.67, wallet.getSaldo(), 0.01);
    }

    // 3: Depposito exactamente 100 (no incluye cashback)
    @Test
    public void testDepositoDe100() {
        boolean resultado = wallet.deposit(100);
        assertTrue(resultado);
        assertEquals(100, wallet.getSaldo(), 0.01);
    }

    // 4: Deposito que pasa el limite Standar de 5000
    @Test
    public void testLimiteDeposito() {
        wallet.deposit(4900);
        boolean resultado = wallet.deposit(200);
        assertFalse(resultado);
        assertEquals(4949, wallet.getSaldo(), 0.01); // El deposito de 4900 llega con cashback
    }

    // 5: Retiro valido
    @Test
    public void testWithdrawValid() {
        wallet.deposit(158);
        boolean resultado = wallet.withdraw(30);
        assertTrue(resultado);
        assertEquals(129.58, wallet.getSaldo(), 0.01);
    }

    // 6: retiro a 0 para dejar cuenta inactiva
    @Test
    public void testRetiroACero() {
        wallet.deposit(155);
        boolean resultado = wallet.withdraw(156.55); // se retira todo y cashback para que el saldo quede en 0
        assertTrue(resultado);
        assertEquals(0, wallet.getSaldo(), 0.01);
        assertFalse(wallet.isActiva());
    }

    // 7: Saldo insuficiente
    @Test
    public void testSaldoInsuficiente() {
        wallet.deposit(50);
        boolean resultado = wallet.withdraw(100);
        assertFalse(resultado);
        assertEquals(50, wallet.getSaldo(), 0.01);
    }

    // 8: Montos negativo
    @Test
    public void testMontoNegativo() {
        wallet.deposit(100);
        boolean resultado = wallet.withdraw(-10);
        assertFalse(resultado);
        assertEquals(100, wallet.getSaldo(), 0.01);
    }
}
