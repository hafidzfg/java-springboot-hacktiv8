package com.learning.sax;

public class UserChallenge {
    int id;
    private String firstName;
    private String lastName;

    public UserChallenge() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("user[{]").append(id).append(firstName).append(lastName).append("]");

        return builder.toString();
    }
}
