public class Player {
    // instance variables
    public String name;
    public String gender;
    public int score;

    // constructors
    public Player() {
        this.name = "Guest";
        this.gender = "N/A";
    }

    public Player(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

}
