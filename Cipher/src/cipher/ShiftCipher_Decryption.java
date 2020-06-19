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

public class ShiftCipher_Decryption extends JFrame {
    
    JLabel l = new JLabel("Shift Cipher Decryption");
    JLabel lk = new JLabel("Enter the Key number:");
    JLabel lc = new JLabel("Enter Ciphertext:");
    JLabel lp = new JLabel("The Plaintext:");
    
    JLabel et1 = new JLabel("           ");
    JLabel et2 = new JLabel("                                    ");
    JLabel et3 = new JLabel("                         ");
    
    JTextField tk = new JTextField(10);
    JTextField tp = new JTextField(15);
    JTextField tc = new JTextField(15);
    
    JButton b = new JButton("Decrypt");
    
    JPanel p = new JPanel();
    
    public ShiftCipher_Decryption(){
        
        super("Shift Cipher Decryption");
        
        ImageIcon bg=new ImageIcon(getClass().getResource("picunl.jpg")); 
        Image img= bg.getImage();
        bg.setImage(img.getScaledInstance(600, 600, Image.SCALE_SMOOTH));
        JLabel im  =new JLabel(bg);
        im.setBounds(0, 0, 500, 500);
        
        p.setBackground(new Color(0,0,0,0));
        p.setBounds(10, 10, 450, 400);
        p.setLayout(new FlowLayout());
        
        l.setFont(new Font ("Times New Roman",Font.BOLD,40));
        lk.setFont(new Font ("Times New Roman",Font.BOLD,15));
        lp.setFont(new Font ("Times New Roman",Font.BOLD,15));
        lc.setFont(new Font ("Times New Roman",Font.BOLD,15));
        tc.setEditable(false);
        b.setPreferredSize(new Dimension(400, 50));
        
        p.add(l);
        p.add(et1);
        p.add(lk);
        p.add(tk);
        p.add(et2);
        p.add(lc);
        p.add(tp);
        p.add(et3);
        p.add(b);
        p.add(lp);
        p.add(tc);
        
        im.add(p);
        this.add(im);
        
        b.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int sk ,n , pn = 0  ;
                String sf = "" , sp ;
  
                if(!tp.getText().isEmpty() && !tk.getText().isEmpty()){
                    
                    sp =tp.getText();
                    sp = sp.toLowerCase();
                    sp = sp.replaceAll(" ", ""); // remove space
                    n = sp.length();
                    char chp[] = sp.toCharArray(); ;
                    char chs ;
                    Home h = new Home();
                    char arc [] = h.arc ;
                    sk = Integer.parseInt(tk.getText()); // Shift Key

                    for(int i = 0 ; i < n ; i++){
                    
                        for (int j = 0 ; j < arc.length ; j++) { // find letter number
                            if(chp[i] == arc[j])
                                pn = j ;
                        }
                        
                        pn -= sk ; 
                        
                        pn = h.findMOD(pn) ; // find mod 26
                        
                        chs = arc[pn] ;  
                         
                        sf += chs ;
                        
                    }
                    
                    sf = sf.toUpperCase();
                    tc.setText(sf);
                    
                }
                  
                else{
                    JOptionPane.showMessageDialog(rootPane, "please Enter all information",
                            "complete", HEIGHT);
                }
                
            }
        });
    }

    
}
