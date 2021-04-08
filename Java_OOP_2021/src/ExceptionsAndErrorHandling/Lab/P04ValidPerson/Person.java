package ExceptionsAndErrorHandling.Lab.P04ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) throws InvalidPersonNameException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    private void setFirstName(String firstName) {
        validateStringField(firstName, "first");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        validateStringField(lastName, "last");
        this.lastName = lastName;
    }

    private void setAge(int age) throws InvalidPersonNameException {
        if (age < 0 || age > 120){
            throw new InvalidPersonNameException("Age should be in the range [0...120]");
        }
        this.age = age;
    }

    private void validateStringField(String str, String fieldName){
        if (str == null || str.trim().isEmpty()){
            throw new IllegalArgumentException(String.format("The %s name cannot be null or empty", fieldName));
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }
}
