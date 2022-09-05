import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {

    Game game = new Game();

    Player player01 =new Player(1,"Boomych", 500);
    Player player02 =new Player(2,"Kamikadze", 505);
    Player player03 =new Player(3,"Butters", 500);
    Player player04 =new Player(4,"Gypsy", 499);
    Player player05 =new Player(5,"Bedolaga", 4999);

    @BeforeEach
    public void registration() {
        game.register(player01);
        game.register(player02);
        game.register(player03);
        game.register(player04);
    }

    @Test
    public void shouldWinFirst() {

        int expected = 1;
        int actual = game.round("Kamikadze", "Boomych");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecond() {

        int expected = 2;
        int actual = game.round("Gypsy", "Kamikadze");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {

        int expected = 0;
        int actual = game.round("Butters", "Boomych");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeException() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Gypsy", "Bedolaga");
        });
    }
}
