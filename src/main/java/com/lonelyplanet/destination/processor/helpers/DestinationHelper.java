package com.lonelyplanet.destination.processor.helpers;

import com.lonelyplanet.destination.processor.exceptions.DestinationUnmarshalException;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

@Component
public class DestinationHelper {

    private Unmarshaller unmarshaller;

    @PostConstruct
    public void createDestinationUnmarshaller() throws DestinationUnmarshalException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Destination.class);
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new DestinationUnmarshalException(e);
        }
    }

    public Destination unmarshalDestination(XMLStreamReader destinationXmlStreamReader)
            throws DestinationUnmarshalException {
        Destination destination;
        try {
            JAXBElement<Destination> jaxbElementDestination =
                    unmarshaller.unmarshal(destinationXmlStreamReader, Destination.class);
            destination = jaxbElementDestination.getValue();
        } catch (Exception e) {
            throw new DestinationUnmarshalException(e);
        }
        return destination;
    }
}
