package Encapsulation.Exercise.P02AnimalFarm;

public class Chicken {
// - name: String
//-	age: int

    private String name;
    private int age;

//+	Chicken(String, int)

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

//-	setName(String) : void
//-	setAge (int): void

    private void setName(String name) {
        if (hasName(name)){
            this.name = name;
        }else{
            throw new IllegalStateException("Name cannot be empty.");
        }
    }

    private boolean hasName(String name) {
        return name.trim().length() > 0;
    }

    private void setAge(int age) {
        if (isInRange(age)) {
            this.age = age;
        } else {
            throw new IllegalStateException("Age should be between 0 and 15.");
        }
    }

    private boolean isInRange(int age) {
        return age >= 0 && age <= 15;
    }


//+	productPerDay (): double

    public double productPerDay(){
        return calculateProductPerDay();
    }
//+	toString(): Override

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name,
                this.age,
                this.productPerDay());
    }


//-	calculateProductPerDay() : double

    private double calculateProductPerDay(){
        if (this.age < 6){
            return 2.00;
        }else if(this.age < 12){
            return 1.00;
        }else{
            return 0.75;
        }
    }

}
