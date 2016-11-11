package com.eko.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static Map<Integer,Function<Cell,Object>> parsing=new HashMap<>();
	static {
		parsing.put(Cell.CELL_TYPE_NUMERIC, Cell::getNumericCellValue);
		parsing.put(Cell.CELL_TYPE_STRING, Cell::getStringCellValue);
	}
	
	public static Stream<Row> parseRows(String filePath, int index) {
		boolean fileExists = Optional.ofNullable(filePath).map(Paths::get).map(Files::exists).orElse(false);
		if (fileExists) {
			try (FileInputStream fis = new FileInputStream(new File(filePath))) {
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				return StreamSupport.stream(workbook.getSheetAt(index).spliterator(), false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return Stream.empty();
		} else
			return Stream.empty();
	}
	
	
	public static <T> Optional<T> parseRow(Class<T> clazz, final Map<String, Integer> mapping, Row row) {
		try {
			T t = clazz.newInstance();
			mapping.entrySet().forEach(entry -> {
				try {
					BeanUtils.setProperty(t, entry.getKey(), ExcelReader.parseCell(row.getCell(entry.getValue())));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			return Optional.of(t);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	private static Object parseCell(Cell cell) {
		return parsing.getOrDefault(cell.getCellType(), curCell -> curCell.getStringCellValue()).apply(cell);
	}
}
