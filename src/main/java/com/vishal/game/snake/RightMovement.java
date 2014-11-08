package com.vishal.game.snake;

import java.awt.event.KeyEvent;


public class RightMovement extends DefaultMovement{

	
	@Override
	public int getNewX(Block block) {
		if(block.getX() > SnakeGame.WINDOW_WIDTH){
			return 0;
		}
		return block.getX() + Block.BLOCK_SIZE;
	}
	
	public boolean isAllowed(KeyEvent keyEvent) {
		return in(keyEvent.getKeyCode(), KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	}
	
}
