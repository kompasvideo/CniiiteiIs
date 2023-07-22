package org.example.tasks;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.example.Main;
import org.example.as_addr_obj.Addressobjects;
import org.example.jaxb.Xaml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task1 {
    private static final String path = "./AS_ADDR_OBJ.XML";
    private static String date = "2010-01-01";
    private static String numbers = "1422396, 1450759, 1449192, 1451562";
    private static final String patternDate = "yyyy-MM-dd";

    public void start(String[] args) {
        try {
            getArgs(args);
            Addressobjects addressobjects = Xaml.unmarshal(path);
            searchDate(addressobjects, date, numbers);
            System.out.println();
            System.out.println();
        }
        catch (JAXBException ex) {
            System.out.println("JAXBException");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("IOException");
            ex.printStackTrace();
        }
        catch (XMLStreamException ex){
            System.out.println("XMLStreamException");
            ex.printStackTrace();
        }
        catch (ParseException ex) {
            System.out.println("ParseException");
            ex.printStackTrace();
        }
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



}
