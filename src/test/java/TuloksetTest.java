import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class to validate the behavior of the {@link Tulokset} class.
 */
public class TuloksetTest {

    private Tulokset tulokset;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Mock
    private Pelaaja p1;
    @Mock
    private Pelaaja p2;

    /**
     * Sets up the test environment by initializing mocks and redirecting the standard output stream.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tulokset = new Tulokset(p1, p2);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Tests the scenario where player 1 wins by choosing 'paper' against player 2's 'rock'.
     */
    @Test
    public void testPelaaja1Voittaa() {
        when(p1.getValinta()).thenReturn("paperi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    /**
     * Tests the scenario where Player 2 wins.
     */
    @Test
    public void testPelaaja2Voittaa() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("paperi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 2 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    /**
     * Tests the scenario where a tie occurs.
     */
    @Test
    public void testTasapeli() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        String expected = "\n\t\t\t Tasapeli \n".replaceAll("\\s+", "");
        String actual = outputStreamCaptor.toString().replaceAll("\\s+", "");

        assertEquals(expected, actual);

    }

    /**
     * Tests the scenario when paperi wins.
     */
    @Test
    public void testPaperiVoittaa() {
        when(p1.getValinta()).thenReturn("paperi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    /**
     * Tests the scenario when kivi wins.
     */
    @Test
    public void testKiviVoittaa() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("sakset");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    /**
     * Tests the scenario when sakset wins.
     */
    @Test
    public void testSaksetVoittaa() {
        when(p1.getValinta()).thenReturn("sakset");
        when(p2.getValinta()).thenReturn("paperi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    /**
     * Tests the condition when the game has ended.
     */
    @Test
    public void testPäättyiköPeli() {
        when(p1.getVoitot()).thenReturn(3);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals(true, tulokset.päättyiköPeli());
    }

    /**
     * Tests the scenario when the game ends and a winner is declared.
     */
    @Test
    public void testTulostaVoittaja() {
        when(p1.getVoitot()).thenReturn(3);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals("Pelin voitti pelaaja numero 1, onneksi olkoon!", tulokset.tulostaVoittaja());
    }

    /**
     * Tests the condition when the game continues with no winner yet.
     */
    @Test
    public void testJatkuukoPeliVielä() {
        when(p1.getVoitot()).thenReturn(2);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals("", tulokset.tulostaVoittaja());
    }

    /**
     * Tests the output of the method 'tulostaVoitot'.
     */
    @Test
    public void testTulostaVoitot() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("paperi");
        when(p1.getVoitot()).thenReturn(2);
        when(p2.getVoitot()).thenReturn(1);

        tulokset.tulostaVoitot();
        assertEquals("Pelaaja 1 : kivi\n\t Pelaaja 1:llä koossa 2 voittoa.\nPelaaja 2 : paperi\n\t Pelaaja 2:llä koossa 1 voittoa.\n",
                outputStreamCaptor.toString().replace("\r", ""));
    }
}
