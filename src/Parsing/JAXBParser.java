package Parsing;

import Parsing.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser <T> implements Parser {
    @Override
    public T getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller jaxbUnmarshaller1 = context.createUnmarshaller();
        T typeList = (T) jaxbUnmarshaller1.unmarshal(file);
        return typeList;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        jaxbMarshaller.marshal( o, file);
       // jaxbMarshaller.marshal( o, System.out );
    }
}