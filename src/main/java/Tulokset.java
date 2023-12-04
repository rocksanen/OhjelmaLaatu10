import java.util.ArrayList;

/**
 * Represents the game results and tracks the progress of the game between players.
 */
public class Tulokset {

    private final ArrayList<Pelaaja> pelaajaLista;
    private int pelienMäärä;
    private int tasaPelienMäärä;
    private final int TARVITTAVA_VOITTOJEN_MÄÄRÄ = 3;
    private final KiviPaperiSaksetLogiikka logiikka;

    /**
     * Constructs a Tulokset object to manage game results between players.
     *
     * @param p1 The first player
     * @param p2 The second player
     */
    public Tulokset(Pelaaja p1, Pelaaja p2) {

        this.logiikka = new KiviPaperiSaksetLogiikka();
        this.pelaajaLista = new ArrayList<>();

        pelaajaLista.add(p1);
        pelaajaLista.add(p2);

        this.pelienMäärä = 0;
        this.tasaPelienMäärä = 0;
    }

    /**
     * Prints the current score for each player.
     */
    public void tulostaVoitot() {

        for (int i = 0; i < pelaajaLista.size(); i++) {
            System.out.println("Pelaaja " + (i + 1) + " : " + pelaajaLista.get(i).getValinta()
                    + "\n\t Pelaaja " + (i + 1) + ":llä koossa " + pelaajaLista.get(i).getVoitot() + " voittoa.");
        }
    }

    /**
     * Prints the number of games played.
     */
    public void tulostaPelienMäärä() {
        System.out.println("Erä: " + pelienMäärä + " ======================================================");
    }

    /**
     * Increments the game count by one.
     */
    public void setPelienMäärä() {
        pelienMäärä++;
    }

    /**
     * Increments the tie game count by one.
     */
    public void setTasaPelienMäärä() {
        tasaPelienMäärä++;
    }

    /**
     * Prints the number of tie games played.
     */
    public void tulostaTasaPelienMäärä() {
        System.out.println("Tasapelien lukumäärä: " + tasaPelienMäärä + "\n");
    }

    /**
     * Checks if the game has ended.
     *
     * @return True if the game has ended, otherwise false
     */
    public Boolean päättyiköPeli() {

        for (Pelaaja pelaaja : pelaajaLista) {
            if (pelaaja.getVoitot() >= TARVITTAVA_VOITTOJEN_MÄÄRÄ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines the winner of the current round and updates scores.
     */
    public void määritäVoittaja() {
        String p1Valinta = pelaajaLista.get(0).getValinta();
        String p2Valinta = pelaajaLista.get(1).getValinta();

        String voittoTulos = logiikka.määritäVoittaja(p1Valinta, p2Valinta);
        System.out.println(voittoTulos);

        if (voittoTulos.contains("Pelaaja 1")) {
            pelaajaLista.get(0).setVoitot();
        } else if (voittoTulos.contains("Pelaaja 2")) {
            pelaajaLista.get(1).setVoitot();
        } else {
            setTasaPelienMäärä();
        }
    }

    /**
     * Prints the winner of the game.
     *
     * @return A string indicating the winner of the game
     */
    public String tulostaVoittaja() {

        for (int i = 0; i < pelaajaLista.size(); i++) {
            if (pelaajaLista.get(i).getVoitot() == TARVITTAVA_VOITTOJEN_MÄÄRÄ) {
                return "Pelin voitti pelaaja numero " + (i + 1) + ", onneksi olkoon!";
            }
        }
        return "";
    }
}
