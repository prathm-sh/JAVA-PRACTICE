package Model;
//Transaction: String id, double amount, String currency, Type type (enum: DEBIT, CREDIT), LocalDate date

import java.time.LocalDate;

public class Transaction {

    private String id;
    private double amount;
    private String currency;
    private Type type;
    private LocalDate date;

    // Default Constructor
    public Transaction() {
    }

    // Parameterized Constructor
    public Transaction(String id, double amount, String currency,
                       Type type, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.date = date;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", date=" + date +
                '}';
    }
}