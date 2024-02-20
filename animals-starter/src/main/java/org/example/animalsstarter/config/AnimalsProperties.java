package org.example.animalsstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(value = "animals")
public class AnimalsProperties {

    private List<String> dogNames;
    private List<String> catNames;
    private List<String> sharkNames;
    private List<String> wolfNames;

    public List<String> getDogNames() {
        return dogNames;
    }

    public void setDogNames(List<String> dogNames) {
        this.dogNames = dogNames;
    }

    public List<String> getCatNames() {
        return catNames;
    }

    public void setCatNames(List<String> catNames) {
        this.catNames = catNames;
    }

    public List<String> getSharkNames() {
        return sharkNames;
    }

    public void setSharkNames(List<String> sharkNames) {
        this.sharkNames = sharkNames;
    }

    public List<String> getWolfNames() {
        return wolfNames;
    }

    public void setWolfNames(List<String> wolfNames) {
        this.wolfNames = wolfNames;
    }
}
