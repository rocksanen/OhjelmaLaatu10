import java.util.ArrayList;

public class Tulokset {

    private final ArrayList<Pelaaja> pelaajaLista;
    private int pelienMäärä;
    private int tasaPelienMäärä;
    private final int TARVITTAVA_VOITTOJEN_MÄÄRÄ = 3;
    private final KiviPaperiSaksetLogiikka logiikka;

    public Tulokset(Pelaaja p1, Pelaaja p2) {

        this.logiikka = new KiviPaperiSaksetLogiikka();
        this.pelaajaLista = new ArrayList<>();

        pelaajaLista.add(p1);
        pelaajaLista.add(p2);

        this.pelienMäärä = 0;
        this.tasaPelienMäärä = 0;
    }

    public void tulostaVoitot() {

        for (int i = 0; i < pelaajaLista.size(); i++) {
            System.out.println("Pelaaja " + (i + 1) + " : " + pelaajaLista.get(i).getValinta()
                    + "\n\t Pelaaja " + (i + 1) + ":llä koossa " + pelaajaLista.get(i).getVoitot() + " voittoa.");
        }
    }

    public void tulostaPelienMäärä() {
        System.out.println("Erä: " + pelienMäärä + " ======================================================");
    }

    public void setPelienMäärä() {
        pelienMäärä++;
    }

    public void setTasaPelienMäärä() {
        tasaPelienMäärä++;
    }

    public void tulostaTasaPelienMäärä() {
        System.out.println("Tasapelien lukumäärä: " + tasaPelienMäärä + "\n");
    }

    public Boolean päättyiköPeli() {

        for (Pelaaja pelaaja : pelaajaLista) {
            if (pelaaja.getVoitot() >= TARVITTAVA_VOITTOJEN_MÄÄRÄ) {
                return true;
            }
        }
        return false;
    }

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

    public String tulostaVoittaja() {

        for (int i = 0; i < pelaajaLista.size(); i++) {
            if (pelaajaLista.get(i).getVoitot() == TARVITTAVA_VOITTOJEN_MÄÄRÄ) {
                return "Pelin voitti pelaaja numero " + (i + 1) + ", onneksi olkoon!";
            }
        }
        return "";
    }
}
