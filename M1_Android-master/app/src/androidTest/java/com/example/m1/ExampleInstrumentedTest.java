package com.example.m1;

import android.content.Context;
import android.app.Instrumentation;

import android.view.KeyEvent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.m1.Classes.Frog;
import com.example.m1.Classes.Game;
import com.example.m1.Classes.Car;
import com.example.m1.Classes.Log;
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
        frog.moveUp();    // x = 5, y = 10
        int[] temp = {5, 10};
        assertEquals(frog.getPosition()[0], temp[0]);
        assertEquals(frog.getPosition()[1], temp[1]);

        frog.moveRight();
        frog.moveRight();
        frog.moveRight();
        frog.moveDown();
        temp = new int[]{8, 11};
        assertEquals(frog.getPosition()[0], temp[0]);
        assertEquals(frog.getPosition()[1], temp[1]);
    }

    @Test
    public void testMovementOffScreen() {
        Frog frog = new Frog("Red", 1, 1, 1, 1);
        int[] pos = {0, 12};
        frog.setPosition(pos);
        frog.moveLeft();
        frog.moveDown();
        assertEquals(frog.getPosition()[0], pos[0]);
        assertEquals(frog.getPosition()[1], pos[1]);
        pos = new int[]{13, 0};
        frog.setPosition(pos);
        frog.moveRight();
        frog.moveUp();
        assertEquals(frog.getPosition()[0], pos[0]);
        assertEquals(frog.getPosition()[1], pos[1]);
    }

    @Test
    public void testScoreIncreases() {
        Game game = new Game();
        int prev_score = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 9, 10);
        assertTrue(game.getScore() > prev_score);
        prev_score = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 8, 9);
        assertTrue(game.getScore() > prev_score);
    }

    @Test
    public void testNoScoreIncrease() {
        Game game = new Game();
        int prev_score = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_RIGHT, 9, 10);
        game.score(KeyEvent.KEYCODE_DPAD_DOWN, 9, 10);
        game.score(KeyEvent.KEYCODE_DPAD_LEFT, 9, 10);
        assertTrue(game.getScore() == prev_score);

        game.score(KeyEvent.KEYCODE_DPAD_UP, 9, 10);
        game.score(KeyEvent.KEYCODE_DPAD_UP, 8, 9);
        game.score(KeyEvent.KEYCODE_DPAD_UP, 7, 8);
        prev_score = game.getScore();
        //move down twice
        game.score(KeyEvent.KEYCODE_DPAD_UP, 8, 8);
        assertTrue(game.getScore() == prev_score);
    }

    @Test
    public void testF1CarMoveProperly() {
        Car car = new Car();

        car.updateF1Cars();
        //should move their positions to the right by one
        assertEquals(car.getF1Car1()[0], 9);
        assertEquals(car.getF1Car1()[1], 1);

        assertEquals(car.getF1Car2()[0], 9);
        assertEquals(car.getF1Car2()[1], 5);
    }

    @Test
    public void testTrucksMoveProperly() {
        Car car = new Car();

        car.updateTrucks();
        //should move both of their halves to the left by one
        //and wrap around screen when on left edge
        assertEquals(car.getTruck1()[0][0], 5);
        assertEquals(car.getTruck1()[0][1], 7);
        assertEquals(car.getTruck1()[1][0], 5);
        assertEquals(car.getTruck1()[1][1], 0);

        assertEquals(car.getTruck2()[0][0], 5);
        assertEquals(car.getTruck2()[0][1], 4);
        assertEquals(car.getTruck2()[1][0], 5);
        assertEquals(car.getTruck2()[1][1], 5);
    }

    @Test
    public void testDiffCarSpeed() {
        Car car = new Car();
        assertFalse(car.getF1CarSpeed() == car.getPinkCarSpeed());
        assertFalse(car.getF1CarSpeed() == car.getTruckSpeed());
        assertFalse(car.getTruckSpeed() == car.getPinkCarSpeed());
    }

    @Test
    public void testDiffCarDirections() {
        Car car = new Car();
        int f1CarStartPosition = car.getF1Car1()[1];
        int pinkCarStartPosition = car.getPinkCar1()[1];

        car.updateF1Cars();
        car.updatePinkCars();

        int f1CarFinalPosition = car.getF1Car1()[1];
        int pinkCarFinalPosition = car.getPinkCar1()[1];

        int f1Change = f1CarFinalPosition - f1CarStartPosition;
        int pinkChange = pinkCarFinalPosition - pinkCarStartPosition;
        assertFalse(f1Change == pinkChange);
    }

    @Test
    public void testKeyInput() {
        Frog frog = new Frog("Red", 1, 1, 1, 1);
        int[] position = {5, 5};
        frog.setPosition(position);
        frog.move(KeyEvent.KEYCODE_DPAD_RIGHT);
        frog.move(KeyEvent.KEYCODE_DPAD_UP);
        position = new int[]{6, 4};
        assertEquals(frog.getPosition()[0], position[0]);
        assertEquals(frog.getPosition()[1], position[1]);

        frog.move(KeyEvent.KEYCODE_DPAD_LEFT);
        frog.move(KeyEvent.KEYCODE_DPAD_DOWN);
        position = new int[]{5, 5};

        assertEquals(frog.getPosition()[0], position[0]);
        assertEquals(frog.getPosition()[1], position[1]);
    }



    @Test
    public void testScoreIncreasing() {
        Game game = new Game();
        int score1 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 9, 10);
        int score2 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 8, 9);
        int score3 = game.getScore();
        assertFalse((score2 - score1) == (score3 - score2));

        score1 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 4, 5);
        score1 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 3, 4);
        score2 = game.getScore();
        assertFalse((score2 - score1) == (score3 - score2));
    }

    @Test
    public void testTheNoScoreIncrease() {
        Game game = new Game();
        int score1 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 9, 10);
        int score2 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 9, 8);
        int score3 = game.getScore();
        game.score(KeyEvent.KEYCODE_DPAD_UP, 8, 7);

        // check that it increases at first
        assertFalse(score1 == score2);

        assertTrue(score2 == score3);

        assertTrue(score2 == score3);
    }

    @Test
    public void testLoseLifeFromWater() {
        Game game = new Game();
        game.setLives(3);
        //  returns true when they are not out of lives
        assertTrue(game.hitWater());
        assertEquals(2, game.getLives());
    }

    @Test
    public void testScoreResetFromWater() {
        Game game = new Game();
        game.setLives(3);
        game.setScore(30);
        game.hitWater();
        assertEquals(0, game.getTheScore());
    }

    @Test
    public void testLoseLifeFromCar() {
        Game game = new Game();
        game.setLives(3);
        //  returns true when they are not out of lives
        assertTrue(game.hitCar());
        assertEquals(2, game.getLives());
    }

    @Test
    public void testScoreResetFromCar() {
        Game game = new Game();
        game.setLives(3);
        game.setScore(30);
        game.hitCar();
        assertEquals(0, game.getTheScore());
    }

    @Test
    public void testGameOverWhenNoMoreLivesAfterHitWater () {
        Game game = new Game();
        game.setLives(1);
        //returns false when out of lives for the end Game Screen ti be shown
        assertFalse(game.hitWater());
    }

    @Test
    public void testGameOverWhenNoMoreLivesAfterHitCar() {
        Game game = new Game();
        game.setLives(1);
        //returns false when out of lives for the end game screen to be shown
        assertFalse(game.hitCar());
    }

    @Test
    public void testKeepsHighestScore() {
        Game game = new Game();
        game.setLives(3);
        game.setScore(60);
        game.hitWater();
        assertEquals(0, game.getTheScore());
        assertEquals(60, game.getHighestScore());
        game.setScore(30);
        game.hitWater();
        assertEquals(60, game.getHighestScore());
    }

    @Test
    public void testRespawnIsOriginalLocation() {
        Game game = new Game();
        game.setLives(3);
        game.setFrog(new Frog());
        int x = game.getFrog().getPosX();
        int y = game.getFrog().getPosY();
        game.getFrog().moveLeft();
        game.hitCar();
        assertEquals(x, game.getFrog().getPosX());
        assertEquals(y, game.getFrog().getPosY());

        game = new Game();
        game.setLives(3);
        game.setFrog(new Frog());
        x = game.getFrog().getPosX();
        y = game.getFrog().getPosY();
        game.getFrog().moveLeft();
        game.hitWater();
        assertEquals(x, game.getFrog().getPosX());
        assertEquals(y, game.getFrog().getPosY());
    }

    @Test
    public void testRespawnAfterWater() {
        Game game = new Game();
        game.setLives(3);
        game.getFrog().moveLeft();
        game.hitWater();
        assertEquals(6, game.getFrog().getPosX());
        assertEquals(12, game.getFrog().getPosY());
    }

    @Test
    public void testRespawnAfterCar() {
        Game game = new Game();
        game.setLives(3);
        game.getFrog().moveLeft();
        game.hitCar();
        assertEquals(6, game.getFrog().getPosX());
        assertEquals(12, game.getFrog().getPosY());
    }

    //Sprint 5
    @Test
    public void atestCheckRows() {
        //Log positions Row 1: 0 1 3 4 6 7
        //              Row 2: 0 1 2 4 5 6
        //              Row 3: 0 1 2 4 5 6
        //              Row 4: 0 1 3 4 6 7

        assertTrue(Log.checkRow1(3));
        assertFalse(Log.checkRow1(5));

        assertTrue(Log.checkRow2(0));
        assertFalse(Log.checkRow2(3));

        assertTrue(Log.checkRow3(2));
        assertFalse(Log.checkRow3(7));

        assertTrue(Log.checkRow4(1));
        assertFalse(Log.checkRow4(5));
    }

    @Test
    public void testCheckWater() {
        Game game = new Game();
        assertTrue(Game.checkWater(0, 2));
        assertFalse(Game.checkWater(0, 7));

        assertTrue(Game.checkWater(1, 3));
        assertFalse(Game.checkWater(1, 0));

        assertTrue(Game.checkWater(2, 7));
        assertFalse(Game.checkWater(2, 1));

        assertTrue(Game.checkWater(3, 5));
        assertFalse(Game.checkWater(3, 4));
    }

    @Test
    public void testZRow1LogsMoveCorrectly() {
        assertEquals(Log.getRow1Log1(), new int[][] {{3, 0}, {3, 1}});
        assertEquals(Log.getRow1Log2(), new int[][] {{3, 3}, {3, 4}});
        assertEquals(Log.getRow1Log3(), new int[][] {{3, 6}, {3, 7}});

        Log.updateRow1();

        assertEquals(Log.getRow1Log1(), new int[][] {{3, 7}, {3, 0}});
        assertEquals(Log.getRow1Log2(), new int[][] {{3, 2}, {3, 3}});
        assertEquals(Log.getRow1Log3(), new int[][] {{3, 5}, {3, 6}});

        Log.updateRow1();

        assertEquals(Log.getRow1Log1(), new int[][] {{3, 6}, {3, 7}});
        assertEquals(Log.getRow1Log2(), new int[][] {{3, 1}, {3, 2}});
        assertEquals(Log.getRow1Log3(), new int[][] {{3, 4}, {3, 5}});

    }

    @Test
    public void testZRow2LogsMoveCorrectly() {
        assertEquals(Log.getRow2Log1(), new int[][] {{2, 0}, {2, 1}, {2, 2}});
        assertEquals(Log.getRow2Log2(), new int[][] {{2, 4}, {2, 5}, {2, 6}});

        Log.updateRow2();

        assertEquals(Log.getRow2Log1(), new int[][] {{2, 1}, {2, 2}, {2, 3}});
        assertEquals(Log.getRow2Log2(), new int[][] {{2, 5}, {2, 6}, {2, 7}});

        Log.updateRow2();

        assertEquals(Log.getRow2Log1(), new int[][] {{2, 2}, {2, 3}, {2, 4}});
        assertEquals(Log.getRow2Log2(), new int[][] {{2, 6}, {2, 7}, {2, 0}});
    }
}