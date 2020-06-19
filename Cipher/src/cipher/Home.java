package cipher;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    
    JLabel l = new JLabel("Algorithms");
    
    JButton b1 = new JButton("Shift Cipher");
    JButton b2 = new JButton("Affine Cipher");
    JButton b3 = new JButton("One Time Pad");
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    public Home(){
        
        this.setLayout(new GridLayout (2,1));
        this.setBackground(Color.PINK);
        p1.setBackground(Color.PINK);
        p2.setBackground(Color.PINK);
        
        l.setFont(new Font ("Times New Roman",Font.BOLD,80));
        
        b1.setPreferredSize(new Dimension(140, 50));
        b2.setPreferredSize(new Dimension (140, 50));
        b3.setPreferredSize(new Dimension (140, 50));
        
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        p1.setLayout(new FlowLayout ());
        p2.setLayout(new FlowLayout ());
        
        this.add(p1);
        this.add(p2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    
    // array use in Encryption and Decryption
    public char arc [] = {'a','b','c','d','e','f','g','h','i','j','k',
        'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} ;
    
    public int findMOD (int n){ // function to find mod 26
        
        int num = n ;
        
        while(num>25) // find mod 26 for positive numbers
            num -= 26 ;
        
        while(num<0) // find mod 26 for negative numbers
            num += 26 ;
        
        return num ;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == b1 ){
            ShiftCipher s = new ShiftCipher();
            s.setVisible(true);
            s.setSize(450,400);
            s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            s.setResizable(false);
        }
        
        if(e.getSource() == b2 ){
            AffineCipher a = new AffineCipher();
            a.setVisible(true);
            a.setSize(450,400);
            a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            a.setResizable(false);
        }        
        
        if(e.getSource() == b3 ){
            OneTimePad o = new OneTimePad();
            o.setVisible(true);
            o.setSize(450,400);
            o.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            o.setResizable(false);
        }
    
    }
    
}
