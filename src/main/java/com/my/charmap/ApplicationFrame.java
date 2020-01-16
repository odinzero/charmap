
package com.my.charmap;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public  class ApplicationFrame extends JFrame {

    public ApplicationFrame() {
        this("ApplicationFrame v1.0");
 
    }

    public ApplicationFrame(String title) {
        super(title);
        setSize(500, 400);
        createUI();
    }

    protected void createUI() {
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }
    
     private static void center(JFrame outside, JFrame inside) { // JWindow
        // get the size of the screen, on systems with multiple displays,
        // the primary display is used
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension outsideDim = outside.getSize();
        int x = (dim.width - inside.getSize().width) / 2;
        int y = (dim.height - inside.getSize().height) / 2;

        inside.setLocation(x, y);
    }
   
     public static void main(String[] args) {
       // ApplicationFrame f = new ApplicationFrame();
        
    }
     
}
