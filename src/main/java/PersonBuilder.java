public class PersonBuilder implements IPersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String adress;


    public PersonBuilder() {
    }

    public PersonBuilder(String surname, int age, String adress) {
        this.surname = surname;
        this.age = age;
        this.adress = adress;
    }

    public IPersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public IPersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public IPersonBuilder setAge(int age) {
        if (age < 0 || age > 150) throw new IllegalArgumentException("неверный возраст");
        this.age = age;
        return this;
    }

    public IPersonBuilder setAddress(String address) {
        this.adress = address;
        return this;
    }

    public Person build() {
        if (name == null && surname == null) throw new IllegalStateException("Вы не указали имя и фамилию");
        if (name == null) throw new IllegalStateException("Вы не указали имя и фамилию");
        if (surname == null) throw new IllegalStateException("Вы не указали фамилию");
        return new Person(name, surname, age, adress);
    }
}
