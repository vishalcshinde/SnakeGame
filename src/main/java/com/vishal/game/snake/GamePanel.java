package com.vishal.game.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2464895775556708950L;
	Snake snake = new Snake();

	public GamePanel() {

		Timer t = new Timer(33, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.move();
				repaint();
			}
		});
		t.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (Block block : snake.getLstBlocks()) {
			g.setColor(Color.RED);
			g.fillRect(block.getX(), block.getY(), Block.BLOCK_SIZE,
					Block.BLOCK_SIZE);
			g.setColor(Color.BLACK);
			g.drawRect(block.getX(), block.getY(), Block.BLOCK_SIZE,
					Block.BLOCK_SIZE);
		}
	}

	public void changeDirection(KeyEvent keyEvent) {
		snake.changeDirection(keyEvent);
	}

}
