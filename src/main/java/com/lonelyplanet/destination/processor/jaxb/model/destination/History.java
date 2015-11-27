package com.lonelyplanet.destination.processor.jaxb.model.destination;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.NormalizedStringXmlAdapter;
import com.lonelyplanet.destination.processor.jaxb.model.destination.common.Overview;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement(name = "history")
@XmlAccessorType(XmlAccessType.FIELD)
public class History {
    @XmlElement(name = "overview")
    private Overview overview;
    @XmlElement(name = "history")
    private List<History> historyList;
    @XmlMixed
    @XmlJavaTypeAdapter(NormalizedStringXmlAdapter.class)
    private List<String> textList;

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
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
        final History other = (History) object;
        return Objects.equal(this.overview, other.overview)
                && Objects.equal(this.historyList, other.historyList)
                && Objects.equal(this.textList, other.textList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("overview", overview)
                .add("historyList", historyList)
                .add("textList", textList)
                .toString();
    }

}
