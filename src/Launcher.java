import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.SwingUtilities;

public class Launcher {
    //public static MainWindow MAIN_WINDOW;
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           @Override
           public void run() {
               MainWindow main = new MainWindow();
               main.show();
           }
       });

        /**
         * howto networking with swing:
         * - have a thread that reads from the socket
         * while (true) {
         *     Packet packet = read_from_socket ();
         *     SwingUtilities.invokeLater (new Runnable() {
         *          public void run () {
         *              handle_network_packet (packet);
         *              main_window.update
         *          }
         *     });
         * }
         */
    }
}
