package com.lonelyplanet.destination.processor.output.helpers;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import com.lonelyplanet.test.constants.TestCommonConstants;
import com.lonelyplanet.test.constants.TestOutputConstants;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH)
public class HtmlOutputNavigationHelperTest {

    @Autowired
    HtmlOutputNavigationHelper testHtmlOutputNavigationHelper;

    @Test
    public void whenBuildFileNameAndPathForDestination_thenOk() throws Exception {
        String destinationFileNameAndPath =
                testHtmlOutputNavigationHelper
                        .buildFileNameAndPathForNode(
                                TestCommonConstants.SUCCESS_OUTPUT_BASE_DIRECTORY,
                                TestTaxonomyConstants.HILL_VALLEY_NODE);
        assertThat(destinationFileNameAndPath, equalTo(TestOutputConstants.HILL_VALLEY_OUTPUT_FILE_NAME_AND_PATH));
    }

    @Test
    public void whenBuildNavigationTree_thenOk() throws Exception {
        OutputNavigationNode navigationTree =
                testHtmlOutputNavigationHelper
                        .buildNavigationTreeForNode(TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_NODE);
        assertThat(navigationTree, equalTo(TestOutputConstants.NAVIGATION_TREE));
    }
}