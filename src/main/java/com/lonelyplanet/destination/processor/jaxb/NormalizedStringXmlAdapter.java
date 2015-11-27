package com.lonelyplanet.destination.processor.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NormalizedStringXmlAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String value) {
        return value.trim();
    }

    @Override
    public String unmarshal(String value) throws Exception {
        return value.trim();
    }
}
