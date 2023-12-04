/**
 * The main class for running the game.
 */
public class Peli {

    /**
     * The main method to start the game.
     *
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Tulokset tulokset = new Tulokset(p1, p2);

        pelaaPeli(p1, p2, tulokset);

        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY!\n");
        System.out.println(tulokset.tulostaVoittaja());
    }

    /**
     * Method to play the game rounds.
     *
     * @param p1       Player 1
     * @param p2       Player 2
     * @param tulokset Game results and logic handler
     */
    private static void pelaaPeli(Pelaaja p1, Pelaaja p2, Tulokset tulokset) {
        do {
            tulokset.tulostaPelienMäärä();
            tulokset.tulostaTasaPelienMäärä();

            p1.pelaajanValinta();
            p2.pelaajanValinta();

            tulokset.tulostaVoitot();
            tulokset.määritäVoittaja();
            tulokset.setPelienMäärä();

        } while (!tulokset.päättyiköPeli());
    }
}

