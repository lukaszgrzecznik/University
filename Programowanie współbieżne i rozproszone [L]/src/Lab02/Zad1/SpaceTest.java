package Lab02.Zad1;

public class SpaceTest {
    public static void main(String[] args) {
        Space2D p1 = new Space2D(0, 0);
        Space2D p2 = new Space2D(1, 1);
        System.out.println("Odległość między p1 a p2: " + p1.distanceTo(p2));
        System.out.println("Odległość p1 od punktu (0,0): " + p1.distanceToOrigin());

        Space3D p3 = new Space3D(1, 2, 3);
        Space3D p4 = new Space3D(4, 5, 6);
        System.out.println("Odległość między p3 a p4: " + p3.distanceTo(p4));
        System.out.println("Odległość p3 od punktu (0,0,0): " + p3.distanceToOrigin());
    }
}

