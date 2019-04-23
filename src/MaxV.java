import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MaxV extends JFrame implements Serializable{

    public static void main(String[] args){
    	MainMenu menu = new MainMenu();
    }
    
    MaxV maxV;
    
    JButton[] buttons = new JButton[64];
    String[] fractions = new String[64];
    double[] values = new double[64];
    
    double scoreW = 0;
    JLabel scoreWLabel = new JLabel();
    double scoreB = 0;
    JLabel scoreBLabel = new JLabel();
    int positionW = 28;
    int positionB = 35;

    int count;
    double finish = 60;
    boolean finished = false;


    MaxV(){
    	
    	maxV = this;
    	
        //set JFrame
        maxV.setSize(600, 600);
        maxV.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        maxV.setLocationRelativeTo(null);
        maxV.setResizable(false);
        maxV.setLayout(new BorderLayout());
        

        //make left Panel side for game buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(600,600);
        buttonPanel.setLayout(new GridLayout(8,8));
        
        //make right panel Side for score and SaveGame
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1,3));
        
        //make Panel with scores
        JPanel scoreWPanel = new JPanel();
        JPanel scoreBPanel = new JPanel();
        
        //Adjust Score panels
        scoreWPanel.setBorder(new TitledBorder("Score Player White"));
        scoreWLabel = new JLabel(Double.toString(scoreW));
        scoreWPanel.add(scoreWLabel);
        scoreBPanel.setBorder(new TitledBorder("Score Player Black"));
        scoreBLabel = new JLabel(Double.toString((scoreB)));
        scoreBPanel.add(scoreBLabel);
        
        //make Panel with saveGame button
        JPanel saveGamePanel = new JPanel();

        //Make saveGame button and add to Panel
        JButton saveGameButton = new JButton("Save Game (Sort-of works");
        saveGameButton.addActionListener(new SaveGame());
        saveGamePanel.setBorder(new EmptyBorder(10,10,10,10));
        saveGamePanel.add(saveGameButton);
        
        
        //create random values
        randomizeValue();

        //create buttons
        for(int i = 0; i < 64; i++){
            buttons[i] = new JButton(fractions[i]);
            buttons[i].addActionListener(new ButtonClicked(values[i], i));
            buttons[i].setBackground(Color.GRAY);
            buttonPanel.add(buttons[i]);
        }

        buttons[positionW].setText("W");
        buttons[maxV.positionW].setBackground(Color.WHITE);
        buttons[maxV.positionW].setForeground(Color.BLACK);
        buttons[positionB].setText("B");
        buttons[maxV.positionB].setBackground(Color.BLACK);
        buttons[maxV.positionB].setForeground(Color.WHITE);

        //add score and button Panels to textPanel
        textPanel.add(scoreWPanel);
        textPanel.add(scoreBPanel);
        textPanel.add(saveGamePanel);
        
        //add panel to frame
        maxV.add(buttonPanel, BorderLayout.CENTER);
        maxV.add(textPanel, BorderLayout.PAGE_START);
        maxV.setVisible(true);
    }
    private class SaveGame implements  ActionListener{
        private static final long serialVersionUID = 1L;
        public void actionPerformed(ActionEvent e){
            try {
                FileOutputStream fs = new FileOutputStream(this.getClass().getName() + ".ser");
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(maxV);
                System.out.println("Saved");
                os.close();
            } catch (IOException erro){
                System.err.println((erro));
            }
        }


    }

    //anonymous class for a button actionevent
    private class ButtonClicked implements ActionListener{
         double value;
         int button;

        ButtonClicked(double value, int button){
            this.value = value;
            this.button = button;
        }
        //checks the position and returns true if the new position is allowed
        private boolean checkPosition(int newPosition, int currentPosition) {
            //if player is either moving right or up
            if (newPosition - currentPosition < 0) {
                if (Math.abs((newPosition - currentPosition)) == 8) {
                    return true;
                } else if (Math.abs((newPosition - currentPosition)) == 1) {
                    return true;
                }
            }
            //if player is moving right or down
            if (newPosition - currentPosition > 0) {
                if ((newPosition - currentPosition) == 8) {
                    return true;
                } else if ((newPosition - currentPosition) == 1) {
                    return true;
                }
            }
            return false;
        }

        //checks if the player wants to move over
        private boolean checkEdge(int newPosition, int currentPosition){
            if(newPosition % 8 == 7 && currentPosition - newPosition == 1){
                return false;
            } else if(currentPosition % 8 == 7 && newPosition - currentPosition == 1){
                return false;
            }
            return true;
        }

        //checks if player wants to move on a marked field
        private boolean checkMarked(){
            if(buttons[button].getBackground() != Color.GRAY){
                return false;
            }
            return true;
        }

        public void actionPerformed(ActionEvent e){
            count++;
            System.out.println(button + ": " + value + " / " + count);

            if(count % 2== 0){
                if(checkPosition(button, positionW) && checkEdge(button, positionW) && checkMarked() && !finished) {
                    setPositionW(button);
                    addScoreW(value);
                } else{
                    count--;
                }
            }else {
                if(checkPosition(button, positionB) && checkEdge(button, positionB) && checkMarked() && !finished) {
                    setPositionB(button);
                    addScoreB(value);
                } else{
                    count --;
                }
            }

        }
    }

    public void setPositionW(int positionW){
        buttons[this.positionW].setText(fractions[this.positionW]);
        this.positionW = positionW;
        buttons[positionW].setText("W");
        buttons[this.positionW].setBackground(Color.WHITE);
        buttons[this.positionW].setForeground(Color.BLACK);
    }
    public void setPositionB(int positionB){
        buttons[this.positionB].setText(fractions[this.positionB]);
        this.positionB = positionB;
        buttons[positionB].setText("B");
        buttons[this.positionB].setBackground(Color.BLACK);
        buttons[this.positionB].setForeground(Color.WHITE);
    }
    public void addScoreW(double score){
        double newScore = this.scoreW + score;
        this.scoreW = newScore;
        System.out.println("PlayerW Score: " + this.scoreW);
        scoreWLabel.setText(Double.toString(this.scoreW));

        //check if won
        if(this.scoreW >= finish){
            for(int i = 0; i < 64; i++){
                buttons[i].setBackground(Color.BLACK);
                buttons[i].setForeground(Color.WHITE);
            }
            finished = true;
        }
    }
    public void addScoreB(double score){
        double newScore = this.scoreW + score;
        this.scoreB = newScore;
        System.out.println("PlayerW Score: " + this.scoreB);
        scoreBLabel.setText(Double.toString(this.scoreB));

        //check if won
        if(this.scoreB >= finish){
            for(int i = 0; i < 64; i++){
                buttons[i].setBackground(Color.BLACK);
                buttons[i].setForeground(Color.WHITE);
            }
            finished = true;
        }
    }

    public void randomizeValue(){
        double negligibleRatio = 0.1;
        //randomize numbers and fill the value array said values
        for(int i = 0; i < values.length; i++){
            double rando = Math.random() * 10;
            double randoRound = (double) Math.round(rando * 100) / 100;
            values[i] = randoRound;
            System.out.println(i + ": " + randoRound);
            //genereate fractions out of values
            for(int j = 1;; j++){
                double tem = values[i] / (1D / j);
                if (Math.abs(tem - Math.round(tem)) < negligibleRatio){
                    fractions[i] = Math.round(tem) + "/" + i;
                    break;
                }
            }
        }
    }



}