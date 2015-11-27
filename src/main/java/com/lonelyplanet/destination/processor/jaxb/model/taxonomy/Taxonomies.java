package com.lonelyplanet.destination.processor.jaxb.model.taxonomy;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "taxonomies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Taxonomies {
    @XmlElement(name = "taxonomy")
    private List<Taxonomy> taxonomyList;

    public List<Taxonomy> getTaxonomyList() {
        return taxonomyList;
    }

    public void setTaxonomyList(List<Taxonomy> taxonomyList) {
        this.taxonomyList = taxonomyList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Taxonomies other = (Taxonomies) object;
        return Objects.equal(this.taxonomyList, other.taxonomyList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taxonomyList", taxonomyList)
                .toString();

    }
}
