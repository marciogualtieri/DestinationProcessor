package com.lonelyplanet.destination.processor.exceptions;

import com.google.common.base.Throwables;
import com.lonelyplanet.destination.processor.messages.ExceptionMessages;

public class DestinationOutputFileWriteException extends Exception {
    private static final long serialVersionUID = 1L;

    public DestinationOutputFileWriteException(String fileNameAndPath, Exception exception) {
        super(buildMessage(fileNameAndPath, exception));
    }

    private static String buildMessage(String fileNameAndPath, Exception exception) {
        return String.format(ExceptionMessages.DESTINATION_OUTPUT_WRITE_EXCEPTION_MESSAGE_FORMAT,
                fileNameAndPath, Throwables.getStackTraceAsString(exception));
    }
}