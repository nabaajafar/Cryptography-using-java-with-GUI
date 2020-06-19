package cipher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShiftCipher extends JFrame implements ActionListener {
      
    Icon i1 = new ImageIcon(getClass().getResource("enc2.png"));
    Icon i2 = new ImageIcon(getClass().getResource("dec2.png"));
    
    JLabel l = new JLabel("Shift Cipher");
    JLabel et1 = new JLabel("                                                                                       ");
    JLabel et2 = new JLabel("                                                                                       ");
    
    JButton b1 = new JButton(i1);
    JButton b2 = new JButton(i2);

    JPanel p=new JPanel();
    
    public ShiftCipher(){
        
        super("Shift Cipher");
        
        ImageIcon bg=new ImageIcon(getClass().getResource("pich.jpg")); 
        Image img= bg.getImage();
        bg.setImage(img.getScaledInstance(600, 600, Image.SCALE_SMOOTH));
        JLabel im  =new JLabel(bg);
        im.setBounds(0, 0, 500, 500);
        
        p.setBackground(new Color(0,0,0,0));
        p.setBounds(10, 10, 400, 400);
        p.setLayout(new FlowLayout ());
            
        l.setFont(new Font ("Times New Roman",Font.BOLD,50));
        l.setForeground(Color.WHITE);

        b1.setPreferredSize(new Dimension(150, 180));
        b2.setPreferredSize(new Dimension (150, 180));
        
        p.add(l);
        p.add(et1);
        p.add(et2);
        p.add(b1);
        p.add(b2);
        
        im.add(p);
        this.add(im);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == b1){
            ShiftCipher_Encryption se = new ShiftCipher_Encryption();
            se.setVisible(true);
            se.setSize(500,250);
            se.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            se.setResizable(false);
        }
        
        if(e.getSource() == b2){
            ShiftCipher_Decryption sd = new ShiftCipher_Decryption();
            sd.setVisible(true);
            sd.setSize(500,250);
            sd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            sd.setResizable(false);
        }        
        
    }
    
}
