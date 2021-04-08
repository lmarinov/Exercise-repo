package Polymorphism.Lab.P02Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (getPerimeter() == null){
            double perimeter = this.radius * 2 * Math.PI;
            setPerimeter(perimeter);
        }
        return getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (getArea() == null){
            double area = this.radius * this.radius * Math.PI;
            setArea(area);
        }
        return getArea();
    }
}
