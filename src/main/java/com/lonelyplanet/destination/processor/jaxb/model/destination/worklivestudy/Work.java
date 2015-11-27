package com.lonelyplanet.destination.processor.jaxb.model.destination.worklivestudy;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.NormalizedStringXmlAdapter;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "work")
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "business")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> businessList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<String> businessList) {
        this.businessList = businessList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Work other = (Work) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.businessList, other.businessList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("businessList", businessList)
                .toString();
    }
}
