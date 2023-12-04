import java.util.HashMap;

public class KiviPaperiSaksetLogiikka {

    private final HashMap<String, String> voittajaEhdot;

    public KiviPaperiSaksetLogiikka() {
        voittajaEhdot = new HashMap<>();
        alustaVoittajanMäärittelyLista();
    }

    private void alustaVoittajanMäärittelyLista() {
        voittajaEhdot.put("kivi-paperi", "Pelaaja 2 voittaa\n");
        voittajaEhdot.put("paperi-kivi", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("kivi-sakset", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("sakset-kivi", "Pelaaja 2 voittaa\n");
        voittajaEhdot.put("sakset-paperi", "Pelaaja 1 voittaa\n");
        voittajaEhdot.put("paperi-sakset", "Pelaaja 2 voittaa\n");
    }

    public String määritäVoittaja(String pelaaja1Valinta, String pelaaja2Valinta) {
        String key = pelaaja1Valinta + "-" + pelaaja2Valinta;
        return voittajaEhdot.getOrDefault(key, "\n\t\t\t Tasapeli \n");
    }
}
