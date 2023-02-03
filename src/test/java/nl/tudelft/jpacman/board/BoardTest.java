package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardTest {
    private final static int MAX_HEIGHT = 10;
    private final static int MAX_WIDTH = 10;
    private final static int OFFSET = 5;
    @Test
    public void testWithinBorders() {
        Square[][] grid = new Square[10][10];

        for (int y = 0; y < MAX_HEIGHT; ++y) {
            for (int x = 0; x < MAX_WIDTH; ++x) {
                grid[y][x] = new Square() {
                    @Override
                    public boolean isAccessibleTo(Unit unit) {
                        return false;
                    }

                    @Override
                    public Sprite getSprite() {
                        return null;
                    }
                };
            }
        }

        Board board = new Board(grid);

        for (int y = 0 - OFFSET; y < MAX_HEIGHT + OFFSET; ++y) {
            for (int x = 0 - OFFSET; x < MAX_WIDTH + OFFSET; ++x) {
                if (x < 0 || x > MAX_WIDTH || y < 0 || y > MAX_HEIGHT) {
                    assertFalse(board.withinBorders(x, y));
                }
            }
        }
    }
}
