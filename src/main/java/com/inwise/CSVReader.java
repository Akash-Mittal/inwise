package com.inwise;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CSVReader {

	private final List<InvoiceItem> invoiceItemList = new ArrayList<>();

	public List<InvoiceItem> getInvoiceItemList() {
		return Collections.unmodifiableList(new ArrayList<>(invoiceItemList));
	}

	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	private void load() throws IOException {
		Resource resource = resourceLoader.getResource(Invoice.CSV_FILE_PATH);
		try (Reader reader = new InputStreamReader(resource.getInputStream());
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
						.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			for (CSVRecord csvRecord : csvParser) {
				invoiceItemList.add(InvoiceItem.builder().recieptHeading(
				csvRecord.get("recieptHeading")).vendorName(
				csvRecord.get("vendorName")).vendorAddress(
				csvRecord.get("vendorAddress")).optionalWelcomeMessage(
				csvRecord.get("optionalWelcomeMessage")).date(
				csvRecord.get("date")).time(
				csvRecord.get("time")).foodCourse(Invoice.getItems(csvRecord.get("foodCourse"))).endMessage(
				csvRecord.get("endMessage")).build());
				};
				log.info("invoiceItemList size {}",invoiceItemList.size());

			}

		invoiceItemList.stream().forEach(invoiceItem -> {
			log.info(invoiceItem.toString());
		});
		}
	}
