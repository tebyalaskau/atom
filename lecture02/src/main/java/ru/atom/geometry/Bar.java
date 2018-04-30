package ru.atom.geometry;

public class Bar implements Collider{
    private int x1;
    private int y1;
    private int x2;
    private int y2;



    public Bar(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        // cast from Object to Point
        Bar b = (Bar) o;

        if(x1 == b.x2 && x2 == b.x1)
            return true;

        return x1 == b.x1 && y1 == b.y1 && x2 == b.x2 && y2 == b.y2;

    }

    @Override
    public boolean isColliding(Collider other) {
        if (this == other) return true;

        if (other instanceof Point) {
            Point p = (Point) other;
            //pointCollision
            if(p.getX() >= x1 && p.getX() <= x2 && p.getY() >= y1 && p.getY() <= y2) {
                System.out.printf("yes");
                return true;
            }
            return false;
        }

       // if (other instanceof Bar)
        Bar b = (Bar) other;




        // параметры отрезков
        float a1 = y1 - y2;
        float b1 = x2 - x1;
        float a2 = b.y1 - b.y2;
        float b2 = b.x2 - b.x1;

// координаты точки пересечения
        float d = a1 * b2 - a2 * b1;

        if ( d != 0 ){
            System.out.printf("d!=0");
            float c1 = y2 * x1 - x2 * y1;
            float c2 = b.y2 * b.x1 - b.x2 * b.y1;

            float xi = (b1 * c2 - b2 * c1) / d;
            float yi = (a2 * c1 - a1 * c2) / d;

            System.out.printf("x " + xi + " " + "y " + yi + "!    ");

            return true;
        }
        if(((y2 - y1)/(x2 - x1) == ((b.y2 - b.y1)/(b.x2 - b.x1)))){
            System.out.printf("паралельны или на одной прямой ");

                if((y1 - ((y2 - y1)/(x2 - x1))*x1) == (b.y1 - ((b.y2 - b.y1)/(b.x2 - b.x1))*b.x1)){
                    if ((((x1 >= b.x1) && (x1 <= b.x2)) || ((b.x1 >= x1) && (b.x1 <= x2)))) {

                        System.out.printf("на одной прямой ");
                        return true;
                    }
            }
            System.out.printf("паралельны ");
            return false;

        }

            return false;

    }
}
