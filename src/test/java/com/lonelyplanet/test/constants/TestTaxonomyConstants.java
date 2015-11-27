package com.lonelyplanet.test.constants;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Taxonomies;
import com.lonelyplanet.test.helpers.TestTaxonomyHelper;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

public class TestTaxonomyConstants {

    public static final String TAXONOMY_FILE_WITH_INVALID_CONTENT_NAME_AND_PATH = FilenameUtils
            .separatorsToSystem(
                    "src/test/resources/input/taxonomy/taxonomyWithInvalidContent.xml");

    public static final int HILL_VALLEY_ATLAS_NODE_ID = 3;
    public static final int HILL_VALLEY_ETHYL_CONTENT_OBJECT_ID = 33;
    public static final int HILL_VALLEY_GEO_ID = 333;
    public static final String HILL_VALLEY_NODE_NAME = "Hill Valley";

    public static final int SIERRA_NEVADA_MOUNTAINS_ATLAS_NODE_ID = 2;
    public static final int SIERRA_NEVADA_MOUNTAINS_ETHYL_CONTENT_OBJECT_ID = 22;
    public static final int SIERRA_NEVADA_MOUNTAINS_GEO_ID = 222;
    public static final String SIERRA_NEVADA_MOUNTAINS_NODE_NAME = "Sierra Nevada Mountains";

    public static final int CALIFORNIA_ATLAS_NODE_ID = 1;
    public static final int CALIFORNIA_ETHYL_CONTENT_OBJECT_ID = 11;
    public static final int CALIFORNIA_GEO_ID = 111;
    public static final String CALIFORNIA_NODE_NAME = "California";

    public static final int NON_EXISTENT_ATLAS_NODE_ID = 999;

    public static final Taxonomies TAXONOMIES = TestTaxonomyHelper.createTestTaxonomies();

    private static final Node CALIFORNIA_NODE_WITHOUT_PARENT_OR_CHILDREN =
            TestTaxonomyHelper.createNode(CALIFORNIA_ATLAS_NODE_ID,
                    CALIFORNIA_ETHYL_CONTENT_OBJECT_ID,
                    CALIFORNIA_GEO_ID,
                    CALIFORNIA_NODE_NAME, null, null);
    private static final Node SIERRA_NEVADA_MOUNTAINS_NODE_WITHOUT_PARENT_OR_CHILDREN =
            TestTaxonomyHelper.createNode(SIERRA_NEVADA_MOUNTAINS_ATLAS_NODE_ID,
                    SIERRA_NEVADA_MOUNTAINS_ETHYL_CONTENT_OBJECT_ID,
                    SIERRA_NEVADA_MOUNTAINS_GEO_ID,
                    SIERRA_NEVADA_MOUNTAINS_NODE_NAME, null, null);
    private static final Node HILL_VALLEY_NODE_WITHOUT_PARENT_OR_CHILDREN =
            TestTaxonomyHelper.createNode(HILL_VALLEY_ATLAS_NODE_ID,
                    HILL_VALLEY_ETHYL_CONTENT_OBJECT_ID,
                    HILL_VALLEY_GEO_ID, HILL_VALLEY_NODE_NAME,
                    null, null);

    private static final Node CALIFORNIA_NODE =
            TestTaxonomyHelper.returnNodeWithParentAndChildrenSet(CALIFORNIA_NODE_WITHOUT_PARENT_OR_CHILDREN,
                    null,
                    Lists.newArrayList(SIERRA_NEVADA_MOUNTAINS_NODE_WITHOUT_PARENT_OR_CHILDREN));
    public static final Node SIERRA_NEVADA_MOUNTAINS_NODE =
            TestTaxonomyHelper.returnNodeWithParentAndChildrenSet(
                    SIERRA_NEVADA_MOUNTAINS_NODE_WITHOUT_PARENT_OR_CHILDREN,
                    CALIFORNIA_NODE,
                    Lists.newArrayList(HILL_VALLEY_NODE_WITHOUT_PARENT_OR_CHILDREN));
    public static final Node HILL_VALLEY_NODE =
            TestTaxonomyHelper.returnNodeWithParentAndChildrenSet(
                    HILL_VALLEY_NODE_WITHOUT_PARENT_OR_CHILDREN,
                    SIERRA_NEVADA_MOUNTAINS_NODE, null);

    public static final List<Node> HILL_VALLEY_PARENT_NODES =
            Lists.newArrayList(CALIFORNIA_NODE, SIERRA_NEVADA_MOUNTAINS_NODE);

    private TestTaxonomyConstants() {
    }
}
