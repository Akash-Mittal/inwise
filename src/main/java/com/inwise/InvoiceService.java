package com.inwise;

import java.io.StringWriter;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Autowired
	private CSVReader csvReader;

	@Autowired
	private VelocityEngine velocityEngine;

	public String getInvoices() {
		InvoiceItems invoiceItems = null;
		final StringWriter writer = new StringWriter();
		List<InvoiceItem> invoiceList = csvReader.getInvoiceItemList();
		if (!CollectionUtils.isEmpty(invoiceList)) {
			invoiceItems = new InvoiceItems();
			invoiceItems.setInvoiceList(invoiceList);
			Template template = velocityEngine.getTemplate("templates/invoice-style-1.vm");

			invoiceList.stream().forEachOrdered(invoiceItem -> {
				VelocityContext context = new VelocityContext();
				context.put("recieptHeading", invoiceItem.getRecieptHeading());
				context.put("vendorName", invoiceItem.getVendorName());
				context.put("vendorAddress" + "", invoiceItem.getVendorName());
				context.put("optionalWelcomeMessage" + "", invoiceItem.getVendorName());
				context.put("date", invoiceItem.getVendorName());
				template.merge( context, writer );

			});

		}

		 return (writer == null)?  null : writer.toString();

	}
}
