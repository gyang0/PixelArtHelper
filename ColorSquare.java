import java.awt.*;

/**
 * The squares with color options.
 *
 * @author Gene Yang
 * @version May 3rd, 2023
 */
public class ColorSquare {
    private Color col;
    private int x;
    private int y;
    private int width;

    public ColorSquare(Color c, int x, int y, int width) {
        this.col = c;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void paint(Graphics g){
        g.setColor(col);
        g.fillRect(x, y, width, width);
    }

    public boolean mouseInside(int mouseX, int mouseY){
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + width;
    }
}
