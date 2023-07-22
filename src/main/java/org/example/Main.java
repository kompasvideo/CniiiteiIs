package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static final String path = "./AS_ADDR_OBJ.XML";
    private static String date = "2010-01-01";
    private static String numbers = "1422396, 1450759, 1449192, 1451562";
    private static final String patternDate = "yyyy-MM-dd";


    public static void main(String[] args) throws JAXBException, IOException, XMLStreamException, ParseException {
        getArgs(args);
        Main main = new Main();
        Addressobjects addressobjects = main.unmarshal(path);
        main.searchDate(addressobjects, date, numbers);
    }

    private static void getArgs(String[] args) {
        if (args.length > 1) {
            date = args[0];
            numbers = args[1];
        }
    }

    private void searchDate(Addressobjects addressobjects, String date, String numbers) throws ParseException {
        Date date1 = new SimpleDateFormat(patternDate).parse(date);
        for (var it: addressobjects.getOBJECT()) {
            if (numbers.contains(String.valueOf(it.getObjectId()))) {
                Date date2 = it.getStartDate();
                if (date1.after(date2))
                {
                    System.out.println(it.getObjectId() + ": " + it.getTypeName() + " " + it.getName());
                }
            }
        }
    }

    private Addressobjects unmarshal(String name) throws JAXBException, IOException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(Addressobjects.class);
        InputStream in = new FileInputStream(new File(name));
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        return (Addressobjects) context.createUnmarshaller().unmarshal(parser);
    }
}