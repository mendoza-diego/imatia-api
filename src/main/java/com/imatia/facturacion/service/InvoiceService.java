package com.imatia.facturacion.service;

import com.imatia.facturacion.entities.Invoice;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class InvoiceService {
    EntityManager entityManager;

    public InvoiceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public long saveInvoice(Invoice invoice){
        entityManager.persist(invoice);
        return invoice.getId();
    }
}
