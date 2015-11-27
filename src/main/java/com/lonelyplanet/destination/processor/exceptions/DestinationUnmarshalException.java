package com.lonelyplanet.destination.processor.exceptions;


import com.google.common.base.Throwables;
import com.lonelyplanet.destination.processor.messages.ExceptionMessages;

public class DestinationUnmarshalException extends Exception {
    private static final long serialVersionUID = 1L;

    public DestinationUnmarshalException(Exception exception) {
        super(buildMessage(exception));
    }

    private static String buildMessage(Exception exception) {
        return String.format(ExceptionMessages.DESTINATION_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT,
                Throwables.getStackTraceAsString(exception));
    }
}
