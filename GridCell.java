import java.awt.*;

/**
 * The grid to color in.
 *
 * @author Gene Yang
 * @version May 3rd, 2023
 */
public class GridCell {
    private int x;
    private int y;
    private int width;
    private Color col;

    public GridCell(int x, int y, int width){
        this.col = new Color(255, 255, 255);
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void setCellColor(Color c){
        this.col = c;
    }

    public Color getCol(){
        return this.col;
    }

    public void paint(Graphics g){
        g.setColor(col);
        g.fillRect(x, y, width, width);
    }

    public boolean mouseInside(int mouseX, int mouseY){
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + width;
    }
}
