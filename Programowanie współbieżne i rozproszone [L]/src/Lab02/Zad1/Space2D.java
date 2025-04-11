package Lab02.Zad1;

class Space2D {
    private double x, y;

    public Space2D() {
        this.x = 0;
        this.y = 0;
    }

    public Space2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX()
        { return x; }
    public double getY()
        { return y; }
    public void setX(double x)
        { this.x = x; }
    public void setY(double y)
        { this.y = y; }

    public double distanceTo(Space2D other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public double distanceToOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double trianglePerimeter(Space2D a, Space2D b, Space2D c) {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    public static double triangleArea(Space2D a, Space2D b, Space2D c) {
        double s = trianglePerimeter(a, b, c) / 2;
        double side1 = a.distanceTo(b);
        double side2 = b.distanceTo(c);
        double side3 = c.distanceTo(a);
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void display() {
        System.out.printf("Punkt: (%f, %f)", x, y);
    }
}
