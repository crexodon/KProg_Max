import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame{

}

/**
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
 **/