package com.lonelyplanet.destination.processor.jaxb.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.lonelyplanet.destination.processor.jaxb.model.destination.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "destination")
@XmlAccessorType(XmlAccessType.FIELD)
public class Destination {
    @XmlAttribute(name = "atlas_id")
    private int atlasId;
    @XmlAttribute(name = "asset_id")
    private int assetId;
    @XmlAttribute(name = "title")
    private String title;
    @XmlAttribute(name = "title-ascii")
    private String titleAscii;
    @XmlElement(name = "history")
    private List<History> historyList;
    @XmlElement(name = "introductory")
    private Introductory introductory;
    @XmlElement(name = "practical_information")
    private PracticalInformation practicalInformation;
    @XmlElement(name = "transport")
    private Transport transport;
    @XmlElement(name = "weather")
    private Weather weather;
    @XmlElement(name = "work_live_study")
    private WorkLiveStudy workLiveStudy;
    @XmlElement(name = "wild_life")
    private WildLife wildLife;

    public int getAtlasId() {
        return atlasId;
    }

    public void setAtlasId(int atlasId) {
        this.atlasId = atlasId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleAscii() {
        return titleAscii;
    }

    public void setTitleAscii(String titleAscii) {
        this.titleAscii = titleAscii;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public Introductory getIntroductory() {
        return introductory;
    }

    public void setIntroductory(Introductory introductory) {
        this.introductory = introductory;
    }

    public PracticalInformation getPracticalInformation() {
        return practicalInformation;
    }

    public void setPracticalInformation(PracticalInformation practicalInformation) {
        this.practicalInformation = practicalInformation;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public WorkLiveStudy getWorkLiveStudy() {
        return workLiveStudy;
    }

    public void setWorkLiveStudy(WorkLiveStudy workLiveStudy) {
        this.workLiveStudy = workLiveStudy;
    }

    public WildLife getWildLife() {
        return wildLife;
    }

    public void setWildLife(WildLife wildLife) {
        this.wildLife = wildLife;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final Destination other = (Destination) object;
        return Objects.equal(this.atlasId, other.atlasId)
                && Objects.equal(this.assetId, other.assetId)
                && Objects.equal(this.title, other.title)
                && Objects.equal(this.titleAscii, other.titleAscii)
                && Objects.equal(this.historyList, other.historyList)
                && Objects.equal(this.introductory, other.introductory)
                && Objects.equal(this.practicalInformation, other.practicalInformation)
                && Objects.equal(this.transport, other.transport)
                && Objects.equal(this.weather, other.weather)
                && Objects.equal(this.workLiveStudy, other.workLiveStudy)
                && Objects.equal(this.wildLife, other.wildLife);

    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("atlasId", atlasId)
                .add("assetId", assetId)
                .add("title", title)
                .add("titleAscii", titleAscii)
                .add("historyList", historyList)
                .add("introductory", introductory)
                .add("practicalInformation", practicalInformation)
                .add("transport", transport)
                .add("weather", weather)
                .add("workLiveStudy", workLiveStudy)
                .add("wildLife", wildLife)
                .toString();

    }
}
