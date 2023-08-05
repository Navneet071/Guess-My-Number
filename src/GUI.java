import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    static int lifeline = 5;
    static int actualNo=0,userNo=0;

    JTextField myNum,message,attempt;
    JButton guess,answer,replay;
    public GUI(){
        setLayout(null);



        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("images/random1.jpg"));
        JLabel image = new JLabel(img1);
        image.setBounds(-70,-100,600,600);
        add(image);

        JLabel heading = new JLabel("-:Guess My Number Game:-");
        heading.setBounds(500,30,800,40);
        heading.setFont(new Font("Monospaced", Font.BOLD, 45));
        heading.setForeground(new Color(30,140,250));
        add(heading);

        JLabel name = new JLabel("Enter Your Number (1-100): ");
        name.setBounds(500,100,700,40);
        name.setFont(new Font("Hang-latter",Font.BOLD,30));
        name.setForeground(new Color(217, 73, 73));
        add(name);

        myNum = new JTextField();
        myNum.setBounds(950,100,150,40);
        myNum.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(21,59,206)));
        myNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(myNum);

        message = new JTextField();
        message.setBounds(650,180,400,35);
        message.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        message.setFont(new Font("Times New Roman", Font.PLAIN, 20));



        attempt = new JTextField("You have total " + lifeline +" Attempts...");
        attempt.setBounds(650,250,400,35);
        attempt.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        attempt.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        add(attempt);

        answer = new JButton("Check Answer");
        answer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        answer.setForeground(Color.black);
        answer.setBounds(550, 320, 130, 40);
        answer.addActionListener(this);
        answer.setEnabled(false);
        add(answer);


        guess = new JButton("Guess");
        guess.setCursor(new Cursor(Cursor.HAND_CURSOR));
        guess.setForeground(Color.black);
        guess.setBounds(750, 320, 130, 40);
        guess.addActionListener(this);
        add(guess);



        replay = new JButton("Play Again");
        replay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        replay.setForeground(Color.black);
        replay.setBounds(950, 320, 130, 40);
        replay.addActionListener(this);
        replay.setEnabled(false);
        add(replay);


        JLabel copyright = new JLabel("2023 Developed By: Navneet Baranwal");
        copyright.setBounds(700,367,500,30);
        copyright.setForeground(Color.red);
        copyright.setFont(new Font("Monospaced", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        add(copyright);


        setSize(1200,430);
        setLocation(100, 150);
        setTitle("Guess My Number ♠️");
        getContentPane().setBackground(new Color(231, 219, 204));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    //                                                      DRIVER CODE

    public static void main(String[] args) {
        new GUI();
        Check check = new Check();
        actualNo = check.Verify(userNo);
        System.out.println(actualNo);
    }

    //                                                      EVENT LISTENER

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guess){                                                          // if Guess button clicked

            int userNo = Integer.parseInt(myNum.getText());

            if (actualNo < userNo){

                add(message);
                message.setText("Your Guessed Number is Greater");
                lifeline--;
                if (lifeline > 0)
                    attempt.setText("You have " +  lifeline + " Attempts Left...");
                else {
                    message.setText("You Loose !!! Better Luck next Time");
                    attempt.setText("You have " +  lifeline + " Attempts Left...");
                }

            }else if (actualNo > userNo){

                add(message);
                message.setText("Your Guessed Number is Smaller...");
                lifeline--;
                if (lifeline > 0)
                    attempt.setText("You have " +  lifeline + " Attempts Left...");
                else{
                    message.setText("You Loose !!! Better Luck next Time");
                    attempt.setText("You have " +  lifeline + " Attempts Left...");
                }
            } else if (lifeline >= 0 ){
                add(message);
                message.setText("CONGRATULATION !!! You WON the Game ");
                setVisible(false);
                new Winner();
            }
            if (lifeline == 0){
                guess.setEnabled(false);
                answer.setEnabled(true);
                replay.setEnabled(true);
            }


        }

        //                                             CHECK ANSWER

        if (e.getSource() == answer){                                                  // if Check Answer button clicked
            if (lifeline == 0){
                System.out.println("**********");
                message.setText("The Actual Number is : " + actualNo);
            }
        }

        //                                              PLAY AGAIN

        if (e.getSource() == replay){                                                    // if Play Again button clicked
            setVisible(false);
            lifeline = 5;
            new GUI();
        }
    }
}
