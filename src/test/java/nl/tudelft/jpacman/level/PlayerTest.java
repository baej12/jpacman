package nl.tudelft.jpacman.level;


import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    private static final PacManSprites sprites = new PacManSprites();
    private PlayerFactory playerFactory = new PlayerFactory(sprites);
    private Player player = playerFactory.createPacMan();

    @Test
    public void testIsAlive() {
        var response = player.isAlive();
        assertTrue(response);
    }
}
