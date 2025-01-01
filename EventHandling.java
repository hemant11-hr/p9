import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandling {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Event Handling Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a button and add ActionListener
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button clicked!"));
        frame.add(button);

        // Create a text field and add KeyListener
        JTextField textField = new JTextField(20);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(frame, "Enter key pressed. You typed: " + textField.getText());
                }
            }
        });
        frame.add(textField);

        // Create a panel to capture mouse events
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 100));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.LIGHT_GRAY);
            }
        });
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);
    }
}
