package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.board.Unit;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * New Test Case example
 * @author John Businge
 */
public class PlayerTest {
    /**
     * I prefer to save the instances for this test in particular
     * because it is really a pain to instantiate Player, and I
     * will want to test other methods of Player in here.
     */
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private Player ThePlayer = Factory.createPacMan();

    @Test
    void testAlive(){
        assertThat(ThePlayer.isAlive()).isEqualTo(true);
    }

    @Test
    void testGetKiller() {
        Unit mockKiller = mock(Unit.class); // Creating a mock killer
        ThePlayer.setKiller(mockKiller);    // Setting the killer for the player
        
        Unit killer = ThePlayer.getKiller(); //gets the unit that killed the player 

        assertThat(killer).isEqualTo(mockKiller); 
    }
}
