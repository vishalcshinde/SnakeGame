package com.vishal.game.snake;

import java.awt.event.KeyEvent;


public class LeftMovement extends DefaultMovement{
	
	@Override
	public int getNewX(Block block) {
		if(block.getX() < 0){
			return SnakeGame.WINDOW_WIDTH;
		}
		return block.getX() - Block.BLOCK_SIZE;
	}
	
	@Override
	public boolean isAllowed(KeyEvent keyEvent) {
		return in(keyEvent.getKeyCode(), KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	}
	
}
