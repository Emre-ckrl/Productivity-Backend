package cakiral.emre.projects.model;

public class Human {
    public int id;
    public String name;
    public String eyeColor;
    public int eyeCount;
    public String skinColor;
    public String hairColor;
    public int handCount;
    public boolean mature;
    public String gender;
    public int age;

    public Human(int id, String name, String skinColor, String hairColor, String gender) {
        this.id = id;
        this.name = name;
        this.skinColor = skinColor;
        this.hairColor = hairColor;
        this.gender = gender;
    }

    public void grow(){
        age = age +1;
    }

    public void sun(){
        skinColor = "tanned";
    }
}
