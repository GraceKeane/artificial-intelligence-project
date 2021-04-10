package ie.gmit.sw.ai;

/**
 * @author Grace Keane
 * 
 * NNExecute implements command and links to character task.
 * Implements enemy neural network functions.
 * 
 */

public class NNExecute implements Command {
	private int health;
	private int enemies;
	private static int playerLives = 4;
	public static int action;
	
	@Override
	public void execute() {
		CharacterTask nn = newCharacterTask();
		action = nn.nnTask(health, enemies);
		
		System.out.println("In execute");
		
		switch (action) {
			case 0 -> panic();
			case 1 -> attack();
			case 2 -> hide();
			case 3 -> run();
		}
	}
	
	public static void panic() {
		System.out.println("Panic");
		
	}
	public static void attack() {
		System.out.println("Attack");		
	}
	public static void hide() {
		System.out.println("Hide");
		
	}
	public static void run() {
		System.out.println("Run");
		
	}

	private CharacterTask newCharacterTask() {
		// TODO Auto-generated method stub
		return null;
	}
}
