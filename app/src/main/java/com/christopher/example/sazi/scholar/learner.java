package com.christopher.example.sazi.scholar;

public class learner {
    String name;
    String country;
    String badgeUrl;

    @Override
    public String toString() {
        return "learner{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }



    public learner() {
    }

    public learner(String name, String country, String badgeUrl) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }


}
