package Lab02.Zad1;

class Space3D extends Space2D {
    private double z;

    public Space3D() {
        super();
        this.z = 0;
    }

    public Space3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    public double distanceTo(Space3D other) {
        return Math.sqrt(Math.pow(getX() - other.getX(), 2) + Math.pow(getY() - other.getY(), 2) + Math.pow(this.z - other.z, 2));
    }

    public double distanceToOrigin() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    public static double trianglePerimeter(Space3D a, Space3D b, Space3D c) {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    public static double triangleArea(Space3D a, Space3D b, Space3D c) {
        double s = trianglePerimeter(a, b, c) / 2;
        double side1 = a.distanceTo(b);
        double side2 = b.distanceTo(c);
        double side3 = c.distanceTo(a);
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
