package com.example.m1.Classes;

import android.content.Context;
import android.graphics.*;
import android.view.View;
import android.widget.ImageView;

public class GameHandler {

    private Game game;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    // G = Ground
    // R = Road
    // W = Water
    // O = Goal Tile

    // 14 wide 13 tall
    public static final char[][] FROGGER_MAP = {
            {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G'},
            {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'},
            {'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R'},
            {'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G'}
    };

    public GameHandler(Game game) {
        this.game = game;
    }

    public void draw_map(View map) {
        canvas = new Canvas();
        paint = new Paint();
        for (int i = 0; i < FROGGER_MAP.length; i++) {
            for (int j = 0; j < FROGGER_MAP[0].length; j++) {
                Rect rect = new Rect(j * 100, i * 100, (j + 1) * 100, (i + 1) * 100);
                char square = FROGGER_MAP[i][j];
                if (square == 'G') {
                    paint.setColor(Color.GREEN);
                    canvas.drawRect(rect, paint);
                } else if (square == 'W') {
                    paint.setColor(Color.BLUE);
                    canvas.drawRect(rect, paint);
                } else if (square == 'R') {
                    paint.setColor(Color.RED);
                    canvas.drawRect(rect, paint);
                } else if (square == 'O') {
                    paint.setColor(Color.RED);
                    canvas.drawRect(rect, paint);
                }
            }
        }
        map.draw(canvas);
    }
}
