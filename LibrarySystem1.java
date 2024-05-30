

package vu.librarysystem1;

import javax.swing.SwingUtilities;

/**
 *
 * @author Mtech Eletronics
 */

public class LibrarySystem1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LibraryGUI gui = new LibraryGUI();
                gui.setVisible(true);
            } catch (Exception e) {
            }
        });
    }
}
