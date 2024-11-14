import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void itMustInitializeGame(){
        game = new Game();
    }

    @Test
    public void itMustNotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play('O', 0, 0));
    }

    @Test
    public void itMustNotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('X', 1, 0);
        });
    }

    @Test
    public void itMustNotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('O', 0, 0);
        });
    }

    @Test
    public void itMustNotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play('X', 0, 0);
            game.play('O', 1, 0);
            game.play('X', 0, 0);
        });
    }

    @Test
    public void itMustDeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void itMustDeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 2, 2);
        game.play('O', 0, 0);
        game.play('X', 1, 0);
        game.play('O', 0, 1);
        game.play('X', 1, 1);
        game.play('O', 0, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    public void itMustDeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 1, 0);
        game.play('O', 0, 0);
        game.play('X', 1, 1);
        game.play('O', 0, 1);
        game.play('X', 1, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void itMustDeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 2, 0);
        game.play('O', 1, 1);
        game.play('X', 2, 1);
        game.play('O', 1, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    public void itMustDeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 2, 0);
        game.play('O', 0, 0);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void itMustDeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 2, 1);
        game.play('X', 1, 1);
        game.play('O', 2, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }
}
