package Model;
//Order: String orderId, List<OrderItem> items, String customerId

import java.util.List;

public class Order {
    private  String orderId;
    private  List<OrderItem> item;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", item=" + item +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    public Order(String orderId, List<OrderItem> item, String customerId) {
        this.orderId = orderId;
        this.item = item;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getItem() {
        return item;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private  String customerId;

}
