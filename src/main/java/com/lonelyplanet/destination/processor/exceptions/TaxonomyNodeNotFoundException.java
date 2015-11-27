package com.lonelyplanet.destination.processor.exceptions;

import com.google.common.base.Throwables;
import com.lonelyplanet.destination.processor.messages.ExceptionMessages;

public class TaxonomyNodeNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public TaxonomyNodeNotFoundException(int atlasNodeId, Exception exception) {
        super(buildMessage(atlasNodeId, exception));
    }

    private static String buildMessage(int atlasNodeId, Exception exception) {
        return String.format(ExceptionMessages.TAXONOMY_NODE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT,
                atlasNodeId, Throwables.getStackTraceAsString(exception));
    }
}
