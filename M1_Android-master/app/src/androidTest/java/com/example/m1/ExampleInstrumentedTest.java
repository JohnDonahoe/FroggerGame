package com.example.m1;

import android.content.Context;

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


}