package org.example.tasks;

import jakarta.xml.bind.JAXBException;
import org.example.StrLongResult;
import org.example.as_addr_obj.Addressobjects;
import org.example.as_adm_hierarchy.Item;
import org.example.as_adm_hierarchy.Items;
import org.example.jaxb.Xaml;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Task2 {
    private static final String searchString = "проезд";
    private static final String path = "./AS_ADDR_OBJ.XML";
    private static final String pathHier = "./AS_ADM_HIERARCHY.XML";
    private Addressobjects addressobjects;
    private Items items;
    public void start() {
        try {
            addressobjects = Xaml.unmarshal(path);
            items = Xaml.unmarshalItems(pathHier);
            search(addressobjects);
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
    }


    private void search(Addressobjects addressobjects){
        for (var it: addressobjects.getOBJECT()) {
            String str = it.getTypeName();
            if(str.contains(searchString)) {
                String out = str + " " + it.getName();
                long id = it.getObjectId();
                while (true) {
                    StrLongResult res = searchParent(id);
                    if (res.getStr() != "") {
                        out = res.getStr() + out;
                    } else break;
                    id = res.getId();
                }
                System.out.println(out);
            }
        }
    }
    private StrLongResult searchParent(long objectId) {
        for (Item item: items.getITEM()) {
            if(item.getObjectId() == objectId) {
                long id = item.getParentObjId();
                if (item.getIsActive() == 1) {
                    return new StrLongResult(searchName(id), id);
                }
            }
        }
        return new StrLongResult("", 0);
    }
    private String searchName(long objectId) {
        for (var it: addressobjects.getOBJECT()) {
            Long id = it.getObjectId();
            if(id == objectId  && it.getIsActive() == 1) {
                return it.getTypeName() + " " + it.getName() + ", ";
            }
        }
        return "";
    }
}
