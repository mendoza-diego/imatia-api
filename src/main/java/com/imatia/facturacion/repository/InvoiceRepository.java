package com.imatia.facturacion.repository;

import com.imatia.facturacion.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}