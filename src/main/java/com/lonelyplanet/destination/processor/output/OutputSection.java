package com.lonelyplanet.destination.processor.output;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

public class OutputSection {
    private String title = null;
    private List<String> lines = null;
    private List<OutputSection> outputSectionList = null;

    public OutputSection(String title, List<String> lines) {
        this.title = title;
        this.lines = lines;
    }

    public OutputSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public List<OutputSection> getOutputSectionList() {
        return outputSectionList;
    }

    public void setOutputSectionList(List<OutputSection> outputSectionList) {
        this.outputSectionList = outputSectionList;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        final OutputSection other = (OutputSection) object;
        return Objects.equal(this.title, other.title)
                && Objects.equal(this.lines, other.lines)
                && Objects.equal(this.outputSectionList, other.outputSectionList);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("lines", lines)
                .add("outputSectionList", outputSectionList)
                .toString();
    }

}
