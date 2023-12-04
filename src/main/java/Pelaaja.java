import java.util.Random;

/**
 * Represents a player in the game.
 * Handles player choices and wins count.
 */
public class Pelaaja {

    private int voitot;
    private String valinta;

    /**
     * Generates a random choice for the player among rock, paper, or scissors.
     * Updates the 'valinta' field accordingly.
     */
    public void pelaajanValinta() {

        int arvoValinta = new Random().nextInt(3);

        switch (arvoValinta) {
            case 0 -> valinta = "kivi";
            case 1 -> valinta = "paperi";
            case 2 -> valinta = "sakset";
            default -> valinta = "";
        }
    }

    /**
     * Increases the player's win count by one.
     */
    public void setVoitot() {
        voitot++;
    }

    /**
     * Retrieves the number of wins for the player.
     *
     * @return The number of wins
     */
    public int getVoitot() {
        return voitot;
    }

    /**
     * Retrieves the choice made by the player (rock, paper, or scissors).
     *
     * @return The player's choice
     */
    public String getValinta() {
        return valinta;
    }
}

