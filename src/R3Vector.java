public class R3Vector
{
    private double x,y,z;

    public R3Vector(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void out()
    {
        System.out.println("(" + x + ", "+ y +  ", " + z + ")" );
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public R3Vector sum(R3Vector a)
    {
        return new R3Vector(a.x + x,a.y + y,a.z + z);
    }

    public static R3Vector sum(R3Vector a, R3Vector b)
    {
        return new R3Vector(a.x + b.x,a.y + b.y,a.z + b.z);
    }

    public void scale(double m)
    {
        x = x*m;
        y = y*m;
        z = z*m;
    }

    public void translate(double dx, double dy, double dz)
    {
        x += dx;
        y += dy;
        z += dz;
    }
    public static double scalPr(R3Vector a, R3Vector b)
    {
        return a.x*b.x + a.y*b.y + a.z*b.z;
    }

    public static R3Vector vectPr(R3Vector a, R3Vector b)
    {
        return new R3Vector(a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
    }
    public void rotateZ(double u)// градусы
    {
        u = Math.toRadians(u);
        double xr = x*Math.cos(u)-y*Math.sin(u);
        double yr = x*Math.sin(u)+y*Math.cos(u);
        x = xr;
        y = yr;
    }

    public void rotateY(double u)
    {
        u = Math.toRadians(u);
        double zr = z*Math.cos(u)-x*Math.sin(u);
        double xr = z*Math.sin(u)+x*Math.cos(u);
        z = zr;
        x = xr;
    }

    public void rotateX(double u)
    {
        u = Math.toRadians(u);
        double yr = y*Math.cos(u)-z*Math.sin(u);
        double zr = y*Math.sin(u)+z*Math.cos(u);
        y = yr;
        z = zr;
    }

    public void rotate(double ux, double uy, double uz) //
    {
        this.rotateZ(uz);
        this.rotateX(ux);
        this.rotateY(uy);
    }
}
