import java.util.Random;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitot;
    private String valinta;
    public void pelaajanValinta() {

        int arvoValinta = new Random().nextInt(3);

        switch (arvoValinta) {
            case 0 -> valinta = "kivi";
            case 1 -> valinta = "paperi";
            case 2 -> valinta = "sakset";
            default -> valinta = "";
        }
    }

    // Voittojen lisääminen yhdellä
    public void setVoitot() {
        voitot++;
    }

    // Voittojen haku
    public int getVoitot() {
        return voitot;
    }

    public String getValinta() {
        return valinta;
    }
}

