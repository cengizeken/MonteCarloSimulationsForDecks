import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonteCarloSimulationForDecks {

    public static void main(String[] args) {
        int deckSize = 52;
        int numSimulations = 100000;
        double result = monteCarloSimulation(deckSize, numSimulations);
        System.out.printf("The estimated probability is approximately: %.5f\n", result);
    }

    public static double monteCarloSimulation(int deckSize, int numSimulations) {
        int countKingsNextToEachOther = 0;

        for (int i = 0; i < numSimulations; i++) {
            // Create a shuffled deck
            List<String> deck = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                    "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                    "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K",
                    "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
            Collections.shuffle(deck);

            // Check if at least two Kings are next to each other
            for (int j = 0; j < deckSize - 1; j++) {
                if (deck.get(j).equals("K") && deck.get(j + 1).equals("K")) {
                    countKingsNextToEachOther++;
                    break;
                }
            }
        }

        return (double) countKingsNextToEachOther / numSimulations;
    }
}
