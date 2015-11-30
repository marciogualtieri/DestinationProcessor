package com.lonelyplanet.destination.processor.output;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

public class OutputNavigationNode {
    String name;
    String resource;
    List<OutputNavigationNode> outputNavigationNodeList;

    public OutputNavigationNode(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<OutputNavigationNode> getOutputNavigationNodeList() {
        return outputNavigationNodeList;
    }

    public void setOutputNavigationNodeList(List<OutputNavigationNode> outputNavigationNodeList) {
        this.outputNavigationNodeList = outputNavigationNodeList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final OutputNavigationNode other = (OutputNavigationNode) object;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.resource, other.resource)
                && Objects.equal(this.outputNavigationNodeList, other.outputNavigationNodeList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("resource", resource)
                .add("outputNavigationNodeList", outputNavigationNodeList)
                .toString();
    }
}
