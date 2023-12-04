import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TuloksetTest {

    private Tulokset tulokset;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Mock
    private Pelaaja p1;
    @Mock
    private Pelaaja p2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tulokset = new Tulokset(p1, p2);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPelaaja1Voittaa() {
        when(p1.getValinta()).thenReturn("paperi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    @Test
    public void testPelaaja2Voittaa() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("paperi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 2 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    @Test
    public void testTasapeli() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        String expected = "\n\t\t\t Tasapeli \n".replaceAll("\\s+", "");
        String actual = outputStreamCaptor.toString().replaceAll("\\s+", "");

        assertEquals(expected, actual);

    }

    @Test
    public void testPaperiVoittaa() {
        when(p1.getValinta()).thenReturn("paperi");
        when(p2.getValinta()).thenReturn("kivi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    @Test
    public void testKiviVoittaa() {
        when(p1.getValinta()).thenReturn("kivi");
        when(p2.getValinta()).thenReturn("sakset");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }

    @Test
    public void testSaksetVoittaa() {
        when(p1.getValinta()).thenReturn("sakset");
        when(p2.getValinta()).thenReturn("paperi");

        tulokset.määritäVoittaja();
        assertEquals("Pelaaja 1 voittaa\n\n", outputStreamCaptor.toString().replace("\r", ""));
    }
    @Test
    public void testPäättyiköPeli() {
        when(p1.getVoitot()).thenReturn(3);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals(true, tulokset.päättyiköPeli());
    }

    @Test
    public void testTulostaVoittaja() {
        when(p1.getVoitot()).thenReturn(3);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals("Pelin voitti pelaaja numero 1, onneksi olkoon!", tulokset.tulostaVoittaja());
    }

    @Test
    public void testJatkuukoPeliVielä() {
        when(p1.getVoitot()).thenReturn(2);
        when(p2.getVoitot()).thenReturn(2);

        assertEquals("", tulokset.tulostaVoittaja());
    }

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
