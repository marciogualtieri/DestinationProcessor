package com.lonelyplanet.destination.processor.output.generators;

import com.google.common.io.Files;
import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.DestinationOutputFileWriteException;
import com.lonelyplanet.destination.processor.exceptions.DestinationOutputTemplateProcessingException;
import com.lonelyplanet.destination.processor.exceptions.TaxonomyNodeNotFoundException;
import com.lonelyplanet.destination.processor.helpers.TaxonomyHelper;
import com.lonelyplanet.destination.processor.jaxb.model.Destination;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import com.lonelyplanet.destination.processor.output.helpers.HtmlOutputNavigationHelper;
import com.lonelyplanet.destination.processor.output.wrappers.DestinationHtmlOutput;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class HtmlOutputGenerator {
    private Configuration freemarkerConfiguration;
    private final TaxonomyHelper taxonomyHelper;
    private final String outputBaseDirectory;
    private final String freemarkerTemplateFile;
    private final HtmlOutputNavigationHelper htmlOutputNavigationHelper;

    @Autowired
    public HtmlOutputGenerator(TaxonomyHelper taxonomyHelper,
                               HtmlOutputNavigationHelper htmlOutputNavigationHelper,
                               @Value(AppConstants.OUTPUT_BASE_DIRECTORY_PROPERTY_VALUE) String outputBaseDirectory,
                               @Value(AppConstants.FREEMARKER_TEMPLATE_FILE_PROPERTY_VALUE) String freemarkerTemplateFile) {
        this.taxonomyHelper = taxonomyHelper;
        this.outputBaseDirectory = outputBaseDirectory;
        this.freemarkerTemplateFile = freemarkerTemplateFile;
        this.htmlOutputNavigationHelper = htmlOutputNavigationHelper;
    }

    @PostConstruct
    public void configureFreemarker() {
        freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_23);
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(),
                AppConstants.FREEMARKER_TEMPLATES_DIRECTORY);
        freemarkerConfiguration.setDefaultEncoding(AppConstants.OUTPUT_DEFAULT_ENCODING);
        freemarkerConfiguration.setLocale(Locale.US);
        freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public void generate(Destination destination)
            throws TaxonomyNodeNotFoundException, DestinationOutputFileWriteException,
            DestinationOutputTemplateProcessingException {
        Node destinationNode = taxonomyHelper.getNodeByAtlasNodeId(destination.getAtlasId());
        OutputNavigationNode htmlNavigationTreeRootNode =
                htmlOutputNavigationHelper.buildNavigationTreeForNode(destinationNode);
        DestinationHtmlOutput destinationHtmlOutput =
                new DestinationHtmlOutput(destination, htmlNavigationTreeRootNode);
        String outputFileNameAndPath =
                htmlOutputNavigationHelper.buildFileNameAndPathForNode(outputBaseDirectory, destinationNode);
        processFreemarkerTemplate(destinationHtmlOutput, outputFileNameAndPath);
    }

    private void processFreemarkerTemplate(DestinationHtmlOutput destinationHtmlOutput,
                                           String outputFileNameAndPath)
            throws DestinationOutputFileWriteException, DestinationOutputTemplateProcessingException {
        Writer fileWriter = null;
        try {
            Map<String, Object> templatePlaceHolders = new HashMap<>();
            templatePlaceHolders.put(AppConstants.DESTINATION_FREEMARKER_PLACEHOLDER, destinationHtmlOutput);
            Template freemarkerTemplate = freemarkerConfiguration.getTemplate(freemarkerTemplateFile);
            File outputFile = new File(outputFileNameAndPath);
            Files.createParentDirs(outputFile);
            fileWriter = new FileWriter(outputFile);
            freemarkerTemplate.process(templatePlaceHolders, fileWriter);
        } catch (IOException e) {
            throw new DestinationOutputFileWriteException(outputFileNameAndPath, e);
        } catch (TemplateException e) {
            throw new DestinationOutputTemplateProcessingException(freemarkerTemplateFile, e);
        } finally {
            IOUtils.closeQuietly(fileWriter);
        }
    }

}
