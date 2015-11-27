package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.weather.WhenToGo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weather")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "when_to_go")
    private WhenToGo whenToGo;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public WhenToGo getWhenToGo() {
        return whenToGo;
    }

    public void setWhenToGo(WhenToGo whenToGo) {
        this.whenToGo = whenToGo;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Weather other = (Weather) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.whenToGo, other.whenToGo);

    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("whenToGo", whenToGo)
                .toString();
    }
}
