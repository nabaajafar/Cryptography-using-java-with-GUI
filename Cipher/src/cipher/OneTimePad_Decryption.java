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

public class OneTimePad_Decryption extends JFrame {
    
    JLabel l = new JLabel("One Time Pad Decryption");
    JLabel lk = new JLabel("Enter the Key word:");
    JLabel lc = new JLabel("Enter Ciphertext:");
    JLabel lp = new JLabel("The Plaintext:");
    
    JLabel et1 = new JLabel("      ");
    JLabel et2 = new JLabel("                                    ");
    JLabel et3 = new JLabel("                         ");
    
    JTextField tk = new JTextField(12);
    JTextField tp = new JTextField(15);
    JTextField tc = new JTextField(15);
    
    JButton b = new JButton("Decrypt");
    
    JPanel p = new JPanel();
    
    public OneTimePad_Decryption(){
        
        super("One Time Pad Decryption");
        
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
            public void actionPerformed(ActionEvent e) {
                
                int n , nk , np ;
                String sf = "" , sp , sk ;
                
                sk =tk.getText();
                sk = sk.replaceAll(" ", ""); // remove space
                nk = sk.length();
                sp =tp.getText();
                sp = sp.replaceAll(" ", ""); // remove space
                np = sp.length();
                
                if(nk != np){
                JOptionPane.showMessageDialog(rootPane, "length of the Ciphertext must be equal to key word",
                            "length", HEIGHT);}
                
                else if(!tp.getText().isEmpty() && !tk.getText().isEmpty()){
                    
                    int pn = 0 , kn = 0 , t , tm ;
                    sk=sk.toLowerCase();
                    sp=sp.toLowerCase();
                    n=sk.length();
                    char ch1[] = sk.toCharArray();
                    char ch2[] = sp.toCharArray();
                    char chs = 'a';
                    Home h = new Home();
                    char arc [] = h.arc ;
                    
                    for(int i = 0 ; i < n ; i++){
                        
                        for (int j = 0; j < arc.length; j++) { // find letters number
                            if(ch1[i]==arc[j])
                                kn = j;
                            if(ch2[i] == arc[j])
                                pn = j ;
                         }
                        
                        // Ciphertext – Key (mod 26) 
                        t = pn-kn ; //Ciphertext – Key 
                        tm = t ;
                        tm = h.findMOD(tm); // find mod 26
                        
                        for (int j = 0 ; j < arc.length ; j++) { // find letter 
                            if(tm==j)
                                chs = arc[j];
                         }
                        
                        sf += chs ;
  
                         }
                     
                    sf = sf.toUpperCase();
                    tc.setText(sf);
                    
                }
                
            }
        });

    }

    
}
