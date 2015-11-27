package com.lonelyplanet.test.helpers;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Taxonomies;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Taxonomy;
import com.lonelyplanet.test.constants.TestTaxonomyConstants;

import java.util.List;

public class TestTaxonomyHelper {

    public static Taxonomies createTestTaxonomies() {
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setTaxonomyName("test");
        taxonomy.setNodes(createTestNodes());
        Taxonomies taxonomies = new Taxonomies();
        taxonomies.setTaxonomyList(Lists.newArrayList(taxonomy));
        return taxonomies;
    }

    private static List<Node> createTestNodes() {
        Node hillValleyNode = createNode(TestTaxonomyConstants.HILL_VALLEY_ATLAS_NODE_ID,
                TestTaxonomyConstants.HILL_VALLEY_ETHYL_CONTENT_OBJECT_ID,
                TestTaxonomyConstants.HILL_VALLEY_GEO_ID, TestTaxonomyConstants.HILL_VALLEY_NODE_NAME, null, null);
        Node sierraNevadaMountainsNode = createNode(TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_ATLAS_NODE_ID,
                TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_ETHYL_CONTENT_OBJECT_ID,
                TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_GEO_ID,
                TestTaxonomyConstants.SIERRA_NEVADA_MOUNTAINS_NODE_NAME,
                Lists.newArrayList(hillValleyNode), null);
        Node californiaNode = createNode(1, 11, 111, "California",
                Lists.newArrayList(sierraNevadaMountainsNode), null);
        hillValleyNode.setParentNode(sierraNevadaMountainsNode);
        sierraNevadaMountainsNode.setParentNode(californiaNode);
        return Lists.newArrayList(californiaNode);
    }

    public static Node createNode(int atlasNodeId, int ethylContentObjectId, int geoId, String name,
                                  List<Node> childNodes, Node parentNode) {
        Node node = new Node();
        node.setAtlasNodeId(atlasNodeId);
        node.setEthylContentObjectId(ethylContentObjectId);
        node.setGeoId(geoId);
        node.setNodeName(name);
        node.setNodesList(childNodes);
        node.setParentNode(parentNode);
        return node;
    }

    public static Node returnNodeWithParentAndChildrenSet(Node node, Node parentNode, List<Node> childNodes) {
        node.setParentNode(parentNode);
        node.setNodesList(childNodes);
        return node;
    }

    private TestTaxonomyHelper() {
    }
}
