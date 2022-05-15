package com.imatia.facturacion.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class Invoice {
    private @Id @GeneratedValue Long id;
    private String customer;
    private Date date;
    private double subtotal;
    private double iva;
    private double total;
    @OneToMany
    private List<InvoiceItem> items;

    public Invoice() {}

    public Invoice(Long id, String customer, Date date) {
        this.id = id;
        this.customer = customer;
        this.date = date;
    }

    public Invoice(Long id, String customer, Date date, double subtotal, double iva, double total, List<InvoiceItem> items) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Invoice))
            return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(this.id, invoice.id) && Objects.equals(this.customer, invoice.customer) && Objects.equals(this.date, invoice.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.customer, this.date);
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + this.id + ", customer='" + this.customer + '\'' + ", date='" + this.date + '\'' + ", subtotal='" + this.subtotal + '\'' + ", iva='" + this.iva + '\'' + ", total='" + this.total + '\'' + '}';
    }
}
