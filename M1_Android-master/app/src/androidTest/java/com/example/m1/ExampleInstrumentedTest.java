package com.example.m1;

import android.content.Context;
import android.app.Instrumentation

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.m1", appContext.getPackageName());
    }

    @Test
    public void testNameParameters() {
        Game game = new Game();
        assertFalse(game.setName(null));
        assertFalse(game.setName("     "));
        assertTrue(game.setName("Max"));
    }

    @Test
    public void testDifficulty() {
        Game game = new Game();
        assertFalse(game.setDifficulty("Very Hard"));
        game.setDifficulty("Easy");
        assertEquals(3, game.getLives());
        game.setDifficulty("Medium");
        assertEquals(2, game.getLives());
        game.setDifficulty("Hard");
        assertEquals(1, game.getLives());
    }

    @Test
    public void testMovement() {
        Frog frog = new Frog("Red", 1, 1, 1, 1); //x = 6, y = 12
        frog.moveLeft();
        frog.moveUp();
        frog.move();    // x = 5, y = 10
        int[] temp = {5, 10};
        assertEquals(frog.getPosition(), temp);

        frog.moveRight();
        frog.moveRight();
        frog.moveRight();
        frog.moveDown();
        temp = {8, 11};
        assertEquals(frog.getPosition(), temp);
    }

    @Test
    public void testMovementOffScreen() {
        Frog frog = new Frog("Red", 1, 1, 1, 1);
        int[] pos = {0, 12};
        frog.setPosition(pos);
        frog.moveLeft();
        frog.moveDown();
        assertEquals(frog.getPosition(), pos);
        pos = {13, 0};
        frog.moveRight();
        frog.moveDown();
        assertEquals(frog.getPosition(), pos);
    }

    @Test
    public void testScore() {
        Game game = new Game();
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
        assertEquals(30, game.getScore())
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
        assertEquals(40, game.getScore());


    }

    @Test
    public void testNoScoreIncrease() {
        Game game = new Game();
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
        assertEquals(0, game.getScore());
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_LEFT);
        assertEquals(0, game.getScore());
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        assertEquals(o, game.getScore());
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
        getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT);
        assertEquals(30, game.getScore())

    }
}