package com.lonelyplanet.destination.processor.exceptions;

        import com.google.common.base.Throwables;
        import com.lonelyplanet.destination.processor.messages.ExceptionMessages;

public class DestinationOutputTemplateProcessingException extends Exception {
    private static final long serialVersionUID = 1L;

    public DestinationOutputTemplateProcessingException(String templateFileNameAndPath, Exception exception) {
        super(buildMessage(templateFileNameAndPath, exception));
    }

    private static String buildMessage(String templateFileNameAndPath, Exception exception) {
        return String.format(ExceptionMessages.DESTINATION_OUTPUT_TEMPLATE_PROCESSING_EXCEPTION_MESSAGE_FORMAT,
                templateFileNameAndPath, Throwables.getStackTraceAsString(exception));
    }
}