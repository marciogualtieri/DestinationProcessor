package com.lonelyplanet.destination.processor.helpers;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.TaxonomyFileUnmarshalException;
import com.lonelyplanet.destination.processor.exceptions.TaxonomyNodeNotFoundException;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Taxonomies;
import com.lonelyplanet.destination.processor.messages.AppMessages;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class TaxonomyHelper {
    private static final Logger logger = LoggerFactory.getLogger(TaxonomyHelper.class);
    private final String taxonomyFileNameAndPath;
    private Taxonomies taxonomies;

    @Autowired
    public TaxonomyHelper(@Value(AppConstants.TAXONOMY_FILE_PROPERTY_VALUE) String taxonomyFileNameAndPath) {
        this.taxonomyFileNameAndPath = taxonomyFileNameAndPath;
    }

    @PostConstruct
    public void unmarshalTaxonomyFile() throws TaxonomyFileUnmarshalException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Taxonomies.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            taxonomies =
                    (Taxonomies) unmarshaller.unmarshal(new File(taxonomyFileNameAndPath));
        } catch (Exception e) {
            throw new TaxonomyFileUnmarshalException(taxonomyFileNameAndPath, e);
        }
        logger.debug(AppMessages.TAXONOMY_FILE_UNMARSHALLED_MESSAGE_FORMAT, taxonomyFileNameAndPath);
    }

    public Taxonomies getTaxonomies() {
        return taxonomies;
    }

    public Node getNodeByAtlasNodeId(int atlasNodeId) throws TaxonomyNodeNotFoundException {
        JXPathContext context = JXPathContext.newContext(taxonomies);
        context.getVariables().declareVariable("atlasNodeId", Integer.toString(atlasNodeId));
        Node node;
        try {
            node = (Node) context.getValue(AppConstants.ATLAS_NODE_ID_JXPATH_QUERY);
        } catch (JXPathNotFoundException e) {
            throw new TaxonomyNodeNotFoundException(atlasNodeId, e);
        }
        return node;
    }

}
