package Encapsulation.Exercise.P01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(){

    }

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isPositive(length)){
            this.length = length;
        }else{
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

    }

    private void setWidth(double width) {
        if (isPositive(width)){
            this.width = width;
        }else{
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (isPositive(height)){
            this.height = height;
        }else{
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    private boolean isPositive(double measurement) {
        return measurement > 0;
    }

    public double calculateSurfaceArea(){
        return 2 * this.width * this.length + 2 * this.length * this.height + 2 * this.height * this.width;
    }

    public double calculateVolume(){
        return this.height * this.length * this.width;
    }

    public double calculateLateralSurfaceArea(){
        return 2 * this.length * this.height + 2 * this.height * this.width;
    }
}
