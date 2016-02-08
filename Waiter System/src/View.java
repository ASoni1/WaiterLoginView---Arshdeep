import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * This is the View class for the Login Page that the Waiters see when the first open the system. 
 * They are required to login in order to access any of the data such as tables, orders etc. 
 * Each waiter is assigned a Username and a Password and these passwords are stored in a database. 
 * If the entered username and password is equal to the ones retrieved from the database, 
 * it will allow access into the system. 
 * Otherwise it will deny access and produce an error message. 
 * 
 * @author Arshdeep Soni.
 *
 */

@SuppressWarnings("serial")
public class View extends JFrame {

  private JPanel contentPane;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private static View frame;
  private static String username = "team";
  private static String password = "project";

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    frame = new View();
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame.setVisible(true);
          frame.setResizable(false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public View() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    /**
     * Panel to contain all of the items. 
     */
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    panel.setLayout(null);
   
    /**
     * Username label. Allows the user to enter details in
     * the right text box. 
     */
    JLabel usernameLabel = new JLabel("Username: ");
    usernameLabel.setBounds(110, 105, 77, 16);
    panel.add(usernameLabel);
    
    /**
     * Password label. Allows the user to enter details in
     * the right text box. 
     */
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(110, 133, 68, 16);
    panel.add(passwordLabel);
    
    /**
     * Username field where the user enters their username to login. 
     */
    usernameField = new JTextField();
    usernameField.setBounds(181, 100, 130, 26);
    panel.add(usernameField);
    usernameField.setColumns(10);
    
    /**
     * Title that states it is the Waiter Login view. 
     */
    JLabel waiterLabel = new JLabel("Waiter Login");
    waiterLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    waiterLabel.setHorizontalAlignment(SwingConstants.CENTER);
    waiterLabel.setBounds(110, 16, 185, 43);
    panel.add(waiterLabel);
   
    /**
     * Hidden lable that has no value. 
     * This is used for success or error messages. 
     */
    JLabel messageLabel = new JLabel("");
    messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    messageLabel.setBounds(81, 233, 264, 16);
    panel.add(messageLabel);
    
    /**
     * Login button used to submit the data. 
     */
    JButton btnLogin = new JButton("Login");
    btnLogin.setBounds(160, 192, 117, 29);
    btnLogin.setForeground(Color.WHITE);
    btnLogin.setBackground(Color.BLACK);
    btnLogin.setOpaque(true);
    btnLogin.setBorderPainted(false);
    
    /**
     * Password field where the user enters their password. 
     */
    passwordField = new JPasswordField();
    passwordField.setBounds(181, 128, 130, 26);
    panel.add(passwordField);
    
    /**
     * Listener for the login button. 
     * Currently this is a stub method such that it only produces error messages
     * based on the current hard coded values. 
     */
    btnLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          String pass = String.valueOf(passwordField.getPassword());
          if (!(usernameField.getText().equals(username) && pass.equals(password))) {
            messageLabel.setText("Username and Password incorrect!");
          } else {
            try {
              messageLabel.setText("Success!");
            } catch (Exception exception) {
              exception.printStackTrace();
            }
          }
        }
    });
    panel.add(btnLogin);
    
  }
}
