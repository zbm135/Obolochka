import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame
{
    private Cube cube;
    protected static int width = 500;
    protected static int height = 500;

    Viewer(Cube c)
    {
        super("CUBE");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        cube = c;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle s = this.getBounds();

        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(s.width/2, 0, s.width/2, s.height);
        g.drawLine(0, s.height/2, s.width, s.height/2);
        g.translate(s.width/2, s.height/2);

        cube.draw(g2d);
    }
}
