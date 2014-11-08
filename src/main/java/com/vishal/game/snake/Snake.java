package com.vishal.game.snake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snake {
	private final List<Block> lstBlocks = new ArrayList<Block>();
	Map<Integer, Movement> movemap = new HashMap<Integer, Movement>();

	Movement movement;
	
	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Snake() {
		movemap.put(KeyEvent.VK_UP, new UpMovement());
		movemap.put(KeyEvent.VK_DOWN, new DownMovement());
		movemap.put(KeyEvent.VK_LEFT, new LeftMovement());
		movemap.put(KeyEvent.VK_RIGHT, new RightMovement());
		lstBlocks.add(new Block(100, 100));
		movement = movemap.get(KeyEvent.VK_DOWN);
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
		addBlock();
	}

	public List<Block> getLstBlocks() {
		return lstBlocks;
	}

	public void addBlock() {
		movement.addBlock(lstBlocks);
	}

	public void move() {
		movement.move(lstBlocks);
	}
	
	public void changeDirection(KeyEvent keyEvent) {
		if(movement.isAllowed(keyEvent)){
			setMovement(movemap.get(keyEvent.getKeyCode()));
		}
	}
}
