package com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation;

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

@XmlRootElement(name = "visas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Visas {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "other")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> otherList;
    @XmlElement(name = "permits")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> permitsList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getOtherList() {
        return otherList;
    }

    public void setOtherList(List<String> otherList) {
        this.otherList = otherList;
    }

    public List<String> getPermitsList() {
        return permitsList;
    }

    public void setPermitsList(List<String> permitsList) {
        this.permitsList = permitsList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Visas other = (Visas) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.otherList, other.otherList)
                && Objects.equal(this.permitsList, other.permitsList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("otherList", otherList)
                .add("permitsList", permitsList)
                .toString();
    }
}
