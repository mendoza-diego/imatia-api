package com.imatia.facturacion.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class InvoiceItem {
    private @Id @GeneratedValue Long id;
    private String code;
    private String description;
    private int qty;
    private double price;
    private double iva;

    public InvoiceItem() {}

    public InvoiceItem(Long id, String code, String description, int qty, double price, double iva, Invoice invoice) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.iva = iva;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof InvoiceItem))
            return false;
        InvoiceItem invoiceItem = (InvoiceItem) o;
        return Objects.equals(this.id, invoiceItem.id) && Objects.equals(this.code, invoiceItem.code) && Objects.equals(this.description, invoiceItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.code, this.description);
    }

    @Override
    public String toString() {
        return "InvoiceItem{" + "id=" + this.id + ", code='" + this.code + '\'' + ", description='" + this.description + '\'' + ", qty='" + this.qty + '\'' + ", price='" + this.price + '\'' + ", iva='" + this.iva + '\'' + '}';
    }
}
