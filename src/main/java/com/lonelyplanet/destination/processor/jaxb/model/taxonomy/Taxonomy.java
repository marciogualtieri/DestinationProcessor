package com.lonelyplanet.destination.processor.jaxb.model.taxonomy;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "taxonomy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Taxonomy {
    @XmlElement(name = "taxonomy_name")
    private String taxonomyName;
    @XmlElement(name = "node")
    private List<Node> nodesList;

    public String getTaxonomyName() {
        return taxonomyName;
    }

    public void setTaxonomyName(String taxonomyName) {
        this.taxonomyName = taxonomyName;
    }

    public List<Node> getNodesList() {
        return nodesList;
    }

    public void setNodes(List<Node> nodesList) {
        this.nodesList = nodesList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Taxonomy other = (Taxonomy) object;
        return Objects.equal(this.taxonomyName, other.taxonomyName)
                && Objects.equal(this.nodesList, other.nodesList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taxonomyName", taxonomyName)
                .add("nodesList", nodesList)
                .toString();

    }
}
