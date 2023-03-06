public class Game {
    private String name;
    private String difficulty;
    private int lives;
    private Frog frog;
    private int score;

    public Game(String name, String difficulty, int lives, Frog frog) {
        this.name = name;
        this.difficulty = difficulty;
        this.lives = lives;
        this.frog = frog;
        this.score = 0;
    }

    public Game() {
        this(null, null, 0, null);
    }

    public String getName() {
        return this.name
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public int getLives() {
        return this.lives;
    }

    public Frog getFrog() {
        return this.frog;
    }

    public int getScore() {
        return this.score;
    }

    public boolean setName(String name) {
        if (name == null || name.length() == 0) {
            return false
        }
        this.name = name;
        return true
    }

    public boolean setDifficulty(String difficulty) {
        if (difficulty.equals("Easy")) {
            this.difficulty = "Easy";
            this.lives = 3;
        } else if (difficulty.equals("Medium")) {
            this.difficulty = "Medium";
            this.lives = 2;
        } else if (difficulty.equals("Hard")) {
            this.difficulty = "Hard";
            this.lives = 1;
        } else {
            return false;
        }
        return true;
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }
}