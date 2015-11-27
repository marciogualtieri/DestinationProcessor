package com.lonelyplanet.destination.processor.constants;

import org.apache.commons.io.FilenameUtils;

public class AppConstants {
    public static final String ATLAS_NODE_ID_JXPATH_QUERY = "//nodesList[atlasNodeId=$atlasNodeId]";
    public static final String APPLICATION_CONTEXT_FILE_NAME_AND_PATH = "classpath:spring/applicationContext.xml";
    public static final String TAXONOMY_FILE_PROPERTY_VALUE =
            "${taxonomy.file:${default.taxonomy.file}}";
    public static final String DESTINATION_FILE_PROPERTY_VALUE =
            "${destinations.file:${default.destinations.file}}";
    public static final String OUTPUT_BASE_DIRECTORY_PROPERTY_VALUE =
            "${output.base.directory:${default.output.base.directory}}";
    public static final String FREEMARKER_TEMPLATE_FILE_PROPERTY_VALUE = "${freemarker.template.file}";
    public static final String BLANK_CHAR_REPLACEMENT = "-";
    public static final String BLANK_CHAR_REGEX = "\\s+";
    public static final String FREEMARKER_TEMPLATES_DIRECTORY = FilenameUtils
            .separatorsToSystem("/freemarker/templates");
    public static final String OUTPUT_DEFAULT_ENCODING = "UTF-8";
    public static final String DESTINATION_FREEMARKER_PLACEHOLDER = "destination";
    public static final String OUTPUT_FILE_NAME_AND_PATH_TEMPLATE =
            "%s" + AppConstants.BLANK_CHAR_REPLACEMENT + "%d.html";

    private AppConstants() {
    }
}
