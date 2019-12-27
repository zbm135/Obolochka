import java.awt.*;

public class Cube
{
    private Facet[] facets;
    double k = -500;

    public Cube()
    {
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0),
                new R3Vector(1,0,0),
                new R3Vector(1,1,0),
                new R3Vector(0,1,0), Color.PINK);
        facets[1] = new Facet(new R3Vector(1,0,1),
                new R3Vector(1,1,1),
                new R3Vector(1,1,0),
                new R3Vector(1,0,0), Color.BLUE);
        facets[2] = new Facet(new R3Vector(0,0,0),
                new R3Vector(0,1,0),
                new R3Vector(0,1,1),
                new R3Vector(0,0,1), Color.YELLOW);
        facets[3] = new Facet(new R3Vector(0,0,0),
                new R3Vector(0,0,1),
                new R3Vector(1,0,1),
                new R3Vector(1,0,0), Color.GRAY);
        facets[4] = new Facet(new R3Vector(0,1,0),
                new R3Vector(1,1,0),
                new R3Vector(1,1,1),
                new R3Vector(0,1,1), Color.GREEN);
        facets[5] = new Facet(new R3Vector(0,0,1),
                new R3Vector(0,1,1),
                new R3Vector(1,1,1),
                new R3Vector(1,0,1), Color.ORANGE);
    }

    public void rotate(double ux, double uy, double uz)
    {
        for (int i = 0; i < 6; i++)
        {
            facets[i].rotate(ux,uy,uz);
        }
    }

    public void translate(double dx, double dy, double dz)
    {
        for (int i = 0; i < 6; i++)
        {
            facets[i].translate(dx,dy,dz);
        }
    }

    public void scale(double m)
    {
        for (int i = 0; i < 6; i++)
        {
            facets[i].scale(m);
        }
    }

    public void draw(Graphics2D g)
    {
        for (int i = 0; i < 6; i++)
        {
            if(facets[i].normal().getZ()<=0)
            {
                facets[i].drawPers(g, k);
            }
        }
        for (int i = 0; i < 6; i++)
        {
            if(facets[i].normal().getZ()>0)
            {
                facets[i].drawPers(g, k);
            }
        }
    }
}
