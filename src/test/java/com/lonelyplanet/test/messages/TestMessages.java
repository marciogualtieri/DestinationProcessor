package com.lonelyplanet.test.messages;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.messages.ExceptionMessages;
import com.lonelyplanet.test.constants.TestCommonConstants;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;

public class TestMessages {

    private static final String FILE_NOT_FOUND_MESSAGE_FORMAT =
            "%s (No such file or directory)";
    public static final String FILE_NOT_FOUND_MESSAGE =
            String.format(FILE_NOT_FOUND_MESSAGE_FORMAT,
                    TestCommonConstants.NON_EXISTENT_FILE_NAME_AND_PATH);

    public static final String TAXONOMY_FILE_NOT_FOUND_EXCEPTION_MESSAGE =
            String.format(ExceptionMessages.TAXONOMY_FILE_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT,
                    TestCommonConstants.NON_EXISTENT_FILE_NAME_AND_PATH, "");

    public static final String TAXONOMY_FILE_SAX_PARSING_EXCEPTION_MESSAGE =
            String.format(ExceptionMessages.TAXONOMY_FILE_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT,
                    TestTaxonomyConstants.TAXONOMY_FILE_WITH_INVALID_CONTENT_NAME_AND_PATH, "");

    private static final String FILE_SAX_PARSING_EXCEPTION_MESSAGE_FORMAT =
            "%s; lineNumber: 6; columnNumber: 7; The element type \"node\" must be terminated by the matching end-tag \"</node>\".";

    public static final String FILE_SAX_PARSING_EXCEPTION_MESSAGE =
            String.format(FILE_SAX_PARSING_EXCEPTION_MESSAGE_FORMAT,
                    TestTaxonomyConstants.TAXONOMY_FILE_WITH_INVALID_CONTENT_NAME_AND_PATH);

    public static final String TAXONOMY_NODE_NOT_FOUND_EXCEPTION_MESSAGE =
            String.format(ExceptionMessages.TAXONOMY_NODE_NOT_FOUND_EXCEPTION_MESSAGE_FORMAT,
                    TestTaxonomyConstants.NON_EXISTENT_ATLAS_NODE_ID, "");

    private static final String NODE_NOT_FOUND_MESSAGE_FORMAT =
            "No value for xpath: %s";
    public static final String NODE_NOT_FOUND_MESSAGE =
            String.format(NODE_NOT_FOUND_MESSAGE_FORMAT, AppConstants.ATLAS_NODE_ID_JXPATH_QUERY);

    public static final String DESTINATION_UNMARSHAL_EXCEPTION_MESSAGE =
            String.format(ExceptionMessages.DESTINATION_UNMARSHAL_EXCEPTION_MESSAGE_FORMAT, "");

    public static final String DESTINATION_SAX_PARSING_EXCEPTION_MESSAGE =
            "The element type \"history\" must be terminated by the matching end-tag \"</history>\"";

    public static final String DESTINATION_OUTPUT_TEMPLATE_PROCESSING_EXCEPTION_MESSAGE =
            String.format(ExceptionMessages.DESTINATION_OUTPUT_TEMPLATE_PROCESSING_EXCEPTION_MESSAGE_FORMAT,
                    TestCommonConstants.INVALID_FREEMARKER_TEMPLATE_FILE, "");

    public static final String FREEMARKER_TEMPLATE_ERROR_MESSAGE = "FreeMarker template error:";

    private TestMessages() {
    }
}
