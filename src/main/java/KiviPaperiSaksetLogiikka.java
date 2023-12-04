import java.util.HashMap;

/**
 * Handles the logic for a Rock-Paper-Scissors game determining the winner.
 */
public class KiviPaperiSaksetLogiikka {

    private final HashMap<String, String> voittajaEhdot;

    /**
     * Constructs a logic handler for the Rock-Paper-Scissors game and initializes winning conditions.
     */
    public KiviPaperiSaksetLogiikka() {
        voittajaEhdot = new HashMap<>();
        alustaVoittajanMäärittelyLista();
    }

    /**
     * Private method to initialize winning conditions
     */
    private void alustaVoittajanMäärittelyLista() {
        voittajaEhdot.put("kivi-paperi", "Pelaaja 2 voittaa\n");
        voittajaEhdot.put("paperi-kivi", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("kivi-sakset", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("sakset-kivi", "Pelaaja 2 voittaa\n");
        voittajaEhdot.put("sakset-paperi", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("paperi-sakset", "Pelaaja 2 voittaa\n");
    }

    /**
     * Determines the winner based on the players' choices.
     *
     * @param pelaaja1Valinta Player 1's choice (e.g., "kivi", "paperi", "sakset")
     * @param pelaaja2Valinta Player 2's choice (e.g., "kivi", "paperi", "sakset")
     * @return A string indicating the winner or a tie ("Pelaaja 1 voittaa", "Pelaaja 2 voittaa", "Tasapeli")
     */
    public String määritäVoittaja(String pelaaja1Valinta, String pelaaja2Valinta) {
        String key = pelaaja1Valinta + "-" + pelaaja2Valinta;
        return voittajaEhdot.getOrDefault(key, "\n\t\t\t Tasapeli \n");
    }
}
