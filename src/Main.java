import com.sun.jdi.connect.Connector;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Cube c = new Cube();
        c.scale(100);
        c.translate(-50,-50,0);
        c.rotate(0,0,0);
        Viewer v = new Viewer(c);
    }
}
