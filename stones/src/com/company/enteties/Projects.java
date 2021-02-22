package com.company.enteties;



public class Projects {
    private int id;
    private String name;
    private int price;
    private int id_gen=0;

    public Projects(){
        id_gen++;
    }


    public Projects(String name, int price) {
        this.price = price;
        this.name = name;
    }


    public Projects(int id, String name, int price ) {
        setId(id);
        setName(name);
        setPrice(price);
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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String toString() {
        return "Projects{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
