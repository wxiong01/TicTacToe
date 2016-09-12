package com.beantech.tictactoe.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.beantech.tictactoe.TicTacToeBoardController;

/**
 * This class is used for GUI
 * @author wxiong
 *
 */
public class TicTacToe extends JFrame {
	
	private static final long serialVersionUID = -5575280909519279998L;

	public static void main(String[] args) {
		new TicTacToe();
	}

	private JButton btnA1, btnA2, btnA3, btnB1, btnB2, btnB3, btnC1, btnC2, btnC3;

	//game board 
	private TicTacToeBoardController boardController;

	public TicTacToe() {
		// Set up the grid
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tic-Tac-Toe");
		JPanel panel1 = new JPanel();
		panel1.setSize(300, 300);
		
		panel1.setLayout(new GridLayout(3, 3));
		btnA1 = createButton("A1");
		btnA2 = createButton("A2");
		btnA3 = createButton("A3");
		btnB1 = createButton("B1");
		btnB2 = createButton("B2");
		btnB3 = createButton("B3");
		btnC1 = createButton("C1");
		btnC2 = createButton("C2");
		btnC3 = createButton("C3");
		panel1.add(btnA1);
		panel1.add(btnA2);
		panel1.add(btnA3);
		panel1.add(btnB1);
		panel1.add(btnB2);
		panel1.add(btnB3);
		panel1.add(btnC1);
		panel1.add(btnC2);
		panel1.add(btnC3);
		this.add(panel1);
		this.setVisible(true);

		// Start the game
		boardController = new TicTacToeBoardController();

	}

	/**
	 * create button object
	 * @param square
	 * @return
	 */
	private JButton createButton(String square) {
		JButton btn = new JButton();
		btn.setPreferredSize(new Dimension(50, 50));
		Font f = new Font("Dialog", Font.PLAIN, 72);
		btn.setFont(f);
		btn.addActionListener(e -> btnClick(e, square));
		return btn;
	}

	/**
	 * @param e
	 * @param square
	 */
	private void btnClick(ActionEvent e, String square) {
		if (boardController.getSquare(square) != 0)
			return;

		JButton btn = (JButton) e.getSource();
		btn.setText("X");

		boardController.playAt(square, 1);

		if (boardController.isGameOver() == 3) {
			JOptionPane.showMessageDialog(null, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}

		if (boardController.isGameOver() == 1) {
			JOptionPane.showMessageDialog(null, "You beat me!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			boardController.recordLoosingCombination();
			resetGame();
			return;
		}

		String computerMove = boardController.getNextMove();
		boardController.playAt(computerMove, 2);

		switch (computerMove) {
		case "A1":
			btnA1.setText("O");
			break;
		case "A2":
			btnA2.setText("O");
			break;
		case "A3":
			btnA3.setText("O");
			break;
		case "B1":
			btnB1.setText("O");
			break;
		case "B2":
			btnB2.setText("O");
			break;
		case "B3":
			btnB3.setText("O");
			break;
		case "C1":
			btnC1.setText("O");
			break;
		case "C2":
			btnC2.setText("O");
			break;
		case "C3":
			btnC3.setText("O");
			break;
		}

		if (boardController.isGameOver() == 2) {
			JOptionPane.showMessageDialog(null, "I beat you!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}
	}

	private void resetGame() {
		boardController.reset();
		btnA1.setText("");
		btnA2.setText("");
		btnA3.setText("");
		btnB1.setText("");
		btnB2.setText("");
		btnB3.setText("");
		btnC1.setText("");
		btnC2.setText("");
		btnC3.setText("");
	}
}
