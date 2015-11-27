package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.HealthAndSafety;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.MoneyAndCosts;
import com.lonelyplanet.destination.processor.jaxb.model.destination.practicalinformation.Visas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "practical_information")
@XmlAccessorType(XmlAccessType.FIELD)
public class PracticalInformation {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "health_and_safety")
    private HealthAndSafety healthAndSafety;
    @XmlElement(name = "money_and_costs")
    private MoneyAndCosts moneyAndCosts;
    @XmlElement(name = "visas")
    private Visas visas;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public HealthAndSafety getHealthAndSafety() {
        return healthAndSafety;
    }

    public void setHealthAndSafety(HealthAndSafety healthAndSafety) {
        this.healthAndSafety = healthAndSafety;
    }

    public MoneyAndCosts getMoneyAndCosts() {
        return moneyAndCosts;
    }

    public void setMoneyAndCosts(MoneyAndCosts moneyAndCosts) {
        this.moneyAndCosts = moneyAndCosts;
    }

    public Visas getVisas() {
        return visas;
    }

    public void setVisas(Visas visas) {
        this.visas = visas;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final PracticalInformation other = (PracticalInformation) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.healthAndSafety, other.healthAndSafety)
                && Objects.equal(this.moneyAndCosts, other.moneyAndCosts)
                && Objects.equal(this.visas, other.visas);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("healthAndSafety", healthAndSafety)
                .add("moneyAndCosts", moneyAndCosts)
                .add("visas", visas)
                .toString();

    }
}
