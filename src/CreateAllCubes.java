import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CreateAllCubes extends JFrame {

    private static final long serialVersionUID = 1L;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        Font font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);

        char ch = 0;
        String s = Character.toString(ch);

        for( ch = 'a' ; ch <= 'z' ; ch++ ) {
            g.drawString(s, 50, 150);
        }
    }

    public CreateAllCubes() {

        this.getContentPane().setLayout(new FlowLayout());
        char ch;
        for( ch = 'a' ; ch <= 'z' ; ch++ ) {
            String s = Character.toString(ch);
            // set flow layout for the frame
            this.getContentPane().setLayout(new FlowLayout());
            JLabel label = new JLabel(s);
            final JTextField tf = new JTextField();
            FontMetrics fm = label.getFontMetrics(label.getFont());
            String text = tf.getText();

            int textWidth = fm.stringWidth(s);
            label.setText("text width for \""+text+"\": " +textWidth);

            // create a line border with the specified color and width
            Border border = BorderFactory.createLineBorder(Color.BLUE);

            // set the border of this component
            label.setBorder(border);
            add(label);
        }
    }

    private static void createAndShowGUI() {

        JFrame frame = new CreateAllCubes();
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }
}
