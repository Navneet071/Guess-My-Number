import javax.swing.*;

public class Winner extends JFrame {


    public Winner(){
        setLayout(null);

        ImageIcon winner = new ImageIcon(ClassLoader.getSystemResource("images/win.gif"));
        JLabel img = new JLabel(winner);
        img.setBounds(-50,-50,600,600);
        add(img);


        setSize(500,500);
        setLocation(600,150);
        setVisible(true);
    }

}
