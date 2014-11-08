package com.vishal.game.snake;

import java.awt.event.KeyEvent;
import java.util.List;

public interface Movement {
	public void move(List<Block> blocks);

	public void addBlock(List<Block> lstBlocks);
	
	public boolean isAllowed(KeyEvent keyEvent);
}
