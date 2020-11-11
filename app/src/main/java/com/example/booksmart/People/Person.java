package com.example.booksmart.People;

public class Person {

    String firstName, lastName;
    String fullName;

    public Person(String name) {

        String[] nameParts = name.split(" ");

        this.firstName = "";
        this.lastName = "";

        switch (nameParts.length) {
            case 0:
                throw new IllegalArgumentException();
            case 1:
                this.lastName = nameParts[0];
                break;
            case 2:
                this.firstName = nameParts[0];
                this.lastName = nameParts[1];
                break;
            default:
                this.firstName = nameParts[0];
                for(int i=1;i<nameParts.length;i++){
                    this.lastName += nameParts[i];
                }
        }
    }

    public Person(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;


        fullName = this.firstName + " " + this.lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public int hashCode() {
        return (firstName.hashCode() * 100) + lastName.hashCode() * 23;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person))
            return false;
        if (o.hashCode() == this.hashCode())
            return true;
        Person toCompare = (Person) o;

        return fullName.contains((toCompare.getFullName())) || fullName.contains(toCompare.getFirstName())
                || fullName.contains(toCompare.getLastName());

    }
}
