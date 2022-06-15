import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }


    public Person(String name, String surname, OptionalInt age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age != null;
    }


    public boolean hasAddress() {
        return city != null;
    }

    @Override
    public String toString() {
        if (!hasAge() && !hasAddress()) {
            return name + " " + surname + " (возраст неизвестен" + ", место жительства неизвестно)";
        }
        if (!hasAge() && hasAddress()) {
            return name + " " + surname + " (возраст неизвестен, " + city + ")";
        }
        if (hasAge() && !hasAddress()) {
            return name + " " + surname + " (" + age.getAsInt() + ", место жительства неизвестно)";
        }
        return name + " " + surname + " (" + age.getAsInt() + ", " + city + ")";

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return age;
        }
        return OptionalInt.empty();
    }

    public void setAge(int age) throws RuntimeException {
        if (hasAge()) {
            throw new RuntimeException("Возраст уже указан");
        }
        this.age = OptionalInt.of(age);
    }

    public String getCity() {
        if (hasAddress()) {
            return city;
        }
        return null;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            int intAge = age.getAsInt();
            intAge++;
            age = OptionalInt.of(intAge);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname);
    }
}
