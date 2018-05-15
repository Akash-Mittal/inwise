package com.inwise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {
@Autowired
private InvoiceService invoiceService;

	@GetMapping(value = "/get")
	public String getInvoices() {
		return invoiceService.getInvoices();
	}
}
