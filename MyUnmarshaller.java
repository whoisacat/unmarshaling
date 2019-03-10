package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Десериализатор XML файлов
 */
@Slf4j
public class MyUnmarshaller{

    private ISet mSet;

    /**
     * Конструктор с логий десериализации объектов из файла XML
     * @param file - файл XML для десериализации
     * @throws SAXException
     */
    public MyUnmarshaller(File file) throws SAXException{

        JAXBContext jc;
        Unmarshaller unmarshaller;
        try{
            log.info("{} exist {}",file.getName(),file.exists());
            jc = JAXBContext.newInstance((file.getName().contains("objects") ? TrafficatorNameSet.class :
                    (file.getName().contains("states") ? StateSet.class : null)));
            unmarshaller = jc.createUnmarshaller();

            XMLReader reader = XMLReaderFactory.createXMLReader();
            NamespaceFilter inFilter = new NamespaceFilter();
            inFilter.setParent(reader);

            InputSource is;
            is = new InputSource(new FileInputStream(file));
            SAXSource source = new SAXSource(inFilter,is);
            mSet = (file.getName().contains("objects") ? (TrafficatorNameSet)unmarshaller.unmarshal(source) :
                    (file.getName().contains("states") ? (StateSet)unmarshaller.unmarshal(source) : null));
        }catch(FileNotFoundException | JAXBException e){
            e.printStackTrace();
        }
    }

    public ISet getSet(){
        return mSet;
    }
}
