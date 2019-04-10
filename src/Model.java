import javax.swing.*;

public class Model{
    double[] values = new double[64];
    String[] fractions = new String[64];
    int positionW = 28;
    int positionWRight;
    int positionWUp;
    int positionWLeft;
    int positionWDown;

    int positionB = 35;
    int positionBLeft;
    int positionBUp;
    int positionBRight;
    int positionBDown;
    int count;

    Model(){
        randomizeValue();
        View view = new View(fractions, 0, 0, 28, 35);
        view.setVisible(true);
    }

    public void setButtonEvent(int buttonNumber){

        count++; //count the turn of the players
        if(count % 2 == 0){ //check which player is going and calculate their next possible step
            positionW = buttonNumber;
            positionWLeft = buttonNumber -1;
            positionWUp = buttonNumber -8;
            positionWRight = buttonNumber + 1;
            positionWDown = buttonNumber + 8;
        } else{
            positionB = buttonNumber;
            positionBLeft = buttonNumber -1;
            positionBUp = buttonNumber -8;
            positionBRight = buttonNumber + 1;
            positionBDown = buttonNumber + 8;
        }

        //check which button has been pressed and then updatePositions()
    }

    public void updatePositions(){
        //send positions to View
    }

    private void randomizeValue() {
        double negligibleRatio = 0.1;
        //randomize numbers and fill the value array with values
        for (int i = 0; i < values.length; i++) {
            double rando = Math.random() * 10;
            double randoRound = (double) Math.round(rando * 100) / 100;
            values[i] = randoRound;
            System.out.println(i + ": " + values[i]);
            //generate fractions out of the double values
            for (int j = 1; ; j++) {
                double tem = values[i] / (1D / j);
                if (Math.abs(tem - Math.round(tem)) < negligibleRatio) {
                    fractions[i] = Math.round(tem) + "/" + i;
                    break;
                }
            }
        }
    }


}
