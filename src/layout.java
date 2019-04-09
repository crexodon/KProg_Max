import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class layout extends JFrame implements ActionListener{
	
	public static void main(String[]args) {
		layout view = new layout();
		view.setVisible(true);
	}
	
	private layout() {
		this.setSize(900,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);;
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,3));
		
		createAndAssignPanels();
	}
	
	private void createAndAssignPanels() {
		
		//Create Outer Panels
		JPanel framePanelLeft = new JPanel();
		JPanel framePanelMid = new JPanel();
		JPanel framePanelRight = new JPanel();
		
		framePanelLeft.setLayout(new GridLayout(8,4));
		framePanelMid.setLayout(new GridLayout(8,4));
		
		for(int i = 0; i < 32; i++) {
			framePanelLeft.add(new JButton());
			framePanelMid.add(new JButton());
		}
		
		framePanelRight.setLayout(new GridLayout(4,1));
		
		JLabel scoreP1 = new JLabel("Player 1");
		JLabel scoreP2 = new JLabel("Player 2");
		
		JLabel scoreNumberP1 = new JLabel("25"); //Insert Variable of Score "Player 1" here
		JLabel scoreNumberP2 = new JLabel("13"); //Insert Variable of Score "Player 2" here
		
		JButton resetButton = new JButton("Reset Game");
		JButton startButton = new JButton("Start Game");
		
		scoreP1.setHorizontalAlignment(JLabel.CENTER);
		scoreP2.setHorizontalAlignment(JLabel.CENTER);
		scoreNumberP1.setHorizontalAlignment(JLabel.CENTER);
		scoreNumberP2.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel panelPlayerOne = new JPanel();
		JPanel panelPlayerTwo = new JPanel();
		JPanel panelResetButton = new JPanel();
		JPanel panelStartButton = new JPanel();
		
		panelPlayerOne.setLayout(new GridLayout(2,1));
		panelPlayerTwo.setLayout(new GridLayout(2,1));
		panelResetButton.setLayout(new GridLayout(4,1));
		panelStartButton.setLayout(new GridBagLayout());
		panelStartButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panelPlayerOne.add(scoreP1);
		panelPlayerOne.add(scoreNumberP1);
		
		panelPlayerTwo.add(scoreP2);
		panelPlayerTwo.add(scoreNumberP2);
		
		panelResetButton.add(resetButton);
		panelStartButton.add(startButton);
		
		framePanelRight.add(panelPlayerOne);
		framePanelRight.add(panelPlayerTwo);
		framePanelRight.add(panelResetButton);
		framePanelRight.add(panelStartButton);
		
		this.add(framePanelLeft);
		this.add(framePanelMid);
		this.add(framePanelRight);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
