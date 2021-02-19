package DefiningClasses.Exercise.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> children = new ArrayList<>();
    private List<Person> parents = new ArrayList<>();

    public Person(){
        this(null, null);
    }

    public Person(String info){
        if (info.matches("^(\\d+/\\d+/\\d+)$")){
            this.birthday = info;
            this.name = null;
        }else{
            this.name = info;
            this.birthday = null;
        }
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void addChildren(Person child) {
        this.children.add(child);
    }

    public void addParents(Person parent) {
        this.parents.add(parent);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getBirthday());
    }
}
