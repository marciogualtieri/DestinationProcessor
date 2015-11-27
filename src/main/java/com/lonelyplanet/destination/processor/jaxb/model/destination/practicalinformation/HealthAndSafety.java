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

@XmlRootElement(name = "health_and_safety")
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthAndSafety {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "before_you_go")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> beforeYouGoList;
    @XmlElement(name = "dangers_and_annoyances")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> dangersAndAnnoyancesList;
    @XmlElement(name = "in_transit")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> inTransitList;
    @XmlElement(name = "while_youre_there")
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> whileYoureThereList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<String> getBeforeYouGoList() {
        return beforeYouGoList;
    }

    public void setBeforeYouGoList(List<String> beforeYouGoList) {
        this.beforeYouGoList = beforeYouGoList;
    }

    public List<String> getDangersAndAnnoyancesList() {
        return dangersAndAnnoyancesList;
    }

    public void setDangersAndAnnoyancesList(List<String> dangersAndAnnoyancesList) {
        this.dangersAndAnnoyancesList = dangersAndAnnoyancesList;
    }

    public List<String> getInTransitList() {
        return inTransitList;
    }

    public void setInTransitList(List<String> inTransitList) {
        this.inTransitList = inTransitList;
    }

    public List<String> getWhileYouAreThereList() {
        return whileYoureThereList;
    }

    public void setWhileYouAreThereList(List<String> whileYouAreThereList) {
        this.whileYoureThereList = whileYouAreThereList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final HealthAndSafety other = (HealthAndSafety) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.beforeYouGoList, other.beforeYouGoList)
                && Objects.equal(this.dangersAndAnnoyancesList, other.dangersAndAnnoyancesList)
                && Objects.equal(this.inTransitList, other.inTransitList)
                && Objects.equal(this.whileYoureThereList, other.whileYoureThereList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("beforeYouGoList", beforeYouGoList)
                .add("dangersAndAnnoyancesList", dangersAndAnnoyancesList)
                .add("inTransitList", inTransitList)
                .add("whileYoureThereList", whileYoureThereList)
                .toString();
    }
}
