import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        library.AddBook("Book1", "Author1", 1234567890L, 2020);
        library.AddBook("Book2", "Author2", 9876543210L, 2019);

        assertEquals(2, library.getSize());
    }


    @Test
    public void testShowBooksEmptyLibrary() {
        String expectedOutput = "Library is empty!\n";

        assertEquals(expectedOutput, getConsoleOutput(() -> library.ShowBooks()));
    }


    @Test
    public void testSearchBookFound() {
        library.AddBook("Book1", "Author1", 1234567890L, 2020);
        library.AddBook("Book2", "Author2", 9876543210L, 2019);

        String expectedOutput = "Book1 Author1 1234567890 2020";
        assertEquals(expectedOutput, getConsoleOutput(() -> library.Search("Book1")));
    }

    @Test
    public void testSearchBookNotFound() {
        library.AddBook("Book1", "Author1", 1234567890L, 2020);
        library.AddBook("Book2", "Author2", 9876543210L, 2019);

        String expectedOutput = "";
        assertNull(library.Search("Book3"));

        // Check that "No book with such a name!" message is printed
        expectedOutput = "No book with such a name!\n";
        assertEquals(expectedOutput, getConsoleOutput(() -> library.Search("Book3")));
    }

    @Test
    public void testDeleteBookFound() {
        library.AddBook("Book1", "Author1", 1234567890L, 2020);
        library.AddBook("Book2", "Author2", 9876543210L, 2019);

        assertNotNull(library.DeleteBook(1234567890L));
        assertEquals(1, library.getSize());
    }

    @Test
    public void testDeleteBookNotFound() {
        library.AddBook("Book1", "Author1", 1234567890L, 2020);
        library.AddBook("Book2", "Author2", 9876543210L, 2019);

        assertNull(library.DeleteBook(9999999999L));
        assertEquals(2, library.getSize());
    }

    private String getConsoleOutput(Runnable action) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        action.run();

        System.setOut(originalOut);

        return outContent.toString();
    }
}
