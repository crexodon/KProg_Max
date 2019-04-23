import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


@SuppressWarnings("serial")
public class MainMenu extends JFrame{
	JFileChooser c = new JFileChooser( (new File("")));
	private static final long serialVersionUID = 1L;
	public String strPath = "";
	private ObjectInputStream oisData;
	MainMenu mainMenu;

	public MainMenu() {
		mainMenu = this;
		initUI();
		
	}
	
	public void initUI() {
		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Main Menu");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initPanel();
		
		this.setVisible(true);
	}
	
	public void initPanel() {
		JPanel mainPanel = new JPanel();
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.setBorder(new EmptyBorder(50,0,150,0));
		
		JButton startButton = new JButton("New Game");
		JButton loadButton = new JButton("Load Game");
		
		startButton.setName("start");
		loadButton.setName("load (doesn't work yet");
		
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		startButton.addActionListener(new OpenG());
		loadButton.addActionListener(new OpenL());
		
		innerPanel.add(startButton);
		innerPanel.add(Box.createVerticalStrut(10));
		innerPanel.add(loadButton);
		mainPanel.add(innerPanel);
		this.add(mainPanel);

		c.setDialogTitle("Select Directory");
		c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		c.setAcceptAllFileFilterUsed(false);
	}

	class OpenL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int intAction = c.showOpenDialog(mainMenu);
			if(intAction == JFileChooser.APPROVE_OPTION){
				File f = c.getSelectedFile();
				strPath = f.getAbsolutePath();

				try {
					FileInputStream fisData = new FileInputStream(strPath);
					oisData = new ObjectInputStream(fisData);
					MaxV maxv = (MaxV) oisData.readObject();
				}
				catch (Exception err){
					err.printStackTrace();
				}
			}
		}
	}


	public class OpenG implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new MaxV();
		}
	}

}
