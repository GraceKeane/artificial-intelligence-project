package ie.gmit.sw.ai;


/**
 * @author Grace Keane 
 * 
 * Using implementations of this functional interface to specify
 * how a computer controlled game character should behave.
 */

@FunctionalInterface
public interface Command {
	public void execute();
}