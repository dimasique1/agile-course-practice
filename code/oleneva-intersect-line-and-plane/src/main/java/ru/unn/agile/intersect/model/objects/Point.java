package ru.unn.agile.intersect.model.objects;

public final class Point {
    private double coordinateX, coordinateY, coordinateZ;

    public Point(final double x1, final double y1, final double z1) {
        this.coordinateX = x1;
        this.coordinateY = y1;
        this.coordinateZ = z1;
    }

    public double getX() {
        return this.coordinateX;
    }

    public double getY() {
        return this.coordinateY;
    }

    public double getZ() {
        return this.coordinateZ;
    }

    public Point createVector(final Point pointA) {
        double x = this.getX() - pointA.getX();
        double y = this.getY() - pointA.getY();
        double z = this.getZ() - pointA.getZ();

        return new Point(x, y, z);
    }

    public Point vectorProduct(final Point pointA) {
        double x = this.getY() * pointA.getZ() - this.getZ() * pointA.getY();
        double y = -1 * (this.getX() * this.getZ() - this.getZ() * pointA.getX());
        double z = this.getX() * pointA.getY() - this.getY() * pointA.getX();
        return new Point(x, y, z);
    }

    public double scalarProduct(final Point pointA) {
        double scalarProduct = pointA.getX() * this.getX();
        scalarProduct += pointA.getY() * this.getY() + pointA.getZ() * this.getZ();

        return scalarProduct;
    }

    public Point normalizePoint() {
        double nor = Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2);
        nor = Math.sqrt(nor);
        return new Point(this.getX() / nor, this.getY() / nor, this.getZ() / nor);
    }

}
