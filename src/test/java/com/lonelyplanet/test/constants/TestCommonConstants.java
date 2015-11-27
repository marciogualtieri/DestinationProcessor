package com.lonelyplanet.test.constants;

import org.apache.commons.io.FilenameUtils;

public class TestCommonConstants {

    public static final String NON_EXISTENT_FILE_NAME_AND_PATH = FilenameUtils
            .separatorsToSystem(
                    "src/test/resources/i/do/not.exist");
    public static final String INVALID_FREEMARKER_TEMPLATE_FILE = "invalidFreemarkerTemplate.ftl";
    public static final String SUCCESS_OUTPUT_BASE_DIRECTORY = "./target/output/success";
    public static final String FAILURE_OUTPUT_BASE_DIRECTORY = "./target/output/failure";

    private TestCommonConstants() {
    }
}