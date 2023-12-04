import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KiviPaperiSaksetLogiikkaTest {

    @Test
    public void testMääritäVoittaja() {
        KiviPaperiSaksetLogiikka logiikka = new KiviPaperiSaksetLogiikka();
        String voitto = logiikka.määritäVoittaja("kivi", "paperi");
        assertEquals("Pelaaja 2 voittaa\n", voitto);
    }
}
