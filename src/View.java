import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame implements ActionListener{
    private JButton[] buttons = new JButton[64];
    private String[] fractions = new String[64];
    private int scoreW;
    private int scoreB;
    private int positionW;
    private int positionB;

    View(String[] fractions, int scoreW, int scoreB, int positionW, int positionB){
        this.fractions = fractions;
        this.scoreB = scoreB;
        this.scoreW = scoreW;
        this.positionB = positionB;
        this.positionW = positionW;

        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(0,2));

        createPanelsButtons();

        buttons[positionW].setText("W");
        buttons[positionB].setText("B");
    }

    private void createPanelsButtons(){
        //create outer panels
        JPanel framePanelLeft = new JPanel();
        JPanel framePanelMid = new JPanel();
        JPanel framePanelRight = new JPanel();

        framePanelLeft.setLayout(new GridLayout(8,8));
        framePanelMid.setLayout(new GridLayout(8,4));

        //create button grid
        for(int i = 0; i < 64; i++){
            buttons[i] = new JButton(Integer.toString(i));
            buttons[i].putClientProperty("button", i);
            buttons[i].addActionListener(this);
            framePanelLeft.add(buttons[i]);
        }
        /**
        for(int i = 32; i < 64; i++){
            buttons[i] = new JButton(Integer.toString(i));
            buttons[i].putClientProperty("button", i);
            buttons[i].addActionListener(this);
            framePanelMid.add(buttons[i]);
        } **/

        framePanelRight.setLayout(new GridLayout(4,1));

        //create Labels
        JLabel labelNameW = new JLabel("Player W");
        JLabel labelNameB = new JLabel("Player B");
        JLabel labelScoreW = new JLabel(Integer.toString(scoreW));
        JLabel labelScoreB = new JLabel(Integer.toString(scoreB));

        //create start/reset buttons
        JButton resetButton = new JButton("Reset Game");
        JButton startButton = new JButton("New game");

        //do some alignment
        labelNameW.setHorizontalAlignment(JLabel.CENTER);
        labelNameB.setHorizontalAlignment(JLabel.CENTER);
        labelScoreW.setHorizontalAlignment(JLabel.CENTER);
        labelScoreB.setHorizontalAlignment(JLabel.CENTER);

        //create inner panels
        JPanel panelPlayerOne = new JPanel();
        JPanel panelPlayerTwo = new JPanel();
        JPanel panelResetButton = new JPanel();
        JPanel panelStartButton = new JPanel();

        panelPlayerOne.setLayout(new GridLayout(2,1));
        panelPlayerTwo.setLayout(new GridLayout(2,1));
        panelResetButton.setLayout(new GridLayout(4,1));
        panelStartButton.setLayout(new GridBagLayout());
        panelStartButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //add labels and buttons to inner panels
        panelPlayerOne.add(labelNameW);
        panelPlayerTwo.add(labelNameB);
        panelPlayerOne.add(labelScoreW);
        panelPlayerTwo.add(labelScoreB);

        panelResetButton.add(resetButton);
        panelStartButton.add(startButton);

        //add inner panels to outer panel
        framePanelRight.add(panelPlayerOne);
        framePanelRight.add(panelPlayerTwo);
        framePanelRight.add(panelResetButton);
        framePanelRight.add(panelStartButton);

        //add them to this
        this.add(framePanelLeft);
        this.add(framePanelMid);
        this.add(framePanelRight);
    }

    public void actionPerformed(ActionEvent e) {
        //send current button over to model
    }
    //setter and getter methods
    public void setScoreW ( int scoreW){
        this.scoreW = scoreW;
    }
    public void setScoreB ( int scoreB){
        this.scoreB = scoreB;
    }
    public void setPositionW(int positionW){
        this.positionW = positionW;
        buttons[positionW].setText("W");
    }
    public void setPositionB(int positionB){
        this.positionB = positionB;
        buttons[positionB].setText("B");
    }

}