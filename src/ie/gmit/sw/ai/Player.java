package ie.gmit.sw.ai;

public class Player{
	private double health = 100;
	private double anger = 0;
	private int durability = 0;

	public Player(){
	}
	
	public double getDurability(){
		return durability;
	}

	public double getAnger() {
		return anger;
	}

	public void setAnger(double anger) {
		this.anger = anger;
	}
	
	public void addAnger(){
		if (this.anger >= 95){
			this.anger = 100;
		}else{
			this.anger += 5;
		}
	}
	
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		if (health <= 0){
			System.out.println("Defeat. Game Lost "); 
			System.exit(0);
		}
		this.health = health;
	}
}
