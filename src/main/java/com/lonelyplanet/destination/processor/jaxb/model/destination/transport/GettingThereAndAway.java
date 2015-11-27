package com.lonelyplanet.destination.processor.jaxb.model.destination.transport;

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

@XmlRootElement(name = "getting_there_and_away")
@XmlAccessorType(XmlAccessType.FIELD)
public class GettingThereAndAway {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "air")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> airList;
    @XmlElement(name = "land")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> landList;
    @XmlElement(name = "boat")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> boatList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getAirList() {
        return airList;
    }

    public void setAirList(List<String> airList) {
        this.airList = airList;
    }

    public List<String> getLandList() {
        return landList;
    }

    public void setLandList(List<String> landList) {
        this.landList = landList;
    }

    public List<String> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<String> boatList) {
        this.boatList = boatList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final GettingThereAndAway other = (GettingThereAndAway) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.airList, other.airList)
                && Objects.equal(this.landList, other.landList)
                && Objects.equal(this.boatList, other.boatList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("airList", airList)
                .add("landList", landList)
                .add("boatList", boatList)
                .toString();
    }
}
