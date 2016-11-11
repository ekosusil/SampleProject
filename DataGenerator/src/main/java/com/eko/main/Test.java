package com.eko.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eko.process.ProductGenerator;

public class Test {

	public static Map<String, BiFunction<String, Map<String, Integer>, List<? extends Object>>> resultFunction;
	private static Logger log = null;

	static {
		resultFunction.put("product", (path, mapping) -> ProductGenerator.generateProduct(path, mapping));
	}

	public static void main(String arg[]) {

		String useCase = arg[0];
		readProperty();
		resultFunction.getOrDefault(useCase, (path, mapping) -> new ArrayList<Object>());

	}

	private static void readProperty() {
		Properties property = new Properties();
		try {
			property.load(Test.class.getResourceAsStream("/conf.properties"));
			property.entrySet()
					.forEach(entry -> System.setProperty(entry.getKey().toString(), entry.getValue().toString()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
