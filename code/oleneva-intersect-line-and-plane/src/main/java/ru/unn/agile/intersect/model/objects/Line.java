package ru.unn.agile.intersect.model.objects;

public final class Line {
    private Point pointX, pointY;

    public Line(final Point pointA1, final Point pointB1) {
        this.pointX = pointA1;
        this.pointY = pointB1;
    }

    public Point getX() {
        return this.pointX;
    }

    public Point getY() {
        return this.pointY;
    }
}
