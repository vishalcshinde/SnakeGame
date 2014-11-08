package com.vishal.game.snake;

import java.awt.event.KeyEvent;


public class DownMovement extends DefaultMovement{
	
	@Override
	public int getNewY(Block b) {
		if(b.getY() > SnakeGame.WINDOW_HEIGHT){
			return 0;
		}
		return  b.getY() + Block.BLOCK_SIZE;
	}

	@Override
	public boolean isAllowed(KeyEvent keyEvent) {
		return in(keyEvent.getKeyCode(), KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	}
}
