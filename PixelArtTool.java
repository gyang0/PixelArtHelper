import javax.swing.*;
import java.awt.*;


/**
 * Main class
 * 
 * @author Gene Yang
 * @version May 3rd, 2023
 */
public class PixelArtTool {
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private Grid grid;

    public void run() {
        JFrame window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        grid = new Grid();
        window.add(grid, BorderLayout.CENTER);
        window.setVisible(true);
    }

    public static void main(String[] args){
        new PixelArtTool().run();
    }
}
