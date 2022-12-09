package lld_practice.LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;
    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int total_sum = 0;
        int usedDice = diceCount;
        while (usedDice > 0) {
            int num = ThreadLocalRandom.current().nextInt(min, max+1);
            total_sum += num;
            usedDice--;
        }
        return total_sum;
    }
}
