package com.lonelyplanet.destination.processor.jaxb.model.taxonomy;

import com.lonelyplanet.test.constants.TestTaxonomyConstants;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class NodeTest {

    @Test
    public void whenGetAtlasNodeId_thenOk() throws Exception {
        assertThat(TestTaxonomyConstants.HILL_VALLEY_NODE.getParentNodes(),
                contains(TestTaxonomyConstants.HILL_VALLEY_PARENT_NODES.toArray()));
    }

} 
