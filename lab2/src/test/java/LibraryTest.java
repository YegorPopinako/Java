import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Item item1;
    private Item item2;
    private Patron patron;

    @BeforeEach
    void setUp() {
        library = new Library();
        item1 = new Book("Book", "Harry Potter", "Author");
        item2 = new DVD("DVD", "The Matrix", 25);
        patron = new Patron("John Doe", "1234567");

        library.registerPatron(patron);
    }

    @Test
    void testAddItem() {
        assertTrue(library.add(item1));
        assertFalse(library.add(item1)); // Adding the same item again should return false
    }

    @Test
    void testRemoveItem() {
        library.add(item1);
        assertTrue(library.remove(item1));
        assertFalse(library.remove(item2)); // Removing an item not in the library should return false
    }

    @Test
    void testListAvailable() {
        library.add(item1);
        library.add(item2);

        item1.setBorrowed(false);
        item2.setBorrowed(true);

        assertEquals(1, library.listAvailable().size());
    }

    @Test
    void testListBorrowed() {
        library.add(item1);
        library.add(item2);

        item1.setBorrowed(false);
        item2.setBorrowed(true);

        assertEquals(1, library.listBorrowed().size());
    }

    @Test
    void testLendItem() {
        library.add(item1);

        assertTrue(library.lendItem(patron, item1));
        assertFalse(library.lendItem(patron, item1)); // Lending the same item again should return false
        assertFalse(library.lendItem(patron, item2)); // Lending an item not in the library should return false
    }

    @Test
    void testReturnItem() {
        library.add(item1);
        library.lendItem(patron, item1);

        assertTrue(item1.isBorrowed());
        assertNotNull(library.returnItem(patron, item1));
        assertFalse(item1.isBorrowed());
        assertNull(library.returnItem(patron, item1)); // Returning the same item again should return null
    }
}
