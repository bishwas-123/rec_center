package model;
public class RecResouces {
    private int id;
    private String title;
    private String category;
    private int quantity;
    private String description;

    public RecResouces(int id, String title, String category, int quantity, String description) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
    }

    public RecResouces() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
