import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The WarGame class creates a GUI for the war game and has a flip button
   class and a quit button class
*/
public class War extends JFrame 
{
   final int HANDSIZE = 52;
   private ArrayList<ImageIcon> p1Images = new ArrayList<ImageIcon>();
   private ArrayList<ImageIcon> p2Images = new ArrayList<ImageIcon>();
   private JLabel label1, label2, p1ImagesCard, p2ImagesCard, p1ImagesCardCount, p2ImagesCardCount, l1, l2, l3, l4;
   private JPanel panel1, panel2;
   private JButton flipButton;
   private ImageIcon p1, p2;
   
      public War()
   {
      
      HandsForPlayer p = new HandsForPlayer();
            p1Images = p.player1Hand();
      p2Images = p.player2Hand();
      
      
      setTitle("Game");
      
      setSize(600, 500);  
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JLabel label1 = new JLabel("Flip?");
      JLabel label2 = new JLabel("WAR");
      
      
      //setLayout
      setLayout(new GridLayout(2,4));
      
      
      //start the images face down
            
      
      //add everything to there place in the GUI
      flipButton = new JButton("Flip");
      p1ImagesCardCount = new JLabel("Player 1  : " + p1Images.size());
      flipButton.addActionListener(new FlipButtonListener());
      panel1 = new JPanel();
      panel1.add(label1);
      panel1.add(flipButton);
      panel1.add(p1ImagesCardCount);
      ImageIcon im = new ImageIcon("back.jpg");
      p1ImagesCard = new JLabel(im);
      p2ImagesCard = new JLabel(im);

      
      panel2 = new JPanel();
      p2ImagesCardCount = new JLabel("Player 2  : "+ p2Images.size());
      panel2.add(label2);
      
      panel2.add(p2ImagesCardCount);
      
      
      //set background colors 
      l1 = new JLabel();
      l2 = new JLabel();
      l3 = new JLabel();
      l4 = new JLabel();      
      add(panel1);
      add(p1ImagesCard);
      add(l1);
      add(l2);
      add(panel2);
      add(p2ImagesCard);
      add(l3);
      add(l4);
      
      //setVisible
      setVisible(true);
      
           
   }
   
    private class FlipButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try{
            
            l1.setIcon(null);
            l2.setIcon(null);
            l3.setIcon(null);
            l4.setIcon(null);
            
            p1 = p1Images.get(0);
            p2 = p2Images.get(0);
            
            String string1 = p1.getDescription();
            String string2 = p2.getDescription();
            int  s = 0;
            int  s1 = 0;
            
            while ( s == 0)
            {
            if (string1.startsWith("2"))
                s = 2;
            else if(string1.startsWith("3"))
                s = 3;
            else if(string1.startsWith("4"))
                s = 4;
            else if(string1.startsWith("5"))
                s = 5;
            else if(string1.startsWith("6"))
                s = 6;
            else if(string1.startsWith("7"))
                s = 7;
            else if(string1.startsWith("8"))
                s = 8;
            else if(string1.startsWith("9"))
                s = 9;
            else if(string1.startsWith("10"))
                s = 10;
            else if(string1.startsWith("jack"))
                s = 11;
            else if(string1.startsWith("queen"))
                s = 12;
            else if(string1.startsWith("king"))
                s = 13;
            else if(string1.startsWith("ace"))
                s = 14;
            }
            
            
            while ( s1 == 0)
            {
            if (string2.startsWith("2"))
                s1 = 2;
            else if(string2.startsWith("3"))
                s1 = 3;
            else if(string2.startsWith("4"))
                s1 = 4;
            else if(string2.startsWith("5"))
                s1 = 5;
            else if(string2.startsWith("6"))
                s1 = 6;
            else if(string2.startsWith("7"))
                s1 = 7;
            else if(string2.startsWith("8"))
                s1 = 8;
            else if(string2.startsWith("9"))
                s1 = 9;
            else if(string2.startsWith("10"))
                s1 = 10;
            else if(string2.startsWith("jack"))
                s1 = 11;
            else if(string2.startsWith("queen"))
                s1 = 12;
            else if(string2.startsWith("king"))
                s1 = 13;
            else if(string2.startsWith("ace"))
                s1 = 14;
            }
             
            
            p1ImagesCard.setIcon(p1Images.remove(0));
            
            p2ImagesCard.setIcon(p2Images.remove(0));
            
            p1ImagesCardCount.setText("Player 1  : " + p1Images.size());
            
            p2ImagesCardCount.setText("Player 2  : " + p2Images.size());
            
            
            if( s >  s1)
            {
               p1Images.add(p1);
               p1Images.add(p2);
               
               p1ImagesCardCount.setText("Player 1  : " + p1Images.size() + " \nWINNER!");
               p2ImagesCardCount.setText("Player 2  : " + p2Images.size());
               
               
               
            }
            else if( s1 >  s)
            {
               p2Images.add(p1);
               p2Images.add(p2);
               
               p1ImagesCardCount.setText("Player 1  : " + p1Images.size());
               p2ImagesCardCount.setText("Player 2  : " + p2Images.size() + " \nWINNER!");
        
            }
            
            else if( s ==  s1)
            {
             p1Images.add(p1);
             p1Images.add(p2);  
            }
            if(p1Images.size() == 0)
            {
               JOptionPane.showMessageDialog(null, "Player 2 wins!!!");
            }
            else if(p2Images.size() == 0)
               JOptionPane.showMessageDialog(null, "Player 1 wins!!!");
          }
       catch(RuntimeException m)
       {
         JOptionPane.showMessageDialog(null, "There are no cards left to flip");
       }
   
      }
   }
   
               
            public static void main(String[] args)
            {
               new War();
            } 
   

   
   
   
}