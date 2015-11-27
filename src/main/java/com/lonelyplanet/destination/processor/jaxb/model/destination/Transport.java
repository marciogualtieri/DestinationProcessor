package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingAround;
import com.lonelyplanet.destination.processor.jaxb.model.destination.transport.GettingThereAndAway;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "animals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transport {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElements({
            @XmlElement(name = "getting_around"),
            @XmlElement(name = "getting_there_and_around")
    })
    private GettingAround gettingAround;
    @XmlElement(name = "getting_there_and_away")
    private GettingThereAndAway gettingThereAndAway;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public GettingAround getGettingAround() {
        return gettingAround;
    }

    public void setGettingAround(GettingAround gettingAround) {
        this.gettingAround = gettingAround;
    }

    public GettingThereAndAway getGettingThereAndAway() {
        return gettingThereAndAway;
    }

    public void setGettingThereAndAway(GettingThereAndAway gettingThereAndAway) {
        this.gettingThereAndAway = gettingThereAndAway;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Transport other = (Transport) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.gettingAround, other.gettingAround)
                && Objects.equal(this.gettingThereAndAway, other.gettingThereAndAway);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("gettingAround", gettingAround)
                .add("gettingThereAndAway", gettingThereAndAway)
                .toString();

    }
}
