import javax.swing.*;
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
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JButton startButton = new JButton("Neues Spiel starten");
		JButton loadButton = new JButton("Spiel Laden");
		
		startButton.setName("start");
		loadButton.setName("load");
		
		startButton.addActionListener(this);
		loadButton.addActionListener(this);
		
		mainPanel.add(startButton);
		mainPanel.add(loadButton);
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
