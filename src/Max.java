import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Max extends JFrame implements ActionListener{
    JButton[] buttons = new JButton[64];
    double[] values = new double[64];

    double score = 0;

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
        //make new panel
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setTitle("MAX");
        panel.setLayout(new GridLayout( 8, 8));

        //fill button array with buttons and add them to panel
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(Double.toString(values[i]));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //buttons.setBackground(Color.green);
    }

    public static void main(String[] args){ new Max(); }
}
