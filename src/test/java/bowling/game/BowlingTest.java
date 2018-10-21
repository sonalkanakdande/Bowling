package bowling.game;

import bowling.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BowlingTest {

    Game game;

    @Before
    public void setUp (){
        game = new Game();
    }

    @Test
    public void gutterGame() {
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void canScoreOnes() {
        game.roll(1,1, 1,1, 1,1 ,1,1 ,1,1, 1,1 ,1,1, 1,1, 1,1 ,1,1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void canScoreStrikeFollowedByThreeAndTwo (){
        game.roll(5,5, 3,0 , 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(16));
    }

    @Test
    public void canScoreSpareFollowedByThree(){
        game.roll(10,5, 3,0 , 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(26));
    }

    @Test
    public void canScoreFullGame(){
        game.roll(10,10,10,10,10,10,10,10,10,10,10,10);
        assertThat(game.score(), is(300));
    }
}
