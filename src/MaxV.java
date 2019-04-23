import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxV extends JFrame{

    public static void main(String[] args){
        MaxV maxv = new MaxV();
    }

    JButton[] buttons = new JButton[64];
    String[] fractions = new String[64];
    double[] values = new double[64];

    double scoreW;
    double scoreB;
    int positionW = 28;
    int positionB = 35;

    int count;


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
            buttonPanel.add(buttons[i]);
        }

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
        private boolean checkPosition(int newPosition, int currentPosition){
            boolean statePos = false;
            if(newPosition - currentPosition < 0){
                System.out.println("negative");
                if(Math.abs((newPosition - currentPosition)) == 8){
                    statePos = true;
                } else if(Math.abs((newPosition - currentPosition)) == 1){
                    statePos = true;
                } else{
                    statePos = false;
                }
            }
            if(newPosition - currentPosition > 0){
                System.out.println("positive");
                if((newPosition - currentPosition) == 8){
                    statePos = true;
                } else if((newPosition - currentPosition) == 1){
                    statePos = true;
                } else{
                    statePos = false;
                }
            }
            else{
                statePos = false;
            }
            return statePos;
        }

        public void actionPerformed(ActionEvent e){
            count++;
            System.out.println(button + ": " + value + " / " + count);

            if(count % 2== 0){
                if(checkPosition(button, positionW)) {
                    setPositionW(button);
                    addScoreW(value);
                } else{
                    count--;
                }
            }else {
                if(checkPosition(button, positionB)) {
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
    }
    public void addScoreB(double score){
        double newScore = this.scoreW + score;
        this.scoreB = newScore;
        System.out.println("PlayerW Score: " + this.scoreB);
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