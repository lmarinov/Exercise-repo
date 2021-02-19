package IteratorsAndComperators.Exercies.EqualityLogic;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return this.getAge() == person.getAge()
                && this.getName().equals(((Person) obj).getName());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 71 * hash + (this.getName() == null ? 0 : this.getName().hashCode());
        hash = 71 * hash + (this.getAge() == 0 ? 0 : this.getName().hashCode());
        return hash;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int result = this.getName().compareTo(otherPerson.getName());
        if (result == 0){
            result = Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return result;
    }
}
