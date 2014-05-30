/**
 * 
 */
package com.ee.ac;

/**
 * @author GA004TH
 *
 */
public class Block {
	
	private SignalState signalState;

	public SignalState getSignalState() {
		return signalState;
	}

	public void setSignalState(SignalState signalState) {
		this.signalState = signalState;
	}

	public Block(SignalState signalState) {
		setSignalState(signalState);
	}

	public void changeState() {
		this.signalState = this.signalState.next();
	}
}
