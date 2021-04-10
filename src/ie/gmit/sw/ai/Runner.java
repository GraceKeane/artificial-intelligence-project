package ie.gmit.sw.ai;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

import javafx.application.Application;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 * @author Grace Keane
 * 
 * Reads in Fuzzy logic files and trains neural network first. Once
 * training complete, game executes.
 * 
 */

public class Runner {

	// Fuzzy inferance systems
	public static FIS fis;
	public static FIS fis2;
	// Neural network initialised to stop it from returning null
	private static BasicNetwork basicNetwork;

	private double[][] data = { // Health, Enemies
			{ 2, 0 }, { 2, 1 }, { 2, 1 }, { 2, 2 }, { 2, 2 }, { 2, 1 }, { 1, 0 }, { 1, 1 }, { 1, 1 }, { 1, 2 },
			{ 1, 2 }, { 1, 1 }, { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 2 }, { 0, 2 }, { 0, 1 } };

	private double[][] expected = { // Panic, Attack, Hide, Run
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };

	public int nnTask(int health, int enemies) {
		double[] input = { health, enemies };
		MLData data = new BasicMLData(input);
		return basicNetwork.classify(data);

	}

	// Returing an instance of the next work
	private BasicNetwork declareNetworkTopology() {
		basicNetwork = new BasicNetwork();
		basicNetwork.addLayer(new BasicLayer(null, true, 2));
		basicNetwork.addLayer(new BasicLayer(new ActivationSigmoid(), true, 4));
		basicNetwork.addLayer(new BasicLayer(new ActivationSigmoid(), false, 4));
		basicNetwork.getStructure().finalizeStructure();
		basicNetwork.reset();
		System.out.println("[INFO Network Created]");
		return basicNetwork;

	}

	public void neuralNetwork() {
		// ----------------------------------------------------
		// Step 1: Declare Network Topology
		// ----------------------------------------------------
		System.out.println("[INFO] Creating neural network");
		basicNetwork = declareNetworkTopology();

		// ----------------------------------------------------
		// Step 2: Create the training data set
		// ----------------------------------------------------
		System.out.println("[INFO] Creating training set");
		MLDataSet trainingSet = new BasicMLDataSet(data, expected);

		// ----------------------------------------------------
		// Step 3: Train the NN
		// ----------------------------------------------------
		System.out.println("[INFO] Training the network...");
		ResilientPropagation train = new ResilientPropagation(basicNetwork, trainingSet);

		double minError = 0.09; 
		int epoch = 1;
		do {
			train.iteration();
			 System.out.println("Epoch: " + epoch + " Error:" + train.getError());
			epoch++;
		} while (train.getError() > minError);
		train.finishTraining();
		System.out.println("[INFO] training complete in " + epoch + " epochs with error=" + train.getError());

		// ----------------------------------------------------
		// Step 4: Test the NN
		// ----------------------------------------------------
		System.out.println("[INFO] Testing the network:");
		for (MLDataPair pair : trainingSet) {
			MLData output = basicNetwork.compute(pair.getInput());
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) + ", Y="
					+ (int) Math.round(output.getData(0)) + ", Yd=" + (int) pair.getIdeal().getData(0));
		}

		// ----------------------------------------------------
		// Step 5: Shutdown the NN
		// ----------------------------------------------------
		System.out.println("[INFO] Shutting down.");
		Encog.getInstance().shutdown();
	}

	public static void main(String[] args) {

		// Fuzzy logic file to determine how far the player is from another enemy
		fis2 = FIS.load("./resources/fuzzy/findEnemy.fcl", true);

		// Fuzzy logic file to determine how far the player is from the exit
		fis = FIS.load("./resources/fuzzy/findExit.fcl", true);

		// Calling neural network to execute
		new Runner().neuralNetwork();

		// Error handling - if fuzzy logic files are not available
		if (fis == null || fis2 == null) {
			System.out.println("Unable to load fuzzy logic file");
			System.exit(0);
		}

		/*
		 * Launch the JavaFX UI only when all the long-running AI configuration tasks
		 * have been completed. Use the arrow keys to move the player character and the
		 * 'Z' key to toggle the zoom in / out.
		 */
		Application.launch(GameWindow.class, args);
	}
}