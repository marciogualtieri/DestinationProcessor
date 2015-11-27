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

@XmlRootElement(name = "money_and_costs")
@XmlAccessorType(XmlAccessType.FIELD)
public class MoneyAndCosts {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "money")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> moneyList;
    @XmlElement(name = "costs")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> costsList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<String> moneyList) {
        this.moneyList = moneyList;
    }

    public List<String> getCostsList() {
        return costsList;
    }

    public void setCostsList(List<String> costsList) {
        this.costsList = costsList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final MoneyAndCosts other = (MoneyAndCosts) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.moneyList, other.moneyList)
                && Objects.equal(this.costsList, other.costsList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("moneyList", moneyList)
                .add("costsList", costsList)
                .toString();
    }
}
