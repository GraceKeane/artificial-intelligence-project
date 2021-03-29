package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * @author Grace Keane
 * 
 */

public class ExitHelper {
	
	private final FIS fis = Runner.fis;

    /**
     * getFuzzyHelper
     *
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
        return (int) findExit.getValue();
    }
}

