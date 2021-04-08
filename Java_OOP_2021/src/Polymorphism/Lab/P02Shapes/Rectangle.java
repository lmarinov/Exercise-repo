package Polymorphism.Lab.P02Shapes;

public class Rectangle extends Shape{
    private Double width;
    private Double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return this.width;
    }

    public Double getHeight() {
        return this.height;
    }

    @Override
    public Double calculatePerimeter() {
        if (getPerimeter() == null){
            double perimeter = this.width * 2 + 2 * this.height;
            setPerimeter(perimeter);
        }
        return getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (getArea() == null){
            double area = this.width * this.height;
            setArea(area);
        }
       return getArea();
    }
}
