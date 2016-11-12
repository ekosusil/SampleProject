package com.eko.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FormatUtil {

	public static <T> String getXMLString(T t) {
		JAXBContext context;
		try {
			StringWriter tw = new StringWriter();
			context = JAXBContext.newInstance(t.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(t, System.out);
			return tw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public static <T> String getJsonString(T t){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

}
