package com.lonelyplanet.destination.processor;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.DestinationsFileUnmarshalException;
import com.lonelyplanet.destination.processor.helpers.DestinationHelper;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import com.lonelyplanet.destination.processor.messages.AppMessages;
import com.lonelyplanet.destination.processor.output.generators.HtmlOutputGenerator;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;

@Component
public class Processor {
    private static final Logger logger = LoggerFactory.getLogger(Processor.class);
    private final String destinationFileNameAndPath;
    private final HtmlOutputGenerator htmlOutputGenerator;
    private final DestinationHelper destinationHelper;
    private FileReader destinationFileReader;
    private XMLStreamReader destinationXmlStreamReader;

    @Autowired
    public Processor(
            @Value(AppConstants.DESTINATION_FILE_PROPERTY_VALUE) String destinationFileNameAndPath,
            HtmlOutputGenerator htmlOutputGenerator,
            DestinationHelper destinationHelper) {
        this.destinationFileNameAndPath = destinationFileNameAndPath;
        this.htmlOutputGenerator = htmlOutputGenerator;
        this.destinationHelper = destinationHelper;
    }

    public void processAllDestinations() throws DestinationsFileUnmarshalException {
        createXMLStreamReader();
        try {
            seekFirstDestinationElement(destinationXmlStreamReader);
            while (destinationXmlStreamReader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                Destination destination = destinationHelper.unmarshalDestination(destinationXmlStreamReader);
                logger.debug(AppMessages.PARSED_DESTINATION_MESSAGE_FORMAT, destination);
                htmlOutputGenerator.generate(destination);
                seekNextDestinationElement(destinationXmlStreamReader);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DestinationsFileUnmarshalException(destinationFileNameAndPath, e);
        } finally {
            IOUtils.closeQuietly(destinationFileReader);
        }
    }

    private void createXMLStreamReader() throws DestinationsFileUnmarshalException {
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            destinationFileReader = new FileReader(destinationFileNameAndPath);
            destinationXmlStreamReader = xmlInputFactory.createXMLStreamReader(destinationFileReader);
        } catch (Exception e) {
            throw new DestinationsFileUnmarshalException(destinationFileNameAndPath, e);
        }
        logger.debug(AppMessages.READING_DESTINATIONS_FILE_MESSAGE_FORMAT, destinationFileNameAndPath);
    }

    private void seekFirstDestinationElement(XMLStreamReader destinationXmlStreamReader) throws XMLStreamException {
        destinationXmlStreamReader.nextTag();
        destinationXmlStreamReader.require(XMLStreamConstants.START_ELEMENT, null, "destinations");
        destinationXmlStreamReader.nextTag();
    }

    private void seekNextDestinationElement(XMLStreamReader destinationXmlStreamReader)
            throws XMLStreamException {
        if (destinationXmlStreamReader.getEventType() == XMLStreamConstants.CHARACTERS) {
            destinationXmlStreamReader.next();
        }
    }

}
