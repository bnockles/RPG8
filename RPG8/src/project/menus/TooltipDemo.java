package project.menus;

import java.awt.*;
import java.awt.event.*;

import project.directors.Game;

public class TooltipDemo extends Game implements KeyListener{
  Label label;

  public TooltipDemo() {
    Frame frame = new Frame();
    TextField textField = new TextField();
    frame.add(textField, BorderLayout.NORTH);
    label = new Label();
    frame.add(label, BorderLayout.CENTER);
    frame.setSize(450, 400);
    frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
    textField.addKeyListener(new KeyAdapter() {
      /**
       * When you type the character "a" into the text field you will see
       * an information dialog box
       */
      public void keyTyped(KeyEvent ke) {
        char keyChar = ke.getKeyChar();
        if (keyChar == 'a') {
          System.out.println("You typed 'a'");
        }
      }

      
    });
  }

  public static void main(String[] args) {
    new TooltipDemo();
  }

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}