import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the logic in {@link KiviPaperiSaksetLogiikka}.
 */
public class KiviPaperiSaksetLogiikkaTest {

    /**
     * Tests the method määritäVoittaja to ensure it correctly determines the winner.
     */
    @Test
    public void testMääritäVoittaja() {
        KiviPaperiSaksetLogiikka logiikka = new KiviPaperiSaksetLogiikka();
        String voitto = logiikka.määritäVoittaja("kivi", "paperi");
        assertEquals("Pelaaja 2 voittaa\n", voitto);
    }
}
