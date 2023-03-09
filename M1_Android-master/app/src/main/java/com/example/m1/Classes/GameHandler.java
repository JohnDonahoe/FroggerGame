package com.example.m1.Classes;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameHandler extends View {

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

    public GameHandler(Context context, Game game) {
        super(context);
        this.game = game;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public Canvas draw_map() {
        bitmap = Bitmap.createBitmap(<pixel_width> * FROGGER_MAP[0].length, <pixel_height * FROGGER_MAP.length, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(Bitmap);
        paint = new Paint();
        for (int i = 0; i < FROGGER_MAP.length; i++) {
            for (int j = 0; j < FROGGER_MAP[0].length; j++) {
                Rect rect = new Rect(j * <pixel_width>, i * <pixel_height>, (j + 1) * <pixel_width>, (i + 1) <pixel_height>);
                char square = FROGGER_MAP[i][j];
                if (square == 'G') {
                    paint.setColor(Color.GREEN);
                    canvas.drawColor(rect, paint);
                } else if (square == 'W') {
                    paint.setColor(Color.BLUE);
                    canvas.drawColor(rect, paint);
                } else if (square == 'R') {
                    paint.setColor(Color.BLACK);
                    canvas.drawColor(rect, paint);
                } else if (square == 'O') {
                    paint.setColor(Color.RED);
                    canvas.drawColor(rect, paint);
                }
            }
        }

        return canvas;
    }
}
