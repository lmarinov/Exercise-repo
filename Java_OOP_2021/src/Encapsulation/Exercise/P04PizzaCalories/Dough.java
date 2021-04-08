package Encapsulation.Exercise.P04PizzaCalories;

public class Dough {

//    -	flourType: String
//-	bakingTechnique: String
//-	weight: double

    private String flourType;
    private String bakingTechnique;
    private double weight;

//+ 	Dough (String, String, double)

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

//-	setWeight(double): void
//-	setFlourType(String): void
//-	setBakingTechnique(String): void

    private void setFlourType(String flourType) {
        if (!"White".equals(flourType)
                && !"Wholegrain".equals(flourType)){
            throw new IllegalStateException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique)
        && !"Chewy".equals(bakingTechnique)
        && !"Homemade".equals(bakingTechnique)){
            throw new IllegalStateException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

//+	calculateCalories (): double

    public double calculateCalories(){
        return this.weight * 2 * this.getModifierByBakingTechnique() * this.getModifierByFlourType();
    }

    private double getModifierByFlourType() {
        switch (this.flourType){
            case "White": return 1.5;
            case "Wholegrain": return 1.0;
            default: return  0.0;
        }
    }

    private double getModifierByBakingTechnique() {
        switch (this.bakingTechnique){
            case "Crispy": return 0.9;
            case "Chewy": return 1.1;
            case "Homemade": return 1.0;
            default: return  0.0;
        }
    }
}
