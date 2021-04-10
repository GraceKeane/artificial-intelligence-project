package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 * @author Grace Keane
 * 
 * Class that links to find enemy fuzzy logic file.
 * 
 */
public class FindEnemy {
	
	private final FIS fis2 = Runner.fis2;
	
	/**
     * getEnemyHelper
     * 
     * @param enemyLocation passing in the enemy location
     * @param playerLocation passing in the player location
     * @return findEnemy.fcl prompts
     */
	public int getEnemyHelper(int enemyLocation, int playerLocation) {
    	// Links to findExit Fuzzy Logic file
        FunctionBlock fb = fis2.getFunctionBlock("findEnemy");
        // Apply a value to variable
        fis2.setVariable("playerLocation", playerLocation);
        fis2.setVariable("enemyLocation", enemyLocation);
        // Execute the fuzzy inference engine
        fis2.evaluate();
        Variable findEnemy = fb.getVariable("enemy");
        // Return fuzzy logic based on enemy location
        return (int) findEnemy.getValue();
	}

}
