package com.vishal.game.snake;

import java.util.List;

public abstract class DefaultMovement implements Movement {

	public void move(List<Block> blocks) {
		Block b = blocks.get(0); 
		blocks.remove(0);
		addBlock(blocks, b);
	}
	
	public void addBlock(List<Block> lstBlocks) {
		addBlock(lstBlocks, new Block());
	}
	
	public void addBlock(List<Block> lstBlocks, Block block) {
		Block tail = lstBlocks.get(lstBlocks.size() - 1);
		block.setX(getNewX(tail));
		block.setY(getNewY(tail));
		lstBlocks.add(block);
	}
	
	public int getNewX(Block b){
		return b.getX();
	}
	
	public int getNewY(Block b){
		return b.getY();
	}
	
	public boolean in(int keyEvent, int ... keyEvents){
		for(int k : keyEvents){
			if(k == keyEvent){
				return true;
			}
		}		
		return false;
	}
}
