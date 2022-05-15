package com.imatia.facturacion;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(Long id) {
        super("Could not find invoice " + id);
    }
}