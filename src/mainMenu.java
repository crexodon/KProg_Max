import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class mainMenu extends JFrame implements ActionListener {
	
	public mainMenu() {
		initUI();
		
	}
	
	public void initUI() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Hauptmenü");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initPanel();
		
		this.setVisible(true);
	}
	
	public void initPanel() {
		JPanel mainPanel = new JPanel();
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.setBorder(new EmptyBorder(200,0,200,0));
		
		JButton startButton = new JButton("Neues Spiel starten");
		JButton loadButton = new JButton("Spiel Laden");
		
		startButton.setName("start");
		loadButton.setName("load");
		
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		startButton.addActionListener(this);
		loadButton.addActionListener(this);
		
		innerPanel.add(startButton);
		innerPanel.add(Box.createVerticalStrut(10));
		innerPanel.add(loadButton);
		mainPanel.add(innerPanel);
		this.add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button.getName().equals("start")) {
			new MaxV();
			this.dispose();
		} else if(button.getName().equals("load")) {
			//TODO Lade das bereits gespeicherte spiel
			
			
			this.dispose();//Schließt das Fenster bei button benutzung
		}
		
	}
}
