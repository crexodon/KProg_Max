import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxV extends JFrame{

    public static void main(String[] args){
        MaxV maxv = new MaxV();
    }

    private JButton[] buttons = new JButton[64];
    private String[] fractions = new String[64];
    private double[] values = new double[64];

    private double scoreW = 0;
    private double scoreB = 0;
    private int positionW = 28;
    private int positionB = 35;

    private int count;
    private double finish = 60;
    private boolean finished = false;


    MaxV(){
        //set JFrame
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridLayout(1,1));

        //make buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8,8));

        //create random values
        randomizeValue();

        //create buttons
        for(int i = 0; i < 64; i++){
            buttons[i] = new JButton(fractions[i]);
            buttons[i].addActionListener(new ButtonClicked(values[i], i));
            buttons[i].setBackground(Color.GRAY);
            buttonPanel.add(buttons[i]);
        }

        //initial placement of W and B
        buttons[positionW].setText("W");
        buttons[this.positionW].setBackground(Color.WHITE);
        buttons[this.positionW].setForeground(Color.BLACK);
        buttons[positionB].setText("B");
        buttons[this.positionB].setBackground(Color.BLACK);
        buttons[this.positionB].setForeground(Color.WHITE);

        //add panel to frame
        this.add(buttonPanel);
        this.setVisible(true);
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

        //checks if the player wants to move over edge based on how the array is displayed
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

            //player w
            if(count % 2== 0){
                if(checkPosition(button, positionW) && checkEdge(button, positionW) && checkMarked() && !finished) {
                    setPositionW(button);
                    addScoreW(value);
                } else{ //if player couldn't move don't advance
                    count--;
                }
            //player b
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
    //sets new position, replaces old text with fraction and updates color
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
    //adds score to current score and checks if a player has won
    public void addScoreW(double score){
        double newScore = this.scoreW + score;
        this.scoreW = newScore;
        System.out.println("PlayerW Score: " + this.scoreW);

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