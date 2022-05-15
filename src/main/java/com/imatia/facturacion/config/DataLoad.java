package com.imatia.facturacion.config;

import com.imatia.facturacion.entities.Invoice;
import com.imatia.facturacion.entities.InvoiceItem;
import com.imatia.facturacion.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataLoad {

    private static final Logger log = LoggerFactory.getLogger(DataLoad.class);

//    @Bean
//    CommandLineRunner initDatabase(InvoiceRepository repository) {
//
//        InvoiceItem[] invoiceItems = new InvoiceItem[2];
//        invoiceItems[0] = new InvoiceItem("A3455", "Silla de oficina", 2, 45d, 10d);
//        invoiceItems[1] = new InvoiceItem("B6112", "Mesa", 1, 120d, 10d);
//        Invoice invoice = new Invoice(2L, "Ramón Bassol", new Date(), 30D, 2.56D, 30D, invoiceItems);
//
//        return args -> {
//            log.info("Preloading " + repository.save(invoice));
//        };
//    }
}
