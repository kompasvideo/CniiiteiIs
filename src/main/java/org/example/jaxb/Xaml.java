package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.example.as_addr_obj.Addressobjects;
import org.example.as_adm_hierarchy.Items;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Xaml {
    public static Addressobjects unmarshal(String name) throws JAXBException, IOException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(Addressobjects.class);
        InputStream in = new FileInputStream(new File(name));
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        return (Addressobjects) context.createUnmarshaller().unmarshal(parser);
    }

    public static Items unmarshalItems(String name) throws JAXBException, IOException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(Items.class);
        InputStream in = new FileInputStream(new File(name));
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        return (Items) context.createUnmarshaller().unmarshal(parser);
    }
}
