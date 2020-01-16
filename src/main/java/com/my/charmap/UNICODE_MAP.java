
package com.my.charmap;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import javax.swing.*;

public class UNICODE_MAP extends JPanel {

    String[]  unicodeZones = { "Latin scripts and Symbols" ,
                               "Linguistic scripts"  ,
                               "Other European scripts",
                               "African scripts",
                               "Middle Eastern and Southwest Asian scripts",
                               "Central Asian scripts",
                               "South Asian scripts",
                               "Southeast Asian scripts",
                               "East Asian scripts",
                               "Unified CJK Han",
                               "American scripts",
                               "Symbols",
                               "Diacritics",
                               "UTF-16 surrogates and private use",
                               "Miscellaneous characters",
                               "Unallocated code points"
                              };
    JComponent[] labels;
    JLabel[] labs;
    protected boolean cell_00_01 = false;

    UNICODE_MAP() {
        setLayout(null);
//        this.setBounds(0, 0, 800, 600);

        labels = new symbol[256];
        String hexa = null;
        String upperhexa = null;
        int x = -10;
        int y = 10;
        for( int k = 0 ; k < 256 ; k++ )
        {

            x += 30;
            if( x >= 480 ) { x = 20; y += 30; }
            hexa =  Integer.toHexString(k);
            upperhexa =  hexa.toUpperCase();
           if( k < 16) upperhexa = 0 + upperhexa ;

             labels[k] = new symbol(upperhexa , k);
             labels[k].setBounds(x  , y  , 32,  32);
             this.add(labels[k]);
        }

          repaintAllLabels();
    }

    public void repaintAllLabels() {
        Font font_i = new Font("Dialog" , Font.BOLD , 16);
        Font font_default = new Font("Dialog" , Font.BOLD, 12);
        JPanel description = new JPanel(null);
        description.setBounds(510, 10, 250, 600);
        labs = new JLabel[16];
        ImageIcon[] icons  = new ImageIcon[16];
        int x1 = 10;
        int y1 = -25;
        for( int i = 0 ; i < labs.length; i++ )
        {
            y1 += 30;
            icons[i] = new icon(i);

             if( i != 4 )
            labs[i] = new JLabel(unicodeZones[i] , icons[i] , SwingConstants.LEFT ) ;
             else
                labs[i]  = new  labelcustom(unicodeZones[i], icons[i], SwingConstants.LEFT);

            labs[i].setIconTextGap(10);
              if( i != 4 )
            labs[i].setBounds( x1, y1, 240, 25 );
              else  { labs[i].setBounds( x1, y1, 240, 50 ); labs[i].setIconTextGap(10); }

              description.add( labs[i] );
        }
         if( cell_00_01 ) {   
                                 labs[0]  = new  labelcustom(unicodeZones[0], icons[0], SwingConstants.LEFT);
                                 labs[0].setFont(font_i);
                                 labs[0].setBounds( x1, y1, 240, 50 );
                                 System.out.println( " :  " + cell_00_01);
                                 description.add( labs[0] );
            }  // else labs[i].setBounds( x1, y1, 240, 25 );

        labs[0].setFont(font_default); 
//        System.out.println(this.getFont());
        this.add(description);
    }

    class symbol extends JComponent implements MouseListener  {
        String s;
        double x , y,  w , h ;
        boolean change = false;
        int fillColor = 0;

        symbol ( String str , int fill ) {
            s = str;
            fillColor = fill;
            this.addMouseListener(this);
        }

        public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
//                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
                    Rectangle2D rect = null;
                      if( !change )
                         rect = new Rectangle2D.Double( 0+1 , 0+1,  30, 30 );
                      else   // if focuced
                         rect = new Rectangle2D.Double( 0+1 , 0+1,  45, 45 );

                     // if focuced
                     if( change )
                         g2.setColor(Color.YELLOW);
                     else
                         g2.setColor(Color.WHITE);

                 if( fillColor == 0 || fillColor == 1 )
                      {
                           g2.setColor(new Color(0,0,0));
                       }
                   else if ( fillColor == 2 )
                      {
                         g2.setColor(Color.BLACK);
                         Rectangle2D rect1 = new Rectangle2D.Double( 0+1 , 0+1,  9, 30 );
                         g2.fill(rect1);
                         g2.setColor(new Color(173,216,230));
                         Rectangle2D rect2 = new Rectangle2D.Double( 10 , 0+1,  21, 30 );
                         g2.fill(rect2);
                      }
                     else if( fillColor == 3 )
                     {
                         g2.setColor(new Color(169,169,169));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  12, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 13 , 0+1,  21, 30 );
                         g2.fill(rect4);
                     }
                     else if ( fillColor == 4 )
                      {
                         g2.setColor(new Color(0,0,255));
                      }
                     else if( fillColor == 5 )
                     {
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  16, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,165,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 17 , 0+1,  21, 30 );
                         g2.fill(rect4);
                     }
                     else if ( fillColor == 6 )
                      {
                         g2.setColor(new Color(255,165,0));
                      }
                    else if ( fillColor == 7 )
                      {
                         g2.setColor(new Color(255,165,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  13, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 14 , 0+1,  8, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect5 = new Rectangle2D.Double( 22 , 0+1,  8, 30 );
                         g2.fill(rect5);
                      }
                    else if( fillColor == 8 )
                     {
                         g2.setColor(new Color(255,165,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  11, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 12 , 0+1,  18, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor >=9 &&  fillColor <=13 )
                      {
                         g2.setColor(new Color(0,100,0));
                      }
                    else if ( fillColor == 15 )
                      {
                         g2.setColor(new Color(154,205,50));
                      }
                    else if( fillColor == 16 )
                     {
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  18, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 19 , 0+1,  11, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor == 17 || fillColor == 50 || fillColor == 51 )
                      {
                         g2.setColor(new Color(255,0,0));
                      }
                    else if ( fillColor == 18 )
                      {
                         g2.setColor(new Color(144,238,144));
                      }
                    else if( fillColor == 19 )
                     {
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  19, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 20 , 0+1,  10, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor == 20 || fillColor == 21 )
                      {
                         g2.setColor(new Color(255,255,0));
                      }
                    else if( fillColor == 22 )
                     {
                         g2.setColor(new Color(255,255,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  14, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 16 , 0+1,  15, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 24 )
                     {
                         g2.setColor(new Color(154,205,50));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  20, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 22 , 0+1,  9, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 25 )
                     {
                         g2.setColor(new Color(0,100,100));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  10, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect4 = new Rectangle2D.Double( 11 , 0+1, 19, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 26 )
                     {
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  22, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 22 , 0+1, 8, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor == 27 || fillColor == 23 || fillColor == 14 )
                      {
                         g2.setColor(new Color(128,0,128));
                      }
                    else if( fillColor == 28 )
                     {
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  14, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 14 , 0+1, 10, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect5 = new Rectangle2D.Double( 24 , 0+1,  6, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 29 )
                     {
                         g2.setColor(new Color(173,216,230));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  22, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(169,169,169));
                         Rectangle2D rect4 = new Rectangle2D.Double( 23 , 0+1, 7, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor == 30 )
                      {
                         g2.setColor(new Color(0,0,0));
                      }
                    else if ( fillColor == 31 )
                      {
                         g2.setColor(new Color(0,0,255));
                      }
                     else if( fillColor == 32 )
                     {
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  13, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 14 , 0+1, 5, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect5 = new Rectangle2D.Double( 19 , 0+1,  11, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 33 )
                     {
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  17, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 18 , 0+1, 12, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor >= 34 && fillColor <= 35 )
                      {
                         g2.setColor(new Color(255,0,255));
                      }
                    else if( fillColor == 36 )
                     {
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  10, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 11 , 0+1, 19, 30 );
                         g2.fill(rect4);
                     }
                     else if ( fillColor >= 37 && fillColor <= 43 )
                      {
                         g2.setColor(new Color(255,0,255));
                      }
                    else if( fillColor == 44 )
                     {
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  10, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 11 , 0+1, 5, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect5 = new Rectangle2D.Double( 16 , 0+1,  14, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 45 )
                     {
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  4, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect4 = new Rectangle2D.Double( 5 , 0+1, 21, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect5 = new Rectangle2D.Double( 26 , 0+1,  4, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 46 )
                     {
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  14, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect4 = new Rectangle2D.Double( 14 , 0+1, 16, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 47 )
                     {
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  26, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 27 , 0+1, 2, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect5 = new Rectangle2D.Double( 29 , 0+1, 1, 30 );
                         g2.fill(rect5);
                     }
                     else if( fillColor == 48 )
                     {
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  7, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 8 , 0+1, 22, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 49 )
                     {
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  17, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect4 = new Rectangle2D.Double( 18 , 0+1, 2, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect5 = new Rectangle2D.Double( 20 , 0+1, 3, 30 );
                         g2.fill(rect5);
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect6 = new Rectangle2D.Double( 23 , 0+1, 6, 30 );
                         g2.fill(rect6);
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect7 = new Rectangle2D.Double( 29 , 0+1,  1, 30 );
                         g2.fill(rect7);
                     }
                    else if ( fillColor >= 52 && fillColor <= 76 )
                      {
                         g2.setColor(new Color(250,128,114));
                      }
                    else if( fillColor == 77 )
                     {
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  22, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 23 , 0+1, 8, 30 );
                         g2.fill(rect4);
                     }
                    else if ( fillColor >= 78 && fillColor <= 159 )
                      {
                         g2.setColor(new Color(250,128,114));
                      }
                    else if ( fillColor >= 160 && fillColor <= 164 )
                      {
                         g2.setColor(new Color(255,0,0));
                      }
                    else if ( fillColor == 165 )
                      {
                         g2.setColor(new Color(144,238,144));
                      }
                    else if( fillColor == 166 )
                     {
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  7, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 8 , 0+1, 11, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect5 = new Rectangle2D.Double( 19 , 0+1,  11, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 167 )
                     {
                         g2.setColor(new Color(173,216,230));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  5, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 6 , 0+1, 26, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 168 )
                     {
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  5, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 6 , 0+1, 2, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(154,205,50));
                         Rectangle2D rect5 = new Rectangle2D.Double( 8 , 0+1, 8, 30 );
                         g2.fill(rect5);
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect6 = new Rectangle2D.Double( 16 , 0+1, 14, 30 );
                         g2.fill(rect6);
                     }
                     else if( fillColor == 169 )
                     {
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  11, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 12 , 0+1, 4, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect5 = new Rectangle2D.Double( 16 , 0+1, 14, 30 );
                         g2.fill(rect5);
                     }
                    else if( fillColor == 170 )
                     {
                         g2.setColor(new Color(128,0,128));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  26, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 27 , 0+1, 3, 30 );
                         g2.fill(rect4);
                     }
                    else if( fillColor == 171 )
                     {
                         g2.setColor(new Color(144,238,144));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  5, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,255,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 6 , 0+1, 18, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(0,100,0));
                         Rectangle2D rect5 = new Rectangle2D.Double( 24 , 0+1, 6, 30 );
                         g2.fill(rect5);
                     }
                    else if ( fillColor >= 172 && fillColor <= 215 )
                      {
                         g2.setColor(new Color(255,0,0));
                      }
                    else if ( fillColor >= 216 && fillColor <= 248 )
                      {
                         g2.setColor(new Color(211,211,211));
                      }
                    else if ( fillColor == 249 ||  fillColor == 250 )
                      {
                         g2.setColor(new Color(250,128,114));
                      }
                    else if( fillColor == 251 )
                     {
                         g2.setColor(new Color(77,77,77));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  2, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(0,0,255));
                         Rectangle2D rect4 = new Rectangle2D.Double( 3 , 0+1, 3, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(255,165,0));
                         Rectangle2D rect5 = new Rectangle2D.Double( 6 , 0+1, 24, 30 );
                         g2.fill(rect5);
                     }
                    else if ( fillColor == 252 ||  fillColor == 253 )
                      {
                         g2.setColor(new Color(255,165,0));
                      }
                    else if( fillColor == 254 )
                     {
                         g2.setColor(new Color(0,255,255));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  2, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(250,128,114));
                         Rectangle2D rect4 = new Rectangle2D.Double( 3 , 0+1, 2, 30 );
                         g2.fill(rect4);
                         g2.setColor(new Color(169,169,169));
                         Rectangle2D rect5 = new Rectangle2D.Double( 5 , 0+1, 2, 30 );
                         g2.fill(rect5);
                         g2.setColor(new Color(255,0,255));
                         Rectangle2D rect6 = new Rectangle2D.Double( 7 , 0+1, 3, 30 );
                         g2.fill(rect6);
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect7 = new Rectangle2D.Double( 10 , 0+1, 4, 30 );
                         g2.fill(rect7);
                         g2.setColor(new Color(255,165,0));
                         Rectangle2D rect8 = new Rectangle2D.Double( 14 , 0+1, 17, 30 );
                         g2.fill(rect8);
                     }
                    else if( fillColor == 255 )
                     {
                         g2.setColor(new Color(0,0,0));
                         Rectangle2D rect3 = new Rectangle2D.Double( 0+1 , 0+1,  12, 30 );
                         g2.fill(rect3);
                         g2.setColor(new Color(255,0,0));
                         Rectangle2D rect4 = new Rectangle2D.Double( 13 , 0+1, 17, 30 );
                         g2.fill(rect4);
                     }
                     else
                           g2.setColor(new Color(255,255,255));


                    if( fillColor != 2 && fillColor != 3 && fillColor != 5 &&  fillColor != 7 &&
                        fillColor != 8 && fillColor != 16 && fillColor != 19  && fillColor != 22 &&
                        fillColor != 24 && fillColor != 25 && fillColor != 26 && fillColor != 28 &&
                        fillColor != 29 && fillColor != 32 && fillColor != 33 && fillColor != 36 &&
                        fillColor != 44 && fillColor != 45 && fillColor != 46 && fillColor != 47 &&
                        fillColor != 48 && fillColor != 49 && fillColor != 77 && fillColor != 166 &&
                        fillColor != 167 && fillColor != 168 && fillColor != 169 && fillColor != 170 &&
                        fillColor != 171 && fillColor != 251 && fillColor != 254 && fillColor != 255 )
                    g2.fill(rect);
                    g2.setColor(new Color(218,218,218));
                    g2.setStroke(new BasicStroke(2.0f));
                    g2.draw(rect);

                    Font f = null;
                     // if focuced
                    if( change )
                     f = new Font("Serif" , Font.PLAIN , 32);
                        else
                     f = new Font("Serif" , Font.PLAIN , 18);
                    FontRenderContext frc = g2.getFontRenderContext();

                    CharacterIterator  ci =  new StringCharacterIterator(s);
                    GlyphVector gv = f.createGlyphVector(frc, ci);
               if( fillColor == 0 || fillColor == 1 )
                          g2.setColor(new Color(255,255,255));
                     else if( fillColor == 2 )
                     {
                       g2.setXORMode(new Color(0, 0, 0));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 5 )
                     {
                       g2.setXORMode(new Color(0, 0, 255));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 7 )
                     {
                       g2.setXORMode(new Color(255, 165, 0));
                       g2.setColor(new Color(0, 0, 0));
                       g2.setXORMode(new Color(0, 100, 0));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 8 )
                     {
                       g2.setXORMode(new Color(0,0,0));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 22 )
                     {
                       g2.setXORMode(new Color(255,255,0));
                       g2.setColor(new Color(0,0,0));
                     }
                     else if( fillColor == 26 )
                     {
                       g2.setXORMode(new Color(128,0,128));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 28 )
                     {
                       g2.setXORMode(new Color(0,100,0));
                       g2.setColor(new Color(255,255,255));
                     }
                      else if( fillColor == 29 )
                     {
                       g2.setXORMode(new Color(173,216,230)); // 173,216,230
                       g2.setColor(new Color(255,255,255));
                     }
                      else if( fillColor == 32 )
                     {
                       g2.setXORMode(new Color(255,0,255)); // 173,216,230
                       g2.setColor(new Color(0,0,0));
                     }
                      else if( fillColor == 33 )
                     {
                       g2.setXORMode(new Color(0,0,0)); // 173,216,230
                       g2.setColor(new Color(255,255,255));
                     }
                      else if( fillColor == 36 )
                     {
                       g2.setXORMode(new Color(0,0,0)); // 173,216,230
                       g2.setColor(new Color(255,255,255));
                     }
                      else if( fillColor == 45 )
                     {
                       g2.setXORMode(new Color(144,238,144)); // 173,216,230
                       g2.setColor(new Color(0,0,0));
                     }
                     else if( fillColor == 47 )
                     {
                       g2.setXORMode(new Color(250,128,114)); 
                       g2.setColor(new Color(0,0,0));
                     }
                     else if( fillColor == 48 )
                     {
                       g2.setXORMode(new Color(255,0,0)); 
                       g2.setColor(new Color(0,0,0));
                     }
                    else if( fillColor == 77 )
                     {
                       g2.setXORMode(new Color(255,128,114)); 
                       g2.setColor(new Color(0,0,0));
                     }
                    else if( fillColor == 166 )
                     {
                       g2.setXORMode(new Color(144,238,144));
                       g2.setColor(new Color(0,0,0));
                     }
                     else if( fillColor == 167 )
                     {
                       g2.setXORMode(new Color(0,0,0));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 168 )
                     {
                       g2.setXORMode(new Color(0,100,0));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 169 )
                     {
                       g2.setXORMode(new Color(128,0,128));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 170 )
                     {
                       g2.setXORMode(new Color(128,0,128));
                       g2.setColor(new Color(255,255,255));
                     }
                     else if( fillColor == 171 )
                     {
                       g2.setXORMode(new Color(255,255,255));
                       g2.setColor(new Color(0,0,0));
                     }
                    else if( fillColor == 251 )
                     {
                       g2.setXORMode(new Color(255,165,0));
                       g2.setColor(new Color(0,0,0));
                     }
                    else if( fillColor == 254 )
                     {
                       g2.setXORMode(new Color(255,165,0));
                       g2.setColor(new Color(0,0,0));
                     }
                    else if( fillColor == 255 )
                     {
                       g2.setXORMode(new Color(0,0,0));
                       g2.setColor(new Color(255,255,255));
                     }

                     // set color = WHITE =
                     else if (   fillColor == 3 || fillColor == 4 || fillColor == 6 ||
                               ( fillColor >=9 &&  fillColor <=13 ) || fillColor == 16 || fillColor == 25 ||
                                 fillColor == 30 || fillColor == 31 || fillColor == 27 ||
                                 fillColor == 23 || fillColor == 14 || fillColor == 44 )
                     {
                         g2.setColor(new Color(255,255,255));
                     }
                      // other color = BLACK =
                       else
                          g2.setColor(new Color(0, 0, 0));

                    double centerX = rect.getCenterX(); // 16
                    double centerY = rect.getCenterY(); // 16
                    double centX   = centerX;
                    double centY   = centerY;
                    double width = gv.getOutline().getBounds2D().getWidth(); // 18
                    double height = gv.getOutline().getBounds2D().getHeight(); // 22

                    double x_loc =  (rect.getWidth() - width)/2 ;    // 30 - 8
                    double y_loc =  (rect.getHeight() - height)/2 + 14 ;   //30 - 22

//                     System.out.println(x_loc + "  " +  y_loc );

                    // if focuced
                    if( change )
                       g2.drawGlyphVector(gv, 1, 27);
                        else
                       g2.drawGlyphVector(gv, (float) x_loc, (float) y_loc);  // 3 , 22
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
                 change = true;
             Font font_i = new Font("Dialog" , Font.BOLD , 16);
//             Font font_in = new Font("Dialog" , Font.BOLD , 12);
             Font font_default = new Font("Dialog" , Font.BOLD, 12);
               if(fillColor == 0 || fillColor == 1)
               {
                   repaintAllLab();
                   labs[0].setBackground( new Color(20,235,239));
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   cell_00_01 = true;
               }
               else if( fillColor == 2 )
               {
                   repaintAllLab();
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   labs[1].setForeground(Color.red);
                   labs[1].setFont(font_i);
               }
               else if( fillColor == 3 )
               {
                   repaintAllLab();
                   labs[1].setForeground(Color.red);
                   labs[1].setFont(font_i);
                   labs[12].setForeground(Color.red);
                   labs[12].setFont(font_i);
               }
               else if( fillColor == 4 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
               }
               else if( fillColor == 5 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
               }
               else if( fillColor == 6  ||   fillColor == 252 || fillColor == 253 )
               {
                   repaintAllLab();
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
               }
               else if( fillColor == 7 )
               {
                   repaintAllLab();
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
               }
               else if( fillColor == 8 )
               {
                   repaintAllLab();
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
               }
               else if( fillColor >=9 &&  fillColor <=13 )
               {
                   repaintAllLab();
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
               }
               else if( fillColor == 14 || fillColor == 23 || fillColor == 27 )
               {
                   repaintAllLab();
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
               }
                else if( fillColor == 15 )
               {
                   repaintAllLab();
                   labs[5].setForeground(Color.red);
                   labs[5].setFont(font_i);
               }
                else if( fillColor == 16 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
               }
               else if( fillColor == 17 || fillColor == 50 || fillColor == 51 ||
                       (fillColor >=160 &&  fillColor <=164) || (fillColor >=172 &&  fillColor <=215) )
               {
                   repaintAllLab();
                   labs[8].setForeground(Color.red);
                   labs[8].setFont(font_i);
               }
               else if( fillColor == 18 || fillColor == 165 )
               {
                   repaintAllLab();
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
               }
               else if( fillColor == 19 )
               {
                   repaintAllLab();
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
                   labs[10].setForeground(Color.red);
                   labs[10].setFont(font_i);
               }
               else if( fillColor == 20 || fillColor == 21 )
               {
                   repaintAllLab();
                   labs[10].setForeground(Color.red);
                   labs[10].setFont(font_i);
               }
               else if( fillColor == 22 )
               {
                   repaintAllLab();
                   labs[10].setForeground(Color.red);
                   labs[10].setFont(font_i);
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
               }
                else if( fillColor == 24 )
               {
                   repaintAllLab();
                   labs[5].setForeground(Color.red);
                   labs[5].setFont(font_i);
                   labs[10].setForeground(Color.red);
                   labs[10].setFont(font_i);
               }
                else if( fillColor == 25 )
               {
                   repaintAllLab();
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
               }
                else if( fillColor == 26 )
               {
                   repaintAllLab();
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
               }
                else if( fillColor == 28 )
               {
                   repaintAllLab();
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
               }
                else if( fillColor == 29 )
               {
                   repaintAllLab();
                   labs[1].setForeground(Color.red);
                   labs[1].setFont(font_i);
                   labs[12].setForeground(Color.red);
                   labs[12].setFont(font_i);
               }
                else if( fillColor == 30 )
               {
                   repaintAllLab();
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
               }
                else if( fillColor == 31 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
               }
               else if( fillColor == 32 || fillColor == 33 || fillColor == 36 )
               {
                   repaintAllLab();
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
               }
               else if( fillColor == 34 || fillColor == 35 || (fillColor >= 37 && fillColor <= 43))
               {
                   repaintAllLab();
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
               }
                else if( fillColor == 44 )
               {
                   repaintAllLab();
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
               }
                else if( fillColor == 45 )
               {
                   repaintAllLab();
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
               }
               else if( fillColor == 46 )
               {
                   repaintAllLab();
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
               }
               else if( fillColor == 47 )
               {
                   repaintAllLab();
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
               }
               else if( fillColor == 48 )
               {
                   repaintAllLab();
                   labs[8].setForeground(Color.red);
                   labs[8].setFont(font_i);
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
               }
               else if( fillColor == 49 )
               {
                   repaintAllLab();
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
               }
               else if( fillColor == 50 )
               {
                   repaintAllLab();
                   labs[8].setForeground(Color.red);
                   labs[8].setFont(font_i);
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
               }
               else if( fillColor == 77 )
               {
                   repaintAllLab();
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
               }
               else if( (fillColor >= 53 && fillColor <= 76) || (fillColor >= 78 && fillColor <= 159)
                         ||  fillColor == 249 || fillColor == 250   )
               {
                   repaintAllLab();
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i);
               }
                else if( fillColor == 166 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
               }
               else if( fillColor == 167 )
               {
                   repaintAllLab();
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   labs[1].setForeground(Color.red);
                   labs[1].setFont(font_i);
               }
               else if( fillColor == 168 )
               {
                   repaintAllLab();
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
                   labs[5].setForeground(Color.red);
                   labs[5].setFont(font_i);
               }
                else if( fillColor == 169 )
               {
                   repaintAllLab();
                   labs[8].setForeground(Color.red);
                   labs[8].setFont(font_i);
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
               }
                else if( fillColor == 170 )
               {
                   repaintAllLab();
                   labs[7].setForeground(Color.red);
                   labs[7].setFont(font_i);
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
               }
               else if( fillColor == 171 )
               {
                   repaintAllLab();
                   labs[15].setForeground(Color.red);
                   labs[15].setFont(font_i);
                   labs[6].setForeground(Color.red);
                   labs[6].setFont(font_i);
                   labs[3].setForeground(Color.red);
                   labs[3].setFont(font_i);
               }
               else if( fillColor >= 216 && fillColor <= 248 )
               {
                   repaintAllLab();
                   labs[13].setForeground(Color.red);
                   labs[13].setFont(font_default);
               }
               else if( fillColor == 251 )
               {
                   repaintAllLab();
                   labs[2].setForeground(Color.red);
                   labs[2].setFont(font_i);
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
               }
               else if( fillColor == 254 )
               {
                   repaintAllLab();
                   labs[14].setForeground(Color.red);
                   labs[14].setFont(font_i);
                   labs[9].setForeground(Color.red);
                   labs[9].setFont(font_i); 
                   labs[12].setForeground(Color.red);
                   labs[12].setFont(font_i);
                   labs[11].setForeground(Color.red);
                   labs[11].setFont(font_i);
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   labs[4].setForeground(Color.red);
                   labs[4].setFont(font_i);
               }
               else if( fillColor == 255 )
               {
                   repaintAllLab();
                   labs[0].setForeground(Color.red);
                   labs[0].setFont(font_i);
                   labs[8].setForeground(Color.red);
                   labs[8].setFont(font_i);
                   labs[14].setForeground(Color.red);
                   labs[14].setFont(font_i);
               }
               else
               {   repaintAllLab();  }
                 this.repaint();

        }
        @Override
        public void mouseExited(MouseEvent e) {
            change = false;
            cell_00_01 = false;
//            repaintAllLabels();
            
            this.repaint();
        }

        public void repaintAllLab() {
             Font font_default = new Font("Dialog" , Font.BOLD, 12);
             for( int k = 0 ; k < labs.length ; k++ )
                   {
                       labs[k].setFont(font_default);
                       labs[k].setForeground(Color.BLACK);
                   }
        }
    }

   class icon extends ImageIcon {
        int width = 22;
        int height = 12;
        int selectColor ;

        icon( int select ) {
           selectColor = select;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2  =(Graphics2D) g;
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int choice = this.getSelectionColor();

            Rectangle2D rect = new Rectangle2D.Double(x+1, y, getIconWidth(), getIconHeight() );
            // = set selected color =
            switch(choice) {
                default: break;
                case 0:
                    g2.setPaint( new Color(0,0,0)  );
                    break;
                case 1:
                    g2.setPaint( new Color(173,216,230)  );
                    break;
                case 2:
                    g2.setPaint( new Color(0,0,255)  );
                    break;
                case 3:
                    g2.setPaint( new Color(144,238,144)  );
                    break;
                case 4:
                    g2.setPaint( new Color(255,165,0)  );
                    break;
                case 5:
                    g2.setPaint( new Color(154,205,50)  );
                    break;
                case 6:
                    g2.setPaint( new Color(0,100,0)  );
                    break;
                case 7:
                    g2.setPaint( new Color(128,0,128)  );
                    break;
                case 8:
                    g2.setPaint( new Color(248,44,44)  );
                    break;
                case 9:
                    g2.setPaint( new Color(250,128,114)  );
                    break;
                case 10:
                    g2.setPaint( new Color(255,255,0)  );
                    break;
                case 11:
                    g2.setPaint( new Color(255,0,255)  );
                    break;
                case 12:
                    g2.setPaint( new Color(169,169,169)  );
                    break;
                case 13:
                    g2.setPaint( new Color(211,211,211)  );
                    break;
                case 14:
                    g2.setPaint( new Color(0,255,255)  );
                    break;
                case 15:
                    g2.setPaint( new Color(255,255,255)  );
                    break;
                case 16:
                    g2.setPaint( new Color(255,255,255)  );
                    break;
            }
            g2.setStroke(new BasicStroke(2.0f));
            g2.fill(rect);
            g2.setPaint( new Color(218,218,218) );
            g2.draw(rect);
        }

        @Override
        public int getIconWidth() {
             return width;
        }

        @Override
        public int getIconHeight() {
             return height;
        }

        public int getSelectionColor() {
            return selectColor;
        }
   }

   class labelcustom extends JLabel {
       String str;
       JPanel p ;
       ImageIcon iconTarget;
       JLabel l;

       labelcustom( String text, ImageIcon icon, int horizontalAlignment) {
           p = new JPanel(new BorderLayout());
//           p.setBackground(Color.red);
//           p.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           p.setBounds(0, 0, 24 , 25 );
            l = new JLabel( null , icon , SwingConstants.LEFT );
           l.setBounds(2, 0, icon.getIconWidth(), icon.getIconHeight() );
           p.add(l);
//           setIcon( iconTarget );
           this.add(p);
           iconTarget =  icon;

        this.setHorizontalTextPosition(SwingConstants.LEFT);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        str = text;     
        Font font = new Font("Serif" , Font.BOLD  , 16);
        setHorizontalAlignment(horizontalAlignment);
        updateUI();
        setAlignmentX(LEFT_ALIGNMENT);
//        System.out.println(font);
       }

        @Override
       public void paintComponent(Graphics g) {
            super.paintComponent(g);
          Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
          Font font = new Font("Dialog" , Font.BOLD  , 12);
//          g2.setFont(font);
          AttributedString as = new AttributedString(str);
          as.addAttribute(TextAttribute.FONT, font);
          AttributedCharacterIterator aci = as.getIterator();
         
                FontRenderContext frc = g2.getFontRenderContext();
                LineBreakMeasurer lbm = new LineBreakMeasurer(aci, frc);
                float wrappingwidth = 200;
                float x = 35;
                float y = 0;

                while (lbm.getPosition() < aci.getEndIndex()) {
                    TextLayout textLayout = lbm.nextLayout(wrappingwidth);
//                    y += textLayout.getAscent();
                    y+= 12;
                    textLayout.draw(g2, x, y);
                    y += textLayout.getDescent() + textLayout.getLeading();
                }
//                System.out.println("Label ");
       }
   }

}
