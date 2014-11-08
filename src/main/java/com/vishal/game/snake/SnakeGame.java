package com.vishal.game.snake;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class SnakeGame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3323725539688425939L;
	public static int WINDOW_WIDTH = 0;
	public static int WINDOW_HEIGHT = 0;
	
	public SnakeGame() {
		final GamePanel panel = new GamePanel();
		setContentPane(panel);
		setVisible(true);
		pack();
		WINDOW_WIDTH = 500;
		WINDOW_HEIGHT= 500;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);;
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				panel.changeDirection(e);
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				WINDOW_WIDTH = SnakeGame.this.getWidth();
				WINDOW_HEIGHT = SnakeGame.this.getHeight();
			}
		});
	}
	
	public static void main(String[] args) {
		new SnakeGame();
	}
	
	
}
