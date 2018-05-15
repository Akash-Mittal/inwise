package com.inwise;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@SuppressWarnings("unused")
@Builder
@ToString
public class Item {
	private String name;
	private Integer quantity;
	private Double price;
	private Enums.CUISINE cuisine;

}
