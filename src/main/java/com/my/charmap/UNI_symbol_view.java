
package com.my.charmap;

import com.ibm.icu.lang.UCharacter;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import javax.swing.*;

public class UNI_symbol_view extends JComponent implements MouseListener  {
        String s;
        double x , y,  w , h ;
        boolean change = false;
        
        UNICODE  unicode;


      public  UNI_symbol_view ( UNICODE  uni,  String str  ) {
            unicode = uni;
            s = str;
            
            this.addMouseListener(this);
        }

        public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
                    Rectangle2D rect = null;
                      if( !change )
                         rect = new Rectangle2D.Double( 0 , 0,  30, 30 );
                      else   // if focuced
                         rect = new Rectangle2D.Double( 0 , 0,  45, 45 );

                     // if focuced
                     if( change )
                         g2.setColor(Color.YELLOW);
                     else
                         g2.setColor(Color.WHITE);
                    g2.fill(rect);
                    g2.setColor(Color.BLACK);
                    g2.draw(rect);

                    Font selectedFont = null;
                     // if focuced
                    if( change )
                     selectedFont = Font.decode((String) unicode.sel);
                        else
                     selectedFont = Font.decode((String) unicode.sel);
                    FontRenderContext frc = g2.getFontRenderContext();

                    CharacterIterator  ci =  new StringCharacterIterator(s);
                    GlyphVector gv = selectedFont.createGlyphVector(frc, ci);
                    // if focuced
                    if( change )
                       g2.drawGlyphVector(gv, 1, 27);
                        else
                       g2.drawGlyphVector(gv, 3, 22);

                    int ascii = 0;
                     if( change ) {
                          ascii = s.codePointAt(0);  // ASCII code
                          String hexa =  Integer.toHexString(ascii);
                          String octal =  Integer.toOctalString(ascii);
                          String binary =  Integer.toBinaryString(ascii);

                         unicode.symbolCodeField.setText("    "+ hexa);
                         unicode.javaCodeField.setText("   \\" + "u" + hexa);
                         unicode.symbolbinaryCodeField.setText("      "+ binary);
                         unicode.symboloctalCodeField.setText("    "+ octal);

                         String charName = UCharacter.getName(ascii);
                         unicode.descriptionName.setText("   "  + charName);

                         unicode.symboldecimalCodeField.setText("      "+ ascii );

//                         selectedFont.canDisplay(c);
                      }
//                     System.out.println(selectedFont.canDisplayUpTo(s));
//                      else {
//                         symbolCodeField.setText("");
//                         javaCodeField.setText("");
//                         symbolbinaryCodeField.setText("");
//                         symboloctalCodeField.setText("");
//                         descriptionName.setText("");
//                         symboldecimalCodeField.setText("" );
//                        }
        }

        @Override
        public void mouseClicked(MouseEvent e) {  }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) {  }
        @Override
        public void mouseEntered(MouseEvent e) {
                 this.setBackground(Color.red);
//                 System.out.println("inside");
                 change = true;
                 this.repaint();

        }
        @Override
        public void mouseExited(MouseEvent e) {
            change = false;
            this.repaint();
        }
    }