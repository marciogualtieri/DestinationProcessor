package com.lonelyplanet.destination.processor.output.generators;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.DestinationOutputTemplateProcessingException;
import com.lonelyplanet.destination.processor.helpers.TaxonomyHelper;
import com.lonelyplanet.destination.processor.output.helpers.HtmlOutputNavigationHelper;
import com.lonelyplanet.test.constants.TestCommonConstants;
import com.lonelyplanet.test.constants.TestDestinationConstants;
import com.lonelyplanet.test.messages.TestMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.then;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH)
public class HtmlOutputGeneratorTest {

    @Autowired
    private HtmlOutputGenerator testHtmlOutputGenerator;
    @Autowired
    private TaxonomyHelper testTaxonomyHelper;
    @Autowired
    private HtmlOutputNavigationHelper testHtmlOutputNavigationHelper;

    @Test
    public void whenGenerateHmlOutputForDestination_thenOk() throws Exception {
        testHtmlOutputGenerator.generate(TestDestinationConstants.HILL_VALLEY_DESTINATION);
    }

    @Test
    public void whenGenerateHmlOutputForDestinationAndInvalidFreemarkerTemplate_thenException()
            throws Exception {
        HtmlOutputGenerator htmlOutputGenerator = new HtmlOutputGenerator(testTaxonomyHelper,
                testHtmlOutputNavigationHelper,
                TestCommonConstants.FAILURE_OUTPUT_BASE_DIRECTORY,
                TestCommonConstants.INVALID_FREEMARKER_TEMPLATE_FILE);
        htmlOutputGenerator.configureFreemarker();
        when(htmlOutputGenerator).generate(TestDestinationConstants.HILL_VALLEY_DESTINATION);
        then(caughtException())
                .isInstanceOf(DestinationOutputTemplateProcessingException.class)
                .hasMessageContaining(
                        TestMessages.DESTINATION_OUTPUT_TEMPLATE_PROCESSING_EXCEPTION_MESSAGE)
                .hasMessageContaining(TestMessages.FREEMARKER_TEMPLATE_ERROR_MESSAGE);
    }

} 
