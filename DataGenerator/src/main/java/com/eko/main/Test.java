package com.eko.main;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eko.process.ProductGenerator;
import com.eko.util.OutputUtil;
import com.eko.util.XMLUtil;

public class Test {

	public static Map<String, BiFunction<String, Map<String, Integer>, List<? extends Object>>> resultFunction = new HashMap<>();
	public static Map<String, Consumer<Object>> downstream = new HashMap<>();
	public static Map<String, Function<Object, String>> formatFunction = new HashMap<>();
	private static Logger log = LoggerFactory.getLogger(Test.class);

	static {
		resultFunction.put("product", (path, mapping) -> ProductGenerator.generateProduct(path, mapping));
		formatFunction.put("xml", XMLUtil::getXMLString);
		formatFunction.put("json", XMLUtil::getJsonString);
		downstream.put("console", OutputUtil::writeToConsole);
	}

	public static void main(String arg[]) {

		String useCase = arg[0].toLowerCase();
		String format = arg[1].toLowerCase();
		String output = arg[2].toLowerCase();

		if (!resultFunction.containsKey(useCase)) {
			log.error("Unknown use case " + useCase);
		} else if (!formatFunction.containsKey(format)) {
			log.error("Unknown format " + format);
		} else if (!downstream.containsKey(output)) {
			log.error("Unknown output mode " + output);
		} else {
			readProperty();
			Function<List<? extends Object>, List<String>> mapping = list -> list.stream()
					.map(elt -> formatFunction.get(format).apply(elt)).collect(Collectors.toList());

			resultFunction.get(useCase).andThen(mapping)
					.apply(System.getProperty(useCase + ".sourceFile"),
							parseMapping(System.getProperty(useCase + ".mapping")))
					.forEach(elt -> downstream.get(output).accept(elt));
		}
	}

	private static Map<String, Integer> parseMapping(String line) {

		String elt[] = line.split(",");
		return IntStream.range(0, elt.length).boxed().map(i -> new AbstractMap.SimpleEntry<String, Integer>(elt[i], i))
				.collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
	}

	private static void readProperty() {
		Properties property = new Properties();
		try {
			property.load(Test.class.getResourceAsStream("/conf.properties"));
			property.entrySet()
					.forEach(entry -> System.setProperty(entry.getKey().toString(), entry.getValue().toString()));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
