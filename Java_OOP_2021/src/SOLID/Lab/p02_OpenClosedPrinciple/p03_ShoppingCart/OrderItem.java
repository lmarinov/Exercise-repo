package SOLID.Lab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class OrderItem {
    private String itemType;
    private int Quantity;

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
