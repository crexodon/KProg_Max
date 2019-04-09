import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class layout extends JFrame implements ActionListener{
	
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private ArrayList<String> textList = new ArrayList<String>();
	private String playerOne;
	private String playerTwo;
	
	
	public static void main(String[]args) {
		layout view = new layout();
		view.buildup();
		view.setVisible(true);
	}
	
	private layout() {
		this.setSize(1000,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);;
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));
		
		createAndAssignPanels();
		
		
	}
	
	private void createAndAssignPanels() {
		
		//Create Outer Panels
		JPanel framePanelLeft = new JPanel();
		JPanel framePanelRight = new JPanel();
		
		framePanelLeft.setLayout(new GridLayout(6,7));
		framePanelRight.setLayout(new GridLayout(1,2));
		
		for(int i = 0; i < 42; i++) {
			framePanelLeft.add(new JButton());
		}
		
		//Create Inner Panels
		JPanel innerPanelLeft = new JPanel();
		JPanel innerPanelRight = new JPanel();
		
		innerPanelLeft.setLayout(new GridLayout(6,1));
		
		for(int i = 0; i < 24; i++) {
			innerPanelLeft.add(new JButton());
		}
		
		innerPanelRight.setLayout(new GridLayout(4,1));
		
		JPanel panelScoreP1 = new JPanel();
		JPanel panelScoreP2 = new JPanel();
		JPanel resetPanel = new JPanel();
		JPanel startPanel = new JPanel();
		
		panelScoreP1.setLayout(new GridLayout(2,1));
		
		JLabel scoreP1 = new JLabel("Score Player 1");
		scoreP1.setHorizontalAlignment(JLabel.CENTER);
		panelScoreP1.add(scoreP1);
		
		JLabel scoreNumberP1 = new JLabel("25"); //Enter Variable of Score "Player 1" here
		scoreNumberP1.setHorizontalAlignment(JLabel.CENTER);
		panelScoreP1.add(scoreNumberP1);
		
		panelScoreP2.setLayout(new GridLayout(2,1));
		
		JLabel scoreP2 = new JLabel("Score Player2");
		scoreP2.setHorizontalAlignment(JLabel.CENTER);
		panelScoreP2.add(scoreP2);
		
		JLabel scoreNumberP2 = new JLabel("13"); //Enter Variable of Score "Player 2" here
		scoreNumberP2.setHorizontalAlignment(JLabel.CENTER);
		panelScoreP2.add(scoreNumberP2);
		
		resetPanel.setLayout(new GridLayout(4,1));
		resetPanel.add(new JButton("Reset Game"));
		
		JButton startButton = new JButton("Start Game");
		
		startPanel.setLayout(new GridBagLayout());
		startPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		startPanel.add(startButton);
		
		innerPanelRight.add(panelScoreP1);
		innerPanelRight.add(panelScoreP2);
		innerPanelRight.add(resetPanel);
		innerPanelRight.add(startPanel);
		
		//Add Inner Panels
		framePanelRight.add(innerPanelLeft);
		framePanelRight.add(innerPanelRight);
		
		//Add Outer Panels
		this.add(framePanelLeft);
		this.add(framePanelRight);
		
	}

	private void buildup() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
