package com.ee.ac;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainTests {

	static Train train = new Train();

	public void setupForTestBlockExitToRed() {

	}

	@Test
	public void testBlockExitSignalTransitionToRed() {

		Train train = new Train();

		Block passedBlock = new Block(SignalState.GREEN);

		train.passBlock(passedBlock);

		assertEquals(((Block)train.getTraversedBlocks().get(0)).getSignalState(), SignalState.RED);
	}

	@Test
	public void testBlockExitPreviousSignalTransitionToYellow() {
		//setup for the test

		Train train = new Train();

		Block passedBlock = new Block(SignalState.GREEN);
		
		Block passedBlock2 = new Block(SignalState.GREEN);

		train.passBlock(passedBlock);

		train.passBlock(passedBlock2);

		assertEquals(((Block)train.getTraversedBlocks().get(0)).getSignalState(), SignalState.YELLOW);
	}

	@Test
	public void testBlockExitForRedYellowAndDoubleYellow() {
		Train train = new Train();

		Block passedBlock = new Block(SignalState.GREEN);
		
		Block passedBlock2 = new Block(SignalState.GREEN);
		
		Block passedBlock3 = new Block(SignalState.GREEN);

		train.passBlock(passedBlock);

		train.passBlock(passedBlock2);
		
		train.passBlock(passedBlock3);

		assertEquals(((Block)train.getTraversedBlocks().get(2)).getSignalState(), SignalState.RED);
		
		assertEquals(((Block)train.getTraversedBlocks().get(1)).getSignalState(), SignalState.YELLOW);
		
		assertEquals(((Block)train.getTraversedBlocks().get(0)).getSignalState(), SignalState.DOUBLEYELLOW);
	}
	
	@Test
	public void testBlockExitCurrentSignalTransitionToRedYellowAndDoubleYellowAndGreen() {
		Train train = new Train();

		Block passedBlock = new Block(SignalState.GREEN);
		
		Block passedBlock2 = new Block(SignalState.GREEN);
		
		Block passedBlock3 = new Block(SignalState.GREEN);
		
		Block passedBlock4 = new Block(SignalState.GREEN);
		
		train.passBlock(passedBlock);

		train.passBlock(passedBlock2);
		
		train.passBlock(passedBlock3);
		
		train.passBlock(passedBlock4);

		assertEquals(((Block)train.getTraversedBlocks().get(3)).getSignalState(), SignalState.RED);
		
		assertEquals(((Block)train.getTraversedBlocks().get(2)).getSignalState(), SignalState.YELLOW);
		
		assertEquals(((Block)train.getTraversedBlocks().get(1)).getSignalState(), SignalState.DOUBLEYELLOW);
		
		assertEquals(((Block)train.getTraversedBlocks().get(0)).getSignalState(), SignalState.GREEN);
		
	}
	
	
}
