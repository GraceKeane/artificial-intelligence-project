package ie.gmit.sw.ai;

/**
 * @author Grace Keane
 * 
 * Player class implements the class Command. Contains player variables
 * and getters and setters.
 */
public class Player implements Command {
	private double health = 100;
	private double anger = 0;
	private double fear = 0;
	private int playerCol;
	private int playerRow;

	public Player() {
		super();
	}

	public Player(double health, double anger) {
		super();
		this.health = health;
		this.anger = anger;

	}

	public Player(int playerRow, int playerCol) {
		super();
		this.playerRow = playerRow;
		this.playerCol = playerCol;
	}

	public Player(double health, double fear, int playerRow, int playerCol) {
		super();
		this.health = health;
		this.fear = fear;
		this.playerRow = playerRow;
		this.playerCol = playerCol;
	}

	public int getPlayerRow() {
		return playerRow;
	}

	public void setPlayerRow(int playerRow) {
		this.playerRow = playerRow;
	}

	public int getPlayerCol() {
		return playerCol;
	}

	public void setPlayerCol(int playerCol) {
		this.playerCol = playerCol;
	}

	public double getAnger() {
		return anger;
	}

	public void setAnger(double anger) {
		this.anger = anger;
	}

	public void addAnger() {
		if (this.anger >= 95) {
			this.anger = 100;
		} else {
			this.anger += 5;
		}
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		if (health <= 0) {
			System.out.println("Defeat.");
			System.exit(0);
		}
		this.health = health;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
}
