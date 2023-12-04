import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PelaajaTest {
    @Mock
    private Pelaaja p;

    @Test
    public void testPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.pelaajanValinta();
        String valinta = pelaaja.getValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    @Test
    public void testSetVoitot() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    public void testGetVoitot() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
    }

    @Test
    public void testGetValinta() {
        MockitoAnnotations.openMocks(this);
        when(p.getValinta()).thenReturn("paperi");
        assertEquals("paperi", p.getValinta());
    }
}
