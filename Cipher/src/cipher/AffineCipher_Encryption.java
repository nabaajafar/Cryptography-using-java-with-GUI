package cipher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AffineCipher_Encryption extends JFrame {
    
    JLabel l = new JLabel("Affine Cipher Encryption");
    JLabel la = new JLabel("Enter A:");
    JLabel lb = new JLabel("Enter B:");
    JLabel lp = new JLabel("Enter Plaintext:");
    JLabel lc = new JLabel("The Ciphertext:");
    
    JLabel et1 = new JLabel("                         ");
    JLabel et2 = new JLabel("                                    ");
    JLabel et3 = new JLabel("                         ");
    
    JTextField ta = new JTextField(5);
    JTextField tb = new JTextField(5);
    JTextField tp = new JTextField(15);
    JTextField tc = new JTextField(15);
    
    JButton b = new JButton("Encrypt");
    
    JPanel p = new JPanel();
    
    public AffineCipher_Encryption(){
        
        super("Affine Cipher Encryption");
        
        ImageIcon bg=new ImageIcon(getClass().getResource("picunl.jpg")); 
        Image img= bg.getImage();
        bg.setImage(img.getScaledInstance(600, 600, Image.SCALE_SMOOTH));
        JLabel im  =new JLabel(bg);
        im.setBounds(0, 0, 500, 500);
        
        p.setBackground(new Color(0,0,0,0));
        p.setBounds(10, 10, 450, 400);
        p.setLayout(new FlowLayout());
        
        l.setFont(new Font ("Times New Roman",Font.BOLD,40));
        la.setFont(new Font ("Times New Roman",Font.BOLD,15));
        lb.setFont(new Font ("Times New Roman",Font.BOLD,15));
        lp.setFont(new Font ("Times New Roman",Font.BOLD,15));
        lc.setFont(new Font ("Times New Roman",Font.BOLD,15));
        tc.setEditable(false);
        b.setPreferredSize(new Dimension(400, 50));
        
        p.add(l);
        p.add(et1);
        p.add(la);
        p.add(ta);
        p.add(lb);
        p.add(tb);
        p.add(et2);
        p.add(lp);
        p.add(tp);
        p.add(et3);
        p.add(b);
        p.add(lc);
        p.add(tc);
        
        im.add(p);
        this.add(im);
        
        b.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                if((!tp.getText().isEmpty()) && (!ta.getText().isEmpty()) && (!tb.getText().isEmpty())){
                    
                    int at = Integer.parseInt(ta.getText());
                    int bt =Integer.parseInt(tb.getText());
                    
                    if( at%2 == 0  ){ // GCD ( 𝑎,𝑚) = 1
                        JOptionPane.showMessageDialog(rootPane, "please enter odd number for a",
                            "number", HEIGHT);
                    }
                    
                    else {
                        
                        String sf = "" , sp ;
                        int n , pn = 0 , y ;
                        sp =tp.getText();
                        sp = sp.replaceAll(" ", ""); // remove space
                        sp = sp.toLowerCase();
                        n = sp.length();
                        char chp[] = sp.toCharArray(); 
                        char chs = 'a' ;
                        Home h = new Home();
                        char arc [] = h.arc ;
 
                        for (int i = 0 ; i < n ; i++) {
                        
                            for (int j = 0 ; j < arc.length ; j++) { // find letter number
                                if(chp[i] == arc[j])
                                    pn = j ;
                            }
                        
                            // 𝑦 = (𝑎𝑥 + 𝑏) 𝑀𝑂𝐷 𝑚
                            y = (at*pn)+bt ; //𝑦 = (𝑎𝑥 + 𝑏) 
                            y = h.findMOD(y); // find mod 26
                        
                            for (int j = 0 ; j < arc.length ; j++) { // find letter 
                                if(y == j)
                                    chs = arc[j];
                            }
                        
                            sf += chs ;
                        
                        }
                
                        sf = sf.toUpperCase();
                        tc.setText(sf);
                    
                    }
                    
                }
                
                else{
                    JOptionPane.showMessageDialog(rootPane, "please Enter all information",
                            "complete", HEIGHT);
                }
                
            }
                });
    }

  
}
