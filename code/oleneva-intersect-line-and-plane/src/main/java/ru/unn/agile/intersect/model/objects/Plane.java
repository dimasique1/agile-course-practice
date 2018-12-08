package ru.unn.agile.intersect.model.objects;

public final class Plane {
    private Point pointA, pointB, pointC;

    public Plane(final Point pointA1, final Point pointB1, final Point pointC1) {
        this.pointA = pointA1;
        this.pointB = pointB1;
        this.pointC = pointC1;
    }

    public Point getA() {
        return this.pointA;
    }

    public Point getB() {
        return this.pointB;
    }

    public Point getC() {
        return this.pointC;
    }

    public Point countNormalToPlane() {
        Point pointTmp1 = this.pointB.createVector(this.pointA);
        Point pointTmp2 = this.pointC.createVector(this.pointA);
        Point pointTmp = pointTmp1.vectorProduct(pointTmp2);
        return pointTmp.normalizePoint();
    }

    public double countToNormalDistance(final Line lineL) {
        Point vectorV = this.getA().createVector(lineL.getX());
        Point normalN = this.countNormalToPlane();

        return normalN.scalarProduct(vectorV);
    }
}
