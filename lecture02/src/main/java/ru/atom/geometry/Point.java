package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements  Collider{

    private int x;
    private int y;

    public int getX() {
      return this.x;
   }

    public int getY() {
        return this.y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;
        return x == point.x && y == point.y;

    }

    @Override
    public boolean isColliding(Collider other) {
        if (this == other) return true;

        Point pOther = (Point) other;

        if ((this.getX() == pOther.getX()) && (this.getY()==pOther.getY())) {
            return true;
        }


        return false;

    }
}



