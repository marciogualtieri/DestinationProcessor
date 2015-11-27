package com.lonelyplanet.destination.processor.jaxb.model.destination.wildlife;

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

@XmlRootElement(name = "animals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animals {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "mammals")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> mammalsList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getMammalsList() {
        return mammalsList;
    }

    public void setMammalsList(List<String> mammalsList) {
        this.mammalsList = mammalsList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Animals other = (Animals) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.mammalsList, other.mammalsList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("mammalsList", mammalsList)
                .toString();
    }
}
