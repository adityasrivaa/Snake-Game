/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author sriva
 */
public class Gameplay extends JPanel implements KeyListener,ActionListener{
    
    private int[] Snakexlength=new int[750];
    private int[] Snakeylength=new int[750];
    
    private boolean D=false;
    private boolean A=false;
    private boolean W=false;
    private boolean S=false;
    
    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage;
    
    private int[] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    
    private ImageIcon enemyimage;
    
    private Random random=new Random();
    
    private int xpos=random.nextInt(34);
    
    private int ypos=random.nextInt(23);
    private Timer timer;
    private int delay=125;  //for speed
    
    private int lengthofsnake=3;
    private int moves=0;
    private int Scores=0;
    
    private ImageIcon titleImage;
    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer=new Timer(delay,this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        if(moves==0)
        {
            Snakexlength[0]=100;
            Snakexlength[1]=75;
            Snakexlength[2]=50;
            
            Snakeylength[0]=100;
            Snakeylength[1]=100;
            Snakeylength[2]=100;
        }
        
        //border of title image
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55); //Draws the outline of the specified rectangle
        
        //titleImage =new ImageIcon("snaketitle.jpg");
        titleImage = new ImageIcon("snaketitle.jpg");
        
        titleImage.paintIcon(this, g,25,11);  
        //border of gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);
        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,575);  // Fills the specified rectangle
        
        //draw the scores
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Scores: "+Scores,780,30);
        g.drawString("Length: "+lengthofsnake,780,50);
        
        rightmouth=new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g,Snakexlength[0],Snakeylength[0]);
        
        for(int a=0;a<lengthofsnake;a++)
        {
            if(a==0 && D)
            {
                rightmouth=new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g,Snakexlength[a],Snakeylength[a]);
            }
           
            if(a==0 && A)
            {
                leftmouth=new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g,Snakexlength[a],Snakeylength[a]);
            }
            
            if(a==0 && W)
            {
                upmouth=new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g,Snakexlength[a],Snakeylength[a]);
            }
            
            if(a==0 && S)
            {
                downmouth=new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g,Snakexlength[a],Snakeylength[a]);
            }
            if(a!=0)
            {
               snakeimage=new ImageIcon("snakeimage.png");
               snakeimage.paintIcon(this, g,Snakexlength[a],Snakeylength[a]); 
            }
        }
        enemyimage =new ImageIcon("enemy.png");
        enemyimage.paintIcon(this, g,enemyxpos[xpos], enemyypos[ypos]);
        
        for(int b=1;b<lengthofsnake;b++)
        {
            if(Snakexlength[b]==Snakexlength[0] && Snakeylength[b]==Snakeylength[0])
            {
                D=false;
                A=false;
                W=false;
                S=false;
                
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("Game Over",300,300);
                
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("Press Enter to Restart",350,340);
            }
        }
        
        if(enemyxpos[xpos]==Snakexlength[0] && enemyypos[ypos]==Snakeylength[0])
        {
            lengthofsnake++;
            Scores++;
            xpos=random.nextInt(34);
            ypos=random.nextInt(23);
        }
                
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e.getKeyCode()==KeyEvent.VK_D)
        {
            moves++;
            if(!A)
            {
                D=true;
            }
            else
            {
                D=false;
                A=true;
            }
            W=false;
            S=false;
        }
        
         if(e.getKeyCode()==KeyEvent.VK_A)
        {
            moves++;
            if(!D)
            {
                A=true;
            }
            else
            {
                A=false;
                D=true;
            }
            W=false;
            S=false;
        }
         
          if(e.getKeyCode()==KeyEvent.VK_W)
        {
            moves++;
            if(!S)
            {
                W=true;
            }
            else
            {
                W=false;
                S=true;
            }
            D=false;
            A=false;
        }
          
           if(e.getKeyCode()==KeyEvent.VK_S)
        {
            moves++;
            if(!W)
            {
                S=true;
            }
            else
            {
                S=false;
                W=true;
            }
            D=false;
            A=false;
        }
           
           if(e.getKeyCode()==KeyEvent.VK_ENTER)
           {
               Scores=0;
               moves=0;
               lengthofsnake=3;
               repaint();
           }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(D)
        {
            for(int i=lengthofsnake-1;i>=0;i--)
            {
                 Snakeylength[i+1]=Snakeylength[i];
            }
            for(int i=lengthofsnake;i>=0;i--)
            {
                if(i==0)
                {
                    Snakexlength[i]=Snakexlength[i]+25;
                }
                else
                {
                    Snakexlength[i]=Snakexlength[i-1];
                }
                
                if(Snakexlength[i]>850)  //Snake do not touch boundary
                {
                    Snakexlength[i]=25;
                }
            }
            repaint();
        }
        
        if(A)
        {
            for(int i=lengthofsnake-1;i>=0;i--)
            {
                 Snakeylength[i+1]=Snakeylength[i];
            }
            for(int i=lengthofsnake;i>=0;i--)
            {
                if(i==0)
                {
                    Snakexlength[i]=Snakexlength[i]-25;
                }
                else
                {
                    Snakexlength[i]=Snakexlength[i-1];
                }
                
                if(Snakexlength[i]<25)  //Snake do not touch boundary
                {
                    Snakexlength[i]=850;
                }
            }
            repaint();
        }
        
        if(W)
        {
            for(int i=lengthofsnake-1;i>=0;i--)
            {
                 Snakexlength[i+1]=Snakexlength[i];
            }
            for(int i=lengthofsnake;i>=0;i--)
            {
                if(i==0)
                {
                    Snakeylength[i]=Snakeylength[i]-25;
                }
                else
                {
                    Snakeylength[i]=Snakeylength[i-1];
                }
                
                if(Snakeylength[i]<75)  //Snake do not touch boundary
                {
                    Snakeylength[i]=625;
                }
            }
            repaint();
        }
        
        if(S)
        {
            for(int i=lengthofsnake-1;i>=0;i--)
            {
                 Snakexlength[i+1]=Snakexlength[i];
            }
            for(int i=lengthofsnake;i>=0;i--)
            {
                if(i==0)
                {
                    Snakeylength[i]=Snakeylength[i]+25;
                }
                else
                {
                    Snakeylength[i]=Snakeylength[i-1];
                }
                
                if(Snakeylength[i]>625)  //Snake do not touch boundary
                {
                    Snakeylength[i]=75;
                }
            }
            repaint();
        }
    }

   
   
}
