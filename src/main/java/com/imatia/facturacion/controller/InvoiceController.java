package com.imatia.facturacion.controller;

import com.imatia.facturacion.InvoiceNotFoundException;
import com.imatia.facturacion.entities.Invoice;
import com.imatia.facturacion.entities.InvoiceItem;
import com.imatia.facturacion.repository.InvoiceItemRepository;
import com.imatia.facturacion.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemRepository invoiceItemRepository;

    InvoiceController(InvoiceRepository invoiceRepository, InvoiceItemRepository invoiceItemRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceItemRepository = invoiceItemRepository;
    }

    @GetMapping("/invoices")
    List<Invoice> allInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoices/{id}/items")
    List<InvoiceItem> allItems(@PathVariable Long id) {
        return invoiceRepository.findById(id).map(i -> i.getItems())
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    @GetMapping("/invoices/{id}")
    Invoice one(@PathVariable Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    @PostMapping("/invoices")
    Long newInvoice(@RequestBody Invoice newInvoice) {
        if (newInvoice.getItems() != null && newInvoice.getItems().size() > 0) {
            for (InvoiceItem item : newInvoice.getItems()) {
                invoiceItemRepository.save(item);
            }
        }

        return invoiceRepository.saveAndFlush(newInvoice).getId();
    }

    @PutMapping("/invoices/{id}")
    Invoice replaceInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
        return invoiceRepository.findById(id)
            .map(i -> {
                i.setCustomer(invoice.getCustomer());
                i.setDate(invoice.getDate());
                i.setSubtotal(invoice.getSubtotal());
                i.setIva(invoice.getIva());
                i.setTotal(invoice.getTotal());
                i.setItems(invoice.getItems());
                return invoiceRepository.save(invoice);
            })
            .orElseGet(() -> {
                return invoiceRepository.save(invoice);
            });
    }

    @DeleteMapping("/invoices/{id}")
    void deleteInvoice(@PathVariable Long id) {
        invoiceRepository.deleteById(id);
    }
}