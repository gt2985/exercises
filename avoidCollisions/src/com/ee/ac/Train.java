package com.ee.ac;

import java.util.ArrayList;
import java.util.List;

public class Train {


	private List<Block> traversedBlocks = new ArrayList<Block>(); 

	public List<Block> getTraversedBlocks() {
		return traversedBlocks;
	}

	public void setTraversedBlocks(List<Block> traversedBlocks) {
		this.traversedBlocks = traversedBlocks;
	}

	public Train(List<Block> traversedBlocks) {
		this.traversedBlocks = traversedBlocks;
	}

	public Train() {

	}

	public void passBlock(Block nextBlock) {

		traversedBlocks.add(nextBlock);

		for (Block block: traversedBlocks) {
			block.changeState();
		}

	}


}
