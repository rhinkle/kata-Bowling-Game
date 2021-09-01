package fr.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private Game g;

    @BeforeEach
    protected void setUp() {
        g = new Game();
    }

    @Test
    void testGutterGame() throws Exception {
        rollMany(20,0 );
        assertThat(0).isEqualTo(g.score());
    }

    @Test
    void testAllOnes() {
        rollMany(20, 1);
        assertThat(20).isEqualTo(g.score());
    }

    @Test
    void testRollOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertThat(g.score()).isEqualTo(16);
    }

    @Test
    void testRollOneSpareThenAnotherOne2FramesLater() {
        rollSpare();
        g.roll(3);
        g.roll(4);
        rollSpare();
        g.roll(3);
        rollMany(13, 0);
        assertThat(g.score()).isEqualTo(36);
    }

    @Test
    void testRollOneStrike() {
        roleStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertThat(g.score()).isEqualTo(24);
    }

    @Test
    void testRollPerfectGame() {
        rollMany(12, 10);
        assertThat(g.score()).isEqualTo(300);
    }

    private void roleStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollMany(int rollForCount, int pins) {
        for (int i = 0; i < rollForCount; i++) {
            g.roll(pins);
        }
    }
}
