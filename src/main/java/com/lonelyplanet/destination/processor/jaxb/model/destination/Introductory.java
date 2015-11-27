package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.introductory.Introduction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "introductory")
@XmlAccessorType(XmlAccessType.FIELD)
public class Introductory {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "introduction")
    private Introduction introduction;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Introductory other = (Introductory) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.introduction, other.introduction);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("introduction", introduction)
                .toString();

    }
}
