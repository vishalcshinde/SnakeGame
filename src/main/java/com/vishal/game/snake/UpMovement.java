package com.vishal.game.snake;

import java.awt.event.KeyEvent;


public class UpMovement extends DefaultMovement{
	
	@Override
	public int getNewY(Block block) {
		if(block.getY() < 0){
			return SnakeGame.WINDOW_HEIGHT;
		}
		return block.getY() - Block.BLOCK_SIZE;
	}
	
	public boolean isAllowed(KeyEvent keyEvent) {
		return in(keyEvent.getKeyCode(), KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	}
}
