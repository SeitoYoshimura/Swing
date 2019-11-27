public class Product {
    private int productId;
    private String name;
    private int amount;
    private String description;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.getProductId()+","+this.getAmount()+","+this.getDescription();
    }
}
