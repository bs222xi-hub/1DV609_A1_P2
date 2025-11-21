import DiceGame.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class diceGameTest {
    @Mock
    private Dice dice;

    @Mock
    private ScoreBoard scoreBoard;

    @Mock
    private InputProvider input;

    @Mock
    private OutputProvider output;

    @Mock
    private WinSorting leaderboard;



    private Player p1;
    private Player p2;
    private Game sut;


    @BeforeEach
    void setup() {
        p1 = new Player("Alen");
        p2 = new Player("Bogdan");

        sut = new Game(dice, p1, p2, scoreBoard, leaderboard);
    }


    @Test
    public void ShouldQuitGameAfterRoundIsFinish() {
        Mockito.when(dice.rollDice()).thenReturn(5, 6, 3, 10); // Rolls in order

        Mockito.when(input.getInput()).thenReturn("P") // play
                .thenReturn("P").thenReturn("Q"); // quit


        sut.playTheGame(input, output);
        assertEquals(8, sut.getP1().getScore());
        assertEquals(16, sut.getP2().getScore());


    }
}
