
package com.my.charmap;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;
import java.awt.*;
import java.awt.event.*;
import java.lang.Character.Subset;
import java.lang.Character.UnicodeBlock;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class UNICODE  extends ApplicationFrame {

     JTabbedPane tab ;
     JPanel p0;
     JPanel p;
     JPanel p1;
     int viewportHeight = 100;

     JComboBox fonts;
     JComboBox unicode16;
     JComboBox unicode32;

     JLabel Fonts;
     JLabel Blocks;
     JLabel description;
     JLabel descriptionName;
     JLabel symbolCode;
     JLabel javaCode;
     JLabel system;
     JLabel binaryCodeField;
     JLabel octalCodeField;
     JLabel decimalCodeField;
     JComboBox systems;
     JTextField symbolCodeField;       // Hx16
     JTextField javaCodeField;         // Hx16
     JTextField symbolbinaryCodeField;
     JTextField symboloctalCodeField;
     JTextField symboldecimalCodeField;

     JPanel forFonts;
     JPanel forunicodeblocks;
     JPanel fordescription;
     JPanel forsymbolCode;
     JPanel forjavaCode;
     JPanel forsystem;
     JPanel forsymbolbinaryCodeField;
     JPanel forsymboloctalCodeField;
     JPanel forsymboldecimalCodeField;
     JViewport jv1;
     JScrollPane jsp ;

     String[] systemCodes = { "ASCII(dx10)" , "ASCII(hx16)", "Kyrillic(dx10)" , "Kyrillic(hx16)" };

     Object sel;

     UNICODE_BLOCKS unicode_blocks = new UNICODE_BLOCKS(UNICODE.this);
     UNICODE_MAP map = new UNICODE_MAP();
     public boolean display  = false;

    UNICODE() {
        super("-== Unicode 16 and Unicode 32 Glyphs ==-");
        setSize(800 , 600);
        setLayout(null);
        center();
        this.getContentPane().setBackground(Color.WHITE);
        int x = this.getX();
        int y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();
        Font times = new Font( "Times New Roman", Font.PLAIN | Font.BOLD , 18);
        Font times12 = new Font( "Times New Roman", Font.PLAIN | Font.BOLD , 14);
        Font consolas = new Font( "Consolas", Font.PLAIN | Font.BOLD , 16);
        
        tab = new JTabbedPane(SwingConstants.TOP);
        tab.setFocusable(false);
        tab.setFont(times);
        tab.setPreferredSize(new Dimension(width - 10,  height - 10));
        tab.setMinimumSize(new Dimension(width - 10,  height - 10));
        tab.setBounds(10 , 10 , width - 35,  height - 30 );
//        tab.add(p);
        tab.insertTab(" Inicode Blocks ", null, p0, null, 0);
        tab.insertTab(" Unicode Map ", null, map, null, 1);
        tab.insertTab(" UTF ", null, p1, null, 2);
        tab.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int index =  tab.getSelectedIndex();
                if( index == 1 ) {
                      forFonts.setVisible(false);
                      forunicodeblocks.setVisible(false);
                      fordescription.setVisible(false);
                      forsymbolCode.setVisible(false);
                      forjavaCode.setVisible(false);
                      forsystem.setVisible(false);
                      forsymbolbinaryCodeField.setVisible(false);
                      forsymboloctalCodeField.setVisible(false);
                      forsymboldecimalCodeField.setVisible(false);
//                      p.setVisible(false);
                      jsp.setVisible(false);
                }  else  {
                      forFonts.setVisible(true);
                      forunicodeblocks.setVisible(true);
                      fordescription.setVisible(true);
                      forsymbolCode.setVisible(true);
                      forjavaCode.setVisible(true);
                      forsystem.setVisible(true);
                      forsymbolbinaryCodeField.setVisible(true);
                      forsymboloctalCodeField.setVisible(true);
                      forsymboldecimalCodeField.setVisible(true);
//                      p.setVisible(true);
                      jsp.setVisible(true);
                      map.setVisible(false); 
                }
//                 System.out.println("Changed"  + currentTab );
            }
        });

        p0 = new JPanel();
        p = new JPanel();
        p1 = new JPanel();
        p0.setLayout(null);
        p.setLayout(null);
        p1.setLayout(null);
//        p.setBounds(0 , 5, 550, 450);
        p1.setPreferredSize(tab.getPreferredSize());
        p1.setMaximumSize(tab.getMaximumSize());
        p.setPreferredSize(new Dimension(100 ,100 ));
        p.setMaximumSize(new Dimension(100 ,100 ));

        jv1 = new JViewport();
        jv1.setView(p);
        jv1.setPreferredSize(new Dimension(100 , getViewPortHeight() ));
        jv1.setMaximumSize(new Dimension(100 , getViewPortHeight() ));
        jsp = new JScrollPane( jv1 ,  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ,
                                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED  );
        jsp.setBounds( 15 ,90, 550, 180);
        jsp.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

//       String decimal = "10";    // Decimal
//        String hexa    = "0XFF";  // Hexa
//        String octal   = "077";   // Octal
//
//        Integer number = Integer.decode(decimal);
//        System.out.println("String [" + decimal + "] = " + number);
//
//        number = Integer.decode(hexa);
//        System.out.println("String [" + hexa + "] = " + number);
//
//        number = Integer.decode(octal);
//        System.out.println("String [" + octal + "] = " + number);

        char cc = '\u0065';
//        Character.u
        UnicodeBlock block = UnicodeBlock.of(cc) ;    //UnicodeBlock.YI_SYLLABLES
         System.out.println(block + " " + cc + "  "  +  Character.getType(cc)  + "  " + UCharacter.getISOComment(cc) );

         Set<Character.UnicodeBlock> blocks = new HashSet<Character.UnicodeBlock>();
         

         Character.UnicodeBlock latin = Character.UnicodeBlock.BASIC_LATIN;
          final Set<Character> chars = new HashSet<Character>();
            for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
               if ( latin  == Character.UnicodeBlock.of(codePoint)) {
                   chars.add((char) codePoint);
        }
        }

           JComponent[] labels = new UNI_symbol_view[chars.size()]  ;
           Character[] s =   chars.toArray(new Character[chars.size()]);
           int x1 = 0; int y1 = 5;
          for( int k = 0; k < s.length ; k++ ) {
               x1 += 30;
             if( x1 >= 500)  {
                 x1 = 30;  y1 += 30;
             // set maximum Height of viewPort
             viewportHeight = (y1 + 60);
             setViewPortHeight( jv1 , viewportHeight);
             }
               String str = Character.toString(s[k]);

              labels[k] = new UNI_symbol_view( this, str );
              labels[k].setBounds(x1  , y1  , 31,  31);
              p.add(labels[k]);
          }
         
         Subset sub ; //sub.
         LocaleData  data =  LocaleData.getInstance();
//         System.out.println( "getExemplarSet :  " +  data.getExemplarSet(ULocale.FRENCH, 2) );
//         System.out.println( "getExemplarSet :  " +  data.getMeasurementSystem(ULocale.FRENCH));

         ULocale[] locales  = ULocale.getAvailableLocales();
         for( int k = 0; k < locales.length; k++ ){ 
//              System.out.println( " :  " +  locales[k] + "     "
//                                         +  locales[k].getDisplayCountry() + "     "
//                                         +  locales[k].getDisplayLanguage()+ "     "
//                                         );
        }
//          ULocale loc = ULocale.getDefault();
           int iii = 8592;
           String str0 = UCharacter.getName(iii) ;
//         System.out.println( " :  " + str0 );



         JComponent[] label = new UNI_symbol_view[77]  ;
         Vector<String> codeVector = new Vector();
         int i = 0;
         int xx = 0; int yy = 55;
         String str;
         for( char c = '\u2190'; c < '\u21dc';  c++) {
              xx += 30;
           if( xx >= 500)  {  xx = 30;  yy += 30;  }
              str = Character.toString(c);

              int ascii = str.codePointAt(0);  // ASCII code
//              String hexa = String.valueOf(ascii);
              String hexa =  Integer.toHexString(ascii);
              String octal =  Integer.toOctalString(ascii);
              String binary =  Integer.toBinaryString(ascii);


//              label[i] = new symbol(str );
//              label[i].setBounds(xx  , yy  , 31,  31);
//              p.add(label[i]);
         }

         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         String[] fontNames = ge.getAvailableFontFamilyNames();
         fonts  = new JComboBox(fontNames);
         fonts.setEditable(true);
         fonts.setBackground(Color.YELLOW);
         fonts.setForeground(Color.BLUE);
         Fonts  = new JLabel("Fonts: ");
         Fonts.setFont(times);
          fonts.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sel =  fonts.getSelectedItem();
              if(e.getItem() == sel)  {

                Font selectedFont =  Font.decode((String) sel);
//                selectedFont.deriveFont(24.0f);
                UNICODE.this.repaint();
                System.out.println(e.getItem());
              }
            }
        });

//         int cnt =   fonts.getItemCount();
//         for(int k = 0 ; k < fontNames.length ; k++) {
//         Font f =  Font.decode( fontNames[i]);
//       }
         
         unicode_blocks.checkbox.setEditable(true);
         unicode_blocks.checkbox.setBackground(Color.YELLOW);
         unicode_blocks.checkbox.setForeground(Color.BLUE);

         Blocks = new JLabel("Blocks:");
         description = new JLabel("Name:");
         descriptionName = new JLabel();
         symbolCode  = new JLabel("Symbol hexidecimal code:");
         javaCode  = new JLabel("Java hexidecimal code:");
         binaryCodeField = new JLabel("Binary code:");
         octalCodeField  = new JLabel("Symbol Octal  code:");
         decimalCodeField  = new JLabel("Symbol Decimal code:");
         system  = new JLabel("System:");
         symbolCodeField = new JTextField(8);
         javaCodeField   = new JTextField(8);
         symbolbinaryCodeField = new JTextField(8);
         symboloctalCodeField = new JTextField(8);
         symboldecimalCodeField = new JTextField(8);

         symbolCodeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
         javaCodeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
         symbolbinaryCodeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
         symboloctalCodeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
         symboldecimalCodeField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
         systems = new JComboBox(systemCodes);
         systems.setBackground(Color.YELLOW);
         systems.setForeground(Color.BLUE);
         systems.setEditable(true);

         // = set colors =
         descriptionName.setBackground(Color.WHITE);
         descriptionName.setForeground(Color.RED);

         // = font =
         Blocks.setFont(times);
         description.setFont(times);
         descriptionName.setFont(consolas);
         symbolCode.setFont(times);
         system.setFont(times);
         systems.setFont(times);
         javaCode.setFont(times);
         symbolCodeField.setFont(times);
         javaCodeField.setFont(times);
         symbolbinaryCodeField.setFont(times);
         symboloctalCodeField.setFont(times);
         binaryCodeField.setFont(times);
         octalCodeField.setFont(times);
         decimalCodeField.setFont(times);
         symboldecimalCodeField.setFont(times);

         forFonts  = new JPanel(null);
         forunicodeblocks  = new JPanel(null);
         fordescription = new JPanel(null);
         forsymbolCode = new JPanel(null);
         forjavaCode = new JPanel(null);
         forsystem = new JPanel(null);
         forsymbolbinaryCodeField = new JPanel(null);
         forsymboloctalCodeField = new JPanel(null);
         forsymboldecimalCodeField = new JPanel(null);
         forFonts.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forunicodeblocks.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         fordescription.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forsymbolCode.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forjavaCode.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forsystem.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forsymbolbinaryCodeField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forsymboloctalCodeField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
         forsymboldecimalCodeField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

         // set = position = panels
         forFonts.setBounds(15 , 45 , 233,  40 );
         forunicodeblocks.setBounds(255 , 45 , 308,  40 );
         fordescription.setBounds(15 , 273 , 540,  40 );
         forsymbolCode.setBounds(15 ,  316 , 298,  40 );
         forjavaCode.setBounds(  15 , 359 , 298,  40 );
         forsymbolbinaryCodeField.setBounds(  15 , 402 , 298,  40 );
         forsymboloctalCodeField.setBounds(  15 , 445 , 298,  40 );
         forsymboldecimalCodeField.setBounds(  15 , 488 , 298,  40 );
         forsystem.setBounds( 320 , 316 , 250, 40 );

         // content = forFonts = panel
         Fonts.setBounds( 10, 5, 65, 30);
         fonts.setBounds( 65, 7, 160, 26 );
         forFonts.add(Fonts);
         forFonts.add(fonts);

         // content = forunicodeblocks = panel
         Blocks.setBounds( 10, 5, 75, 30);
         unicode_blocks.checkbox.setBounds( 75, 7, 225, 26 );
         forunicodeblocks.add(Blocks);
         forunicodeblocks.add(unicode_blocks.checkbox);

         // content = fordescription = panel
         description.setBounds(10 , 5 , 50,  30 );
         descriptionName.setBounds(40 , 5 , 550,  30 );
         fordescription.add(description);
         fordescription.add(descriptionName);

         // content = forsymbolCode = panel
         symbolCode.setBounds(10 ,  5 , 220,  30 );
         symbolCodeField.setBounds(220 ,  7 , 70,  26 );
         forsymbolCode.add(symbolCode);
         forsymbolCode.add(symbolCodeField);

         // content = forjavaCode = panel
         javaCode.setBounds(10 ,  5 , 210,  30 );
         javaCodeField.setBounds(210 ,  7 , 80,  26 );
         forjavaCode.add(javaCode);
         forjavaCode.add(javaCodeField);

         // content = forsymbolbinaryCodeField = panel
         binaryCodeField.setBounds(10 , 5 , 120,  30 );
         symbolbinaryCodeField.setBounds(120 ,  7 , 170,  26 );
         forsymbolbinaryCodeField.add(binaryCodeField);
         forsymbolbinaryCodeField.add(symbolbinaryCodeField);

         // content = forsymboloctalCodeField = panel
         octalCodeField.setBounds(10 , 5 , 200,  30 );
         symboloctalCodeField.setBounds(210 ,  7 , 80,  26 );
         forsymboloctalCodeField.add(octalCodeField);
         forsymboloctalCodeField.add(symboloctalCodeField);

         // content = forsymboloctalCodeField = panel
         decimalCodeField.setBounds(10 , 5 , 200,  30 );
         symboldecimalCodeField.setBounds(210 ,  7 , 80,  26 );
         forsymboldecimalCodeField.add(decimalCodeField);
         forsymboldecimalCodeField.add(symboldecimalCodeField);

          // content = forsystem = panel
         system.setBounds(10 ,  5 , 70,  30 );
         systems.setBounds(75 ,  7 , 160,  26 );
         forsystem.add(system);
         forsystem.add(systems);

        this.add(forFonts);
//        unicode_blocks.checkbox.setBounds(275, 15, 125, 25 );
        this.add(forunicodeblocks);
        this.add(jsp);
        this.add(fordescription);
        this.add(forsymbolCode);
        this.add(forjavaCode);
        this.add(forsymbolbinaryCodeField);
        this.add(forsymboloctalCodeField);
        this.add(forsymboldecimalCodeField);
        this.add(forsystem);
        this.add(tab);

//         final String s = "ƒ";
//    for (final String csName : Charset.availableCharsets().keySet()) {
//    try {
//     final Charset cs = Charset.forName(csName);
//     final CharsetEncoder encode = cs.newEncoder();
//     if (encode.canEncode(s))
//          {
//      System.out.println( cs.name() + "   " + csName + ": " + Arrays.toString(s.getBytes(csName)) );
//          }
//        } catch (final UnsupportedOperationException uoe) {
//        } catch (final UnsupportedEncodingException e) {
//     }
//    }

    }

    public void setViewPortHeight( JViewport port, int height) {
        viewportHeight = height;
        jv1 = port;
        jv1.setPreferredSize(new Dimension(100 , viewportHeight ));
        jv1.setMaximumSize(new Dimension(100 , viewportHeight ));
    }

    public int getViewPortHeight() {
        return viewportHeight ;
    }



//     public class symbol extends JComponent implements MouseListener  {
//        String s;
////        JTextField symbolCodeFieldHEX;
//        double x , y,  w , h ;
//        boolean change = false;
//
//      public  symbol ( String str  ) {
//            s = str;
////            symbolCodeField = symbolcodefield;
////             if( change )
////                    symbolCodeFieldHEX.setText(s);
//            this.addMouseListener(this);
//        }
//
//        public void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    Graphics2D g2 = (Graphics2D) g;
//                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
//                    Rectangle2D rect = null;
//                      if( !change )
//                         rect = new Rectangle2D.Double( 0 , 0,  30, 30 );
//                      else   // if focuced
//                         rect = new Rectangle2D.Double( 0 , 0,  45, 45 );
//
//                     // if focuced
//                     if( change )
//                         g2.setColor(Color.YELLOW);
//                     else
//                         g2.setColor(Color.WHITE);
//                    g2.fill(rect);
//                    g2.setColor(Color.BLACK);
//                    g2.draw(rect);
//
//                    Font f = null;
//                     // if focuced
//                    if( change )
//                     f = new Font("Serif" , Font.PLAIN , 32);
//                        else
//                     f = new Font("Serif" , Font.PLAIN , 24);
//                    FontRenderContext frc = g2.getFontRenderContext();
//
//                    CharacterIterator  ci =  new StringCharacterIterator(s);
//                    GlyphVector gv = f.createGlyphVector(frc, ci);
//                    // if focuced
//                    if( change )
//                       g2.drawGlyphVector(gv, 1, 27);
//                        else
//                       g2.drawGlyphVector(gv, 3, 22);
//
//                    int ascii = 0;
//                     if( change ) {
//                          ascii = s.codePointAt(0);  // ASCII code
//                          String hexa =  Integer.toHexString(ascii);
//                          String octal =  Integer.toOctalString(ascii);
//                          String binary =  Integer.toBinaryString(ascii);
//
//                         symbolCodeField.setText("    "+ hexa);
//                         javaCodeField.setText("   \\" + "u" + hexa);
//                         symbolbinaryCodeField.setText("      "+ binary);
//                         symboloctalCodeField.setText("    "+ octal);
//
//                         String charName = UCharacter.getName(ascii);
//                         descriptionName.setText("   "  + charName);
//
//                         symboldecimalCodeField.setText("      "+ ascii );
//                      }
////                      else {
////                         symbolCodeField.setText("");
////                         javaCodeField.setText("");
////                         symbolbinaryCodeField.setText("");
////                         symboloctalCodeField.setText("");
////                         descriptionName.setText("");
////                         symboldecimalCodeField.setText("" );
////                        }
//        }
//
//        @Override
//        public void mouseClicked(MouseEvent e) {  }
//        @Override
//        public void mousePressed(MouseEvent e) { }
//        @Override
//        public void mouseReleased(MouseEvent e) {  }
//        @Override
//        public void mouseEntered(MouseEvent e) {
//                 this.setBackground(Color.red);
////                 System.out.println("inside");
//                 change = true;
//                 this.repaint();
//
//        }
//        @Override
//        public void mouseExited(MouseEvent e) {
//            change = false;
//            this.repaint();
//        }
//    }

      class scrollablePanel extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200 , 100);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {

            return 25;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 25;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
           return true;
        }

      }

    public static void main(String[] args) {
        UNICODE f = new UNICODE();
        f.setVisible(true); 
}
}
