package com.lonelyplanet.destination.processor.messages;

public class ExceptionMessages {
    public static final String TAXONOMY_FILE_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT =
            "Taxonomy file [%s] could not be unmarshaled: %s";
    public static final String TAXONOMY_NODE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT =
            "Node with Atlas Node ID [%s] could not be found: %s";
    public static final String DESTINATION_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT =
            "Destination could not be unmarshaled: %s";
    public static final String DESTINATIONS_FILE_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT =
            "Destination file [%s] could not be unmarshaled: %s";
    public static final String DESTINATION_OUTPUT_WRITE_EXCEPTION_MESSAGE_FORMAT =
            "Destination file [%s] could not be written: %s";
    public static final String DESTINATION_OUTPUT_TEMPLATE_PROCESSING_EXCEPTION_MESSAGE_FORMAT =
            "Destination template file [%s] could not be processed: %s";

    private ExceptionMessages() {
    }
}
