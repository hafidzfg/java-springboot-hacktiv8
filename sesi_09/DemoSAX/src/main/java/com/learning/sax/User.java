package com.learning.sax;

public class User {
    int id;
    private String name;
    private String gender;
    private String role;
    private String country;
    private String planet;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("user{").append("id=").append(id).append(", name=").append(name).append(", gender=")
                .append(gender).append(", role=").append(role).append(", country=").append(country).append(", planet=")
                .append(planet).append("}");

        return builder.toString();
    }

}
