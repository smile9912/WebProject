package edu.xhu.pojo;

public class Product {
    private String id;
    private String name;
    private String kind;
    private Integer price;
    private String img;
    private String description;

    public Product() {
    }

    public Product(String id, String name, String kind, Integer price, String img, String description) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.img = img;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
