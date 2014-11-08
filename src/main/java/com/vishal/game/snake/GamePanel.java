package com.vishal.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2464895775556708950L;
	Snake snake = new Snake();
	List<Block> cherries = new ArrayList<Block>();

	public GamePanel() {
	    Random r = new Random();
	    cherries.add(new Block(100, 100));
		Timer t = new Timer(33, new ActionListener() {
			int i = 0;
			Random r = new Random();
			public void actionPerformed(ActionEvent e) {
			    checkInteraction();
				snake.move();
				repaint();
				i++;
				if(i > 100){
					i = 0;
					cherries.add(new Block(r.nextInt(getWidth()), r.nextInt(getHeight())));
				}
			}
		});
		t.start();
	}

	protected void checkInteraction() {
        Block head = snake.getLstBlocks().get(snake.getLstBlocks().size() - 1);
        List<Block> cherriesToRemove = new ArrayList<Block>();
        for(Block b : cherries){
            if(Math.abs(head.getX() - b.getX()) < Block.BLOCK_SIZE && Math.abs(head.getY() - b.getY()) < Block.BLOCK_SIZE){
                cherriesToRemove.add(b);
                snake.addBlock();
            }
        }
        cherries.removeAll(cherriesToRemove);
    }

    @Override
	public void paint(Graphics g) {
		super.paint(g);

		for (Block block : snake.getLstBlocks()) {
			g.setColor(Color.BLUE);
			g.fillRect(block.getX(), block.getY(), Block.BLOCK_SIZE,
					Block.BLOCK_SIZE);
			g.setColor(Color.BLACK);
			g.drawRect(block.getX(), block.getY(), Block.BLOCK_SIZE,
					Block.BLOCK_SIZE);
		}
		for (Block block : cherries) {
			g.setColor(Color.RED);
			g.fillRect(block.getX(), block.getY(), Block.BLOCK_SIZE,
					Block.BLOCK_SIZE);	
		}
	}

	public void changeDirection(KeyEvent keyEvent) {
		snake.changeDirection(keyEvent);
	}

}
