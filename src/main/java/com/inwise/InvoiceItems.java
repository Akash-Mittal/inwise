package com.inwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class InvoiceItems {

	private List<InvoiceItem> invoiceList;

	public List<InvoiceItem> getInvoiceList() {
		if(CollectionUtils.isEmpty(invoiceList)) {
			invoiceList = new ArrayList<>();
		}
		return Collections.unmodifiableList(new ArrayList<>(invoiceList));
	}

	public void setInvoiceList(List<InvoiceItem> invoiceList) {
		this.invoiceList = invoiceList;
	}


}
