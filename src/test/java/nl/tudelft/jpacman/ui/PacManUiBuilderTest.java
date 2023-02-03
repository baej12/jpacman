package nl.tudelft.jpacman.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class PacManUiBuilderTest {

    private PacManUiBuilder uiBuilder = new PacManUiBuilder();

    @Test
    public void testAddKey() {
        Integer goodKeyCode = 55;

        boolean badKeyFlag = false, badActionFlag = false, normalFlag = false;
        Action goodAction = new Action() {
            @Override
            public void doAction() {
                System.out.println("Doing testing action");
            }
        };

        //Test keyCode null
        try {
            uiBuilder.addKey(null, goodAction);
        } catch (AssertionError e) {
            badKeyFlag = true;
        }

        //Test action null
        try {
            uiBuilder.addKey(goodKeyCode, null);
        } catch (AssertionError e) {
            badActionFlag = true;
        }

        //Test normal
        try {
            uiBuilder.addKey(goodKeyCode, goodAction);
            normalFlag = true;
        } catch (Exception e) {
            fail();
        }

        assertTrue(badKeyFlag && badActionFlag && normalFlag);
    }

    @Test
    public void testAddButton() {
        boolean nullCaptionFlag = false,
                emptyCaptionFlag = false,
                nullActionFlag = false,
                normalFlag = false;

        String goodCaption = "Caption for button";
        String emptyCaption = "";
        Action goodAction = new Action() {
            @Override
            public void doAction() {
                System.out.println("Doing good action");
            }
        };

        try {
            uiBuilder.addButton(null, goodAction);
            fail();
        } catch (AssertionError e) {
            nullCaptionFlag = true;
        }

        try {
            uiBuilder.addButton(emptyCaption, goodAction);
            fail();
        } catch (AssertionError e) {
            emptyCaptionFlag = true;
        }

        try {
            uiBuilder.addButton(goodCaption, null);
            fail();
        } catch (AssertionError e) {
            nullActionFlag = true;
        }

        try {
            uiBuilder.addButton(goodCaption, goodAction);
            normalFlag = true;
        } catch (Exception e) {
            fail();
        }

        assertTrue(nullActionFlag && nullCaptionFlag && emptyCaptionFlag && normalFlag);
    }
}
