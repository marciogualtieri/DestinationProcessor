package com.lonelyplanet.destination.processor.jaxb.model.destination.weather;

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

@XmlRootElement(name = "when_to_go")
@XmlAccessorType(XmlAccessType.FIELD)
public class WhenToGo {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "climate")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> climateList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getClimateList() {
        return climateList;
    }

    public void setClimateList(List<String> climateList) {
        this.climateList = climateList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final WhenToGo other = (WhenToGo) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.climateList, other.climateList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("climateList", climateList)
                .toString();
    }
}
