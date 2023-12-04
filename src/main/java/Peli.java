/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String[] args) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Tulokset tulokset = new Tulokset(p1, p2);

        pelaaPeli(p1, p2, tulokset);

        System.out.println("KOLME VOITTOA - PELI PÄÄTTYY!\n");
        System.out.println(tulokset.tulostaVoittaja());
    }

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

