import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Max extends JFrame implements ActionListener{
    JButton[] buttons = new JButton[64];
    double[] values = new double[64];
    int count = 0;

    Max(){
        randomizeValue();
        generateButtonsPanel();
    }

    private void randomizeValue(){
        //randomize numbers and fill the value array with values
        for(int i = 0; i < values.length; i++){
            double rando = Math.random() * 10;
            double randoRound = (double) Math.round(rando * 100) / 100;
            values[i] = randoRound;
            System.out.println(i + ": " + values[i]);
        }
    }

    private void generateButtonsPanel(){
        double negligibleRatio = 0.1;
        String fraction;
        //make new panel
        JPanel buttonPanel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setTitle("MAX");
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

    @Override
    public void actionPerformed(ActionEvent e){
        count ++;
        String pressedButton = ((JButton) e.getSource()).getText();
        if(count % 2 == 0){
            ((JButton) e.getSource()).setBackground(Color.blue);
        } else{
            ((JButton) e.getSource()).setBackground(Color.red);
        }

        System.out.println(pressedButton);
    }

    public static void main(String[] args){ new Max(); }
}

/**TODO
 * Implement Labels for the values
 * Have a score system going
 * Implement the players (white/black)
 * Make multiple classes so parallel work can be done
 */
