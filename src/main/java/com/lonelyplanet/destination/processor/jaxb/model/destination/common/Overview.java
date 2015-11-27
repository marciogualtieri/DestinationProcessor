package com.lonelyplanet.destination.processor.jaxb.model.destination.common;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.NormalizedStringXmlAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "overview")
@XmlAccessorType(XmlAccessType.FIELD)
public class Overview {
    @XmlElement(name = "overview")
    private List<Overview> overviewList;
    @XmlMixed
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> textList;

    public List<Overview> getOverviewList() {
        return overviewList;
    }

    public void setOverviewList(List<Overview> overviewList) {
        this.overviewList = overviewList;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Overview other = (Overview) object;
        return Objects.equal(this.overviewList, other.overviewList)
                && Objects.equal(this.textList, other.textList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overviewList", overviewList)
                .add("textList", textList)
                .toString();
    }

}

