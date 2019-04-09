import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ActionListener{
    private JButton[] buttons = new JButton[64];
    private String scoreW;
    private String scoreB;
    private String[] values = new String[64];

    View(){
        //create Frame and Panels
        JFrame mainFrame = new JFrame("MAX");
        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(8,8));
        JPanel sidePanel = new JPanel(new GridLayout(4, 0));

        //set some Frame stuff
        mainFrame.setSize(1000,600);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setResizable(false);


        //fill button array with values and add them to buttonPanel
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("13/37");
            buttons[i].addActionListener(this);
            buttons[i].setPreferredSize(new Dimension(50,50));
            buttonPanel.add(buttons[i]);
        }

        JLabel labelW = new JLabel(scoreW);
        sidePanel.add(labelW);
        JLabel labelB = new JLabel(scoreB);
        sidePanel.add(labelB);

        JButton resetButton = new JButton("RESET");
        sidePanel.add(resetButton);
        JButton startButton = new JButton("START");
        sidePanel.add(startButton);

        mainFrame.add(mainPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(sidePanel);

        mainFrame.setVisible(true);
        mainPanel.setVisible(true);
        buttonPanel.setVisible(true);
        sidePanel.setVisible(true);
    }

    //setter methods
    public void setScoreW(String scoreW){
        this.scoreW = scoreW;
    }
    public void setScoreB(String scoreB){
        this.scoreB = scoreB;
    }
    public void setValues(String[] values){
        this.values = values;
    }
    //getter methods
    public String getScoreW(){
        return scoreW;
    }
    public String getScoreB() {
        return scoreB;
    }
    public String[] getValues() {
        return values;
    }

    //refresh view for new data to draw
    public void refresh(){
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args){
        View view = new View();
    }
}

/**
 private void generateButtonsPanel(){
 double negligibleRatio = 0.1;
 String fraction;
 //make new panel
 JPanel buttonPanel = new JPanel();
 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 this.setSize(600,600);
 this.setTitle("MAX");return values;
 buttonPanel.setLayout(new GridLayout( 8, 8));

 //fill button array with buttons
 //convert values double to a fraction, e.g. 0.3333 to 1/3
 //add buttons to buttonPanel
 for(int i = 0; i < buttons.length; i++){
 for(int j = 1;;j++){
 double tem = values[i]/(1D/j);
 if(Math.abs(tem - Math.round(tem)) < negligibleRatio){
 fraction = Math.round(tem) + "/" + i;
 break;
 }
 }
 buttons[i] = new JButton(fraction);
 buttons[i].addActionListener(this);
 buttonPanel.add(buttons[i]);
 }

 this.getContentPane().add(buttonPanel);
 this.setVisible(true);
 }
 **/