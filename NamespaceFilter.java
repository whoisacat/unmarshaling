package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import com.sun.xml.bind.v2.runtime.unmarshaller.SAXConnector;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.namespace.QName;
import java.util.Collection;

/**
 * Фильтр пространства имен для десериализации XML
 */
public class NamespaceFilter extends XMLFilterImpl {
    private SAXConnector saxConnector;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if(saxConnector != null) {
            Collection<QName> expected = saxConnector.getContext().getCurrentExpectedElements();
            for(QName expectedQname : expected) {
                if(localName.equals(expectedQname.getLocalPart())) {
                    super.startElement(expectedQname.getNamespaceURI(), localName, qName, atts);
                    return;
                }
            }
        }
        super.startElement(uri, localName, qName, atts);
    }

    @Override
    public void setContentHandler(ContentHandler handler) {
        super.setContentHandler(handler);
        if(handler instanceof SAXConnector) {
            saxConnector = (SAXConnector) handler;
        }
    }
}