package com.imatia.facturacion.repository;

import com.imatia.facturacion.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}