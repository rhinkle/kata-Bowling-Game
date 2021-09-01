package fr.kata;

public class Game {
    private final int[] rolls = new int[21];
    private int currentRole = 0;

    public void roll(int pins) {
        rolls[currentRole++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;

        for (int i=0; i < 10; i++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex ++;
            } else if (isASpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfCurrentFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int sumOfCurrentFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isASpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
