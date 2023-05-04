import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Shows all the components.
 * Initializes the colors and grids.
 *
 * @author Gene Yang
 * @version May 3rd, 2023
 */
public class Grid extends JComponent implements MouseListener {
    private ArrayList<Color> colors;
    private ArrayList<ColorSquare> colorOptions;
    private int selectedCol;
    private GridCell[][] grid;
    private final int GRID_CELL_WIDTH = 20;
    private final int GRID_SIZE = 8;
    private final int COLS_PER_ROW = 8;

    public Grid(){
        selectedCol = 0;
        colors = new ArrayList<Color>();
        colorOptions = new ArrayList<ColorSquare>();

        colors.add(new Color(46, 42, 42)); // Black
        colors.add(new Color(112, 112, 112)); // Dark gray
        colors.add(new Color(168, 2, 2)); // Red
        colors.add(new Color(30, 102, 36)); // Dark green
        colors.add(new Color(91, 235, 103)); // Light green
        colors.add(new Color(107, 46, 16)); // Brown
        colors.add(new Color(95, 115, 230)); // Light blue
        colors.add(new Color(0, 21, 143)); // Dark blue
        colors.add(new Color(44, 0, 133)); // Dark purple
        colors.add(new Color(133, 94, 209)); // Light purple
        colors.add(new Color(255, 255, 255)); // White

        for(int i = 0; i < colors.size(); i++){
            colorOptions.add(new ColorSquare(colors.get(i), 100 + (i % COLS_PER_ROW) * 50, 100 + 50 * (i/COLS_PER_ROW), 30));
        }

        grid = new GridCell[GRID_SIZE][GRID_SIZE];
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++)
                grid[i][j] = new GridCell(200 + i * GRID_CELL_WIDTH, 200 + j * GRID_CELL_WIDTH, GRID_CELL_WIDTH);
        }

        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        for(int i = 0; i < colorOptions.size(); i++){
            colorOptions.get(i).paint(g);
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++)
                grid[i][j].paint(g);
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++) {
                g.setColor(grid[i][j].getCol());
                g.fillRect(400 + i * 5, 400 + j * 5, 5, 5);
            }
        }

        // Outlines
        g.setColor(Color.GRAY);
        for(int i = 0; i < grid.length + 1; i++) g.fillRect(200 + i * GRID_CELL_WIDTH, 200, 1, GRID_CELL_WIDTH * GRID_SIZE);
        for(int i = 0; i < grid.length + 1; i++) g.fillRect(200, 200 + i * GRID_CELL_WIDTH, GRID_CELL_WIDTH * GRID_SIZE, 1);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        for(int i = 0; i < colorOptions.size(); i++){
            if(colorOptions.get(i).mouseInside(e.getX(), e.getY())){
                selectedCol = i;
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j].mouseInside(e.getX(), e.getY())){
                    grid[i][j].setCellColor(colors.get(selectedCol));
                }
            }
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
