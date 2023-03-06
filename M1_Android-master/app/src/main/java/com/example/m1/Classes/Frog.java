import android.graphics.Rect;

public class Frog {
    private String color;
    private String image_name;
    private Rect rectangle;

    public Frog(String color, int left, int top, int right, int bottom) {
        this.color = color;
        if (color.equals("Blue")) {
            this.image_name = "pngfind_com_frogger_png_5284221.png";
        } else if (color.equals("Red")) {
            this.image_name = "pngwing_com.png";
        } else {
            this.image_name = "redfrogger.png";
        }
        this.rectangle = new Rect(left, top, right, bottom);
    }

    public String getColor() {
        return this.color;
    }

    public String getImageName() {
        return this.image_name;
    }

    public Rect getRectangle() {
        return this.rectangle;
    }
}