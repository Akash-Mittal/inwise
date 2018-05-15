package com.inwise;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@SuppressWarnings("unused")
@Builder
@ToString
public class InvoiceItem {

	private String recieptHeading;
	private String vendorName;
	private String vendorAddress;
	private String optionalWelcomeMessage;
	private String date;
	private String time;
	private List<Item> foodCourse;
	private String endMessage;

}
