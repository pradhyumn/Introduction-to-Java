
public class SquarePyramid {
    private static int nextId = 1;
    private int id;
    private double side;
    private double height;

    public SquarePyramid() {}

    public SquarePyramid(double side, double height) {
        this.side = side;
        this.height = height;
        this.id = nextId;
        nextId++;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return (1.0/3) * Math.pow(this.getSide(), 2) * this.height;
    }

    public double getSurfaceArea() {
        double squareArea = Math.pow(this.getSide(), 2);
        return squareArea + 2 * this.getSide() * Math.sqrt(squareArea/4 + Math.pow(this.getHeight(), 2));
    }

    public int getID() {
        return id;
    }

    public static void main(String argc[]) {
        SquarePyramid sq1 = new SquarePyramid(1.2, 1.3);
        SquarePyramid sq2 = new SquarePyramid(1.2, 1.3);
        SquarePyramid sq3 = new SquarePyramid(1.2, 1.3);
        System.out.println("ID: of first square: " + sq1.getID());
        System.out.println("ID: of second square: " + sq2.getID());
        System.out.println("ID: of third square: " + sq3.getID());
        System.out.println("Volume of first square: " + sq1.getVolume());
        System.out.println("Surface area of first square: " + sq1.getSurfaceArea());
    }
}
