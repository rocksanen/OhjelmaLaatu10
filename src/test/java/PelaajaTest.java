import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test class to verify the behavior of the {@link Pelaaja} class.
 */
public class PelaajaTest {
    @Mock
    private Pelaaja p;

    /**
     * Tests the method pelaajanValinta to ensure the player's choice is valid.
     */
    @Test
    public void testPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.pelaajanValinta();
        String valinta = pelaaja.getValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
    }

    /**
     * Tests the method setVoitot to ensure it increments the player's wins correctly.
     */
    @Test
    public void testSetVoitot() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Tests the method getVoitot to verify the initial wins count for a player.
     */
    @Test
    public void testGetVoitot() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
    }

    /**
     * Tests the method getValinta using Mockito to mock the behavior of the method.
     */
    @Test
    public void testGetValinta() {
        MockitoAnnotations.openMocks(this);
        when(p.getValinta()).thenReturn("paperi");
        assertEquals("paperi", p.getValinta());
    }
}
