import java.awt.*;

public class Polygon extends Deq implements Figure {
    private double s, p;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }
    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }
    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        return this;
    }

    @Override
    public void draw(Graphics g) {
        for (int i=length(); i>0; i--) // прорисовывает все точки
        {
            g.fillOval((int)(front().x - 3), - ((int)(front().y + 3)),6,6);// прорисовывает Фронт точку дека
            g.drawLine((int)front().x, - ((int)front().y), (int)back().x, - ((int)back().y)); // прорисовывает линию от Фронт точки до Бэк
            pushFront(popBack()); // меняет Фронт точку на Бэк, то есть так проходит по всем точкам

            g.setColor(Color.RED);  // заданная зона         изменила на *100 для наглядости
            // g.drawOval(-50,-50,100,100);
            //g.drawOval(-200,-200,400,400);
            g.setColor(Color.BLACK);
        }
    }
}
