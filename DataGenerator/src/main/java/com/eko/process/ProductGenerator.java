package com.eko.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;

import com.eko.model.Component;
import com.eko.model.DataHelper;
import com.eko.model.Manufacturer;
import com.eko.model.Product;
import com.eko.reader.ExcelReader;
import com.eko.util.Util;

public class ProductGenerator {

	public static void consumeProduct(String file, Map<String, Integer> mapping, Consumer<List<Product>> cons) {
		cons.accept(generateProduct(file, mapping));
	}

	public static List<Product> generateProduct(String file, Map<String, Integer> mapping) {
		Function<Row, DataHelper> rowParsing = row -> ExcelReader.parseRow(DataHelper.class, mapping, row).get();
		Map<Product, Map<Component, List<Manufacturer>>> result = ExcelReader.parseRows(file, 0).skip(1).map(rowParsing)
				.collect(Collectors.groupingBy(ProductGenerator::parseProduct,
						Collectors.groupingBy(ProductGenerator::parseComponent,
								Collectors.mapping(ProductGenerator::parseManufacturer, Collectors.toList()))));

		result.forEach((key, val) -> {
			val.forEach((component, innerVal) -> {
				component.getManufacturer().addAll(innerVal);
			});
			key.getComponent().addAll(val.keySet());
		});

		return new ArrayList<>(result.keySet());
	}

	private static Component parseComponent(DataHelper helper) {
		Component result = new Component();
		result.setComponentId(helper.getComponentId());
		result.setComponentType(helper.getComponentType());
		result.setComponentUnit(helper.getComponentUnits());
		result.setStockDate(Util.parseDateFromString(helper.getStockDate()));
		return result;
	}

	private static Manufacturer parseManufacturer(DataHelper helper) {
		Manufacturer result = new Manufacturer();
		result.setManufacturerId(helper.getManufacturerId());
		result.setManufacturerLocation(helper.getManufacturerLocation());
		result.setManufacturerName(helper.getManufacturerName());
		return result;
	}

	private static Product parseProduct(DataHelper helper) {
		Product result = new Product();
		result.setProductId(helper.getProductId());
		result.setProductName(helper.getProductName());
		result.setProductType(helper.getProductType());
		result.setProductUnits(Double.valueOf(helper.getProductUnits().toString()));
		return result;
	}
}
