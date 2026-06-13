
package ANU;

import javax.swing.*;
import java.sql.Connection;
/**
 *
 * @author kirom
 */
public class Test {

  

    public static void main(String[] args) {
                new DB();  

try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Failed to set look and feel: " + e.getMessage());
        }
        try {
            SwingUtilities.invokeLater(() -> {
                new LoginSchool().setVisible(true);
            });
        } catch (Exception e) {
            System.err.println("Application failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
