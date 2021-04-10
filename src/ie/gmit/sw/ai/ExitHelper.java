package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * @author Grace Keane
 * 
 * Class that links to maze exit fuzzy logic file.
 * 
 */

public class ExitHelper {
	
	private final FIS fis = Runner.fis;

    /**
     * getFuzzyHelper
     * 
     * @param playerLocation passing in the player location
     * @param mazeExit passing in the player location
     * @return findExit.fcl prompts
     */
    public int getFuzzyHelper(int playerLocation, int mazeExit) {
    	// Links to findExit Fuzzy Logic file
        FunctionBlock fb = fis.getFunctionBlock("findExit");
        // Apply a value to variable
        fis.setVariable("playerLocation", playerLocation);
        fis.setVariable("mazeExit", mazeExit);
        // Execute the fuzzy inference engine
        fis.evaluate();
        Variable findExit = fb.getVariable("player");
        // Return fuzzy logic based on exit
        return (int) findExit.getValue();
    }
}

