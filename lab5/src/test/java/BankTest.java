import org.example.AccountNotFoundException;
import org.example.Bank;
import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() {
        assertTrue(bank.createAccount("Alice", 1000.0));
        assertTrue(bank.createAccount("Bob", 500.0));
        assertTrue(bank.createAccount("Charlie", 2000.0));
    }

    @Test
    public void testFindAccount() {
        bank.createAccount("Alice", 1000.0);
        bank.createAccount("Bob", 500.0);
        bank.createAccount("Charlie", 2000.0);

        BankAccount foundAccount = bank.findAccount(2); // Find Bob's account
        assertNotNull(foundAccount);
        assertEquals("Bob", foundAccount.getAccountName());
    }

    @Test
    public void testTransferMoney() {
        bank.createAccount("Alice", 1000.0);
        bank.createAccount("Bob", 500.0);

        double transferredAmount = bank.transferMoney(1, 2, 200.0);
        assertEquals(200.0, transferredAmount);

        BankAccount alice = bank.findAccount(1);
        BankAccount bob = bank.findAccount(2);

        assertEquals(800.0, alice.getBalance());
        assertEquals(700.0, bob.getBalance());

    }
}
