package com.lonelyplanet.destination.processor.output.helpers;

import com.google.common.collect.Lists;
import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.jaxb.model.taxonomy.Node;
import com.lonelyplanet.destination.processor.output.OutputNavigationNode;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HtmlOutputNavigationHelper {

    public OutputNavigationNode buildNavigationTreeForNode(Node node) {
        OutputNavigationNode lastParentOutputNavigationNode = null;
        OutputNavigationNode htmlOutputNavigationTreeRootNode = null;
        for (Node parentNode : node.getParentNodes()) {
            OutputNavigationNode parentNodeOutputNavigationNode =
                    buildNavigationNodeForNode(parentNode);
            if (lastParentOutputNavigationNode == null) {
                lastParentOutputNavigationNode = parentNodeOutputNavigationNode;
                htmlOutputNavigationTreeRootNode = parentNodeOutputNavigationNode;
            } else {
                lastParentOutputNavigationNode =
                        updateAndReturnLastNavigationNode(lastParentOutputNavigationNode,
                                parentNodeOutputNavigationNode);
            }
        }
        OutputNavigationNode nodeOutputNavigationNode = buildChildNavigationTreeForNode(node);
        if (htmlOutputNavigationTreeRootNode == null) {
            htmlOutputNavigationTreeRootNode = nodeOutputNavigationNode;
        } else {
            lastParentOutputNavigationNode.setOutputNavigationNodeList(
                    Lists.newArrayList(nodeOutputNavigationNode));
        }
        return htmlOutputNavigationTreeRootNode;
    }

    public String buildFileNameAndPathForNode(String outputBaseDirectory,
                                              Node destinationNode) {
        Path fileNameAndPath = Paths.get(outputBaseDirectory,
                buildFileNameForNode(destinationNode));
        return fileNameAndPath.toString();
    }

    private String buildNormalizedNameForNode(Node node) {
        return node.geNodeName().replaceAll(AppConstants.BLANK_CHAR_REGEX,
                AppConstants.BLANK_CHAR_REPLACEMENT).toLowerCase();
    }

    private String buildFileNameForNode(Node node) {
        return String.format(AppConstants.OUTPUT_FILE_NAME_AND_PATH_TEMPLATE,
                buildNormalizedNameForNode(node), node.getAtlasNodeId());
    }

    private OutputNavigationNode updateAndReturnLastNavigationNode(
            OutputNavigationNode lastParentOutputNavigationNode,
            OutputNavigationNode nodeOutputNavigationNode) {
        lastParentOutputNavigationNode.setOutputNavigationNodeList(
                Lists.newArrayList(nodeOutputNavigationNode));
        lastParentOutputNavigationNode = nodeOutputNavigationNode;
        return lastParentOutputNavigationNode;
    }

    private OutputNavigationNode buildChildNavigationTreeForNode(Node node) {
        OutputNavigationNode outputNavigationNode = buildNavigationNodeForNode(node);
        List<Node> childNodes = node.getNodesList();
        List<OutputNavigationNode> childrenOutputNavigationNode = new ArrayList<>();
        if (childNodes != null) {
            childrenOutputNavigationNode.addAll(childNodes
                    .stream().map(this::buildChildNavigationTreeForNode)
                    .collect(Collectors.toList()));
            outputNavigationNode.setOutputNavigationNodeList(childrenOutputNavigationNode);
        }
        return outputNavigationNode;
    }

    private OutputNavigationNode buildNavigationNodeForNode(Node node) {
        return new OutputNavigationNode(
                node.geNodeName(),
                buildFileNameForNode(node));
    }
}
