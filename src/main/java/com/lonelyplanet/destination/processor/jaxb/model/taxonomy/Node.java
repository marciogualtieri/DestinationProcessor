package com.lonelyplanet.destination.processor.jaxb.model.taxonomy;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Node {
    @XmlAttribute(name = "atlas_node_id")
    private int atlasNodeId;
    @XmlAttribute(name = "ethyl_content_object_id")
    private int ethylContentObjectId;
    @XmlAttribute(name = "geo_id")
    private int geoId;
    @XmlElement(name = "node_name")
    private String nodeName;
    @XmlElement(name = "node")
    private List<Node> nodesList;
    private Node parentNode = null;

    public int getAtlasNodeId() {
        return atlasNodeId;
    }

    public void setAtlasNodeId(int atlasNodeId) {
        this.atlasNodeId = atlasNodeId;
    }

    public int getEthylContentObjectId() {
        return ethylContentObjectId;
    }

    public void setEthylContentObjectId(int ethylContentObjectId) {
        this.ethylContentObjectId = ethylContentObjectId;
    }

    public int getGeoId() {
        return geoId;
    }

    public void setGeoId(int geoId) {
        this.geoId = geoId;
    }

    public String geNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<Node> getNodesList() {
        return nodesList;
    }

    public void setNodesList(List<Node> nodesList) {
        this.nodesList = nodesList;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * JAXB's callback method used to set the parent node for the current node.
     *
     * @param unmarshaller JAXB's unmarshaller
     * @param parentObject parent object in the XML tree
     */
    public void afterUnmarshal(Unmarshaller unmarshaller, Object parentObject) {
        if (parentObject instanceof Node) {
            setParentNode((Node) parentObject);
        }
    }

    public List<Node> getParentNodes() {
        List<Node> parentNodes = new ArrayList<>();
        Node node = getParentNode();
        while (node != null) {
            parentNodes.add(0, node);
            node = node.getParentNode();
        }
        return parentNodes;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Node other = (Node) object;
        return Objects.equal(this.atlasNodeId, other.atlasNodeId)
                && Objects.equal(this.ethylContentObjectId, other.ethylContentObjectId)
                && Objects.equal(this.geoId, other.geoId)
                && Objects.equal(this.nodeName, other.nodeName)
                && Objects.equal(getAtlasNodeIds(this.nodesList), getAtlasNodeIds(other.nodesList))
                && Objects.equal(getAtlasNodeId(this.parentNode), getAtlasNodeId(other.parentNode));

    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("atlasNodeId", atlasNodeId)
                .add("ethylContentObjectId", ethylContentObjectId)
                .add("geoId", geoId)
                .add("nodeName", nodeName)
                .add("childNodesAtlasNodeIdsList", getAtlasNodeIds(nodesList))
                .add("parentNodeAtlasNodeId", getAtlasNodeId(parentNode))
                .toString();

    }

    private List<Integer> getAtlasNodeIds(List<Node> nodes) {
        List<Integer> atlasNodeIds = null;
        if (nodes != null) {
            atlasNodeIds = nodes.stream().map(Node::getAtlasNodeId).collect(Collectors.toList());
        }
        return atlasNodeIds;
    }

    private Integer getAtlasNodeId(Node node) {
        return (node == null) ? null : node.getAtlasNodeId();
    }

}
