package com.lonelyplanet.destination.processor.helpers;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.TaxonomyFileUnmarshalException;
import com.lonelyplanet.destination.processor.exceptions.TaxonomyNodeNotFoundException;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Taxonomies;
import com.lonelyplanet.test.constants.TestCommonConstants;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;
import com.lonelyplanet.test.messages.TestMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.then;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH)
public class TaxonomyHelperTest {

    @Autowired
    private TaxonomyHelper testTaxonomyHelper;

    @Test
    public void whenGetTaxonomies_thenOk() throws Exception {
        Taxonomies testTaxonomies = testTaxonomyHelper.getTaxonomies();
        assertThat(testTaxonomies, equalTo(TestTaxonomyConstants.TAXONOMIES));
    }

    @Test
    public void whenUnmarshalTaxonomiesAndNonExistentFile_thenException() throws Exception {
        TaxonomyHelper taxonomyHelper = new TaxonomyHelper(TestCommonConstants.NON_EXISTENT_FILE_NAME_AND_PATH);
        when(taxonomyHelper).unmarshalTaxonomyFile();
        then(caughtException())
                .isInstanceOf(TaxonomyFileUnmarshalException.class)
                .hasMessageContaining(
                        TestMessages.TAXONOMY_FILE_NOT_FOUND_EXCEPTION_MESSAGE)
                .hasMessageContaining(TestMessages.FILE_NOT_FOUND_MESSAGE);
    }

    @Test
    public void whenUnmarshalTaxonomiesAndInvalidContent_thenException() throws Exception {
        TaxonomyHelper taxonomyHelper =
                new TaxonomyHelper(TestTaxonomyConstants.TAXONOMY_FILE_WITH_INVALID_CONTENT_NAME_AND_PATH);
        when(taxonomyHelper).unmarshalTaxonomyFile();
        then(caughtException())
                .isInstanceOf(TaxonomyFileUnmarshalException.class)
                .hasMessageContaining(
                        TestMessages.TAXONOMY_FILE_SAX_PARSING_EXCEPTION_MESSAGE)
                .hasMessageContaining(TestMessages.FILE_SAX_PARSING_EXCEPTION_MESSAGE);
    }

    @Test
    public void whenGetNodeWithAtlasNodeId_thenOk() throws Exception {
        Node node = testTaxonomyHelper.getNodeByAtlasNodeId(TestTaxonomyConstants.HILL_VALLEY_ATLAS_NODE_ID);
        assertThat(node, equalTo(TestTaxonomyConstants.HILL_VALLEY_NODE));
    }

    @Test
    public void whenGetNodeWithAtlasNodeIdAndIdDoesNotExist_thenException() throws Exception {
        when(testTaxonomyHelper).getNodeByAtlasNodeId(TestTaxonomyConstants.NON_EXISTENT_ATLAS_NODE_ID);
        then(caughtException())
                .isInstanceOf(TaxonomyNodeNotFoundException.class)
                .hasMessageContaining(
                        TestMessages.TAXONOMY_NODE_NOT_FOUND_EXCEPTION_MESSAGE)
                .hasMessageContaining(TestMessages.NODE_NOT_FOUND_MESSAGE);
    }
} 
