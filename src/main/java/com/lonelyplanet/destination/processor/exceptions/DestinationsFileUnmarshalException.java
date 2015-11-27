package com.lonelyplanet.destination.processor.exceptions;

import com.google.common.base.Throwables;
import com.lonelyplanet.destination.processor.messages.ExceptionMessages;

public class DestinationsFileUnmarshalException extends Exception {
    private static final long serialVersionUID = 1L;

    public DestinationsFileUnmarshalException(String fileNameAndPath, Exception exception) {
        super(buildMessage(fileNameAndPath, exception));
    }

    private static String buildMessage(String fileNameAndPath, Exception exception) {
        return String.format(ExceptionMessages.DESTINATIONS_FILE_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT,
                fileNameAndPath, Throwables.getStackTraceAsString(exception));
    }
}