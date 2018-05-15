package com.inwise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public interface Invoice {
	interface API {
		interface URI {
			String GETBILLS = "invoice/";
		}
	}

	interface Header {
		interface Keys {
			String INVOICES = "serialNumber|recieptHeading|vendorName|vendorAddress|optionalMessage|date|time|invoiceNumber|invoiceType|optionalMessage";

		}
	}

	interface ITEM {
		Integer DEFAULTQUANTITY = 1;
	}

	String CSV_FILE_PATH = "classpath:Bills-Consoliodated.csv";
	String PIPESEPERATOR = "\\|";
	String SEMICOLONSEPERATOR = ";";

	static  Item getItem(String itemString) {
		if (!StringUtils.isEmpty(itemString)) {
			String[] item = itemString.split(PIPESEPERATOR);
			if (item != null && item.length == 3) {
					return Item.builder().name(item[0].trim()).quantity(Integer.valueOf(item[1].trim()))
							.price(Double.valueOf(item[2].trim())).build();
			}
		}
		return null;
	}

	static List<Item> getItems(String itemsString) {
		List<Item> itemList = new ArrayList<>();
		if (!StringUtils.isEmpty(itemsString)) {
			itemsString = itemsString.trim();
			String[] items = itemsString.split(SEMICOLONSEPERATOR);
			if (items != null && items.length > 0) {
				for (int i = 0; i < items.length; i++) {
				itemList.add(getItem(items[i].trim()));
				}
			}
			}

		return itemList;


	}


	}
