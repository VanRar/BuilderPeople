import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String adress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String adress) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean hasAge() {
        return age == -1 ? false : true;
    }

    public boolean hasAddress() {
        return (adress == null) ? false : true;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public void happyBirthday() {
        if (hasAge()) this.age += 1;
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder(this.surname, 0, this.adress);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (hasAge() ? age : "возраст неизвестен") +
                ", adress='" + (hasAddress() ? adress : "место проживания неизвестно") + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(adress, person.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, adress);
    }
}
