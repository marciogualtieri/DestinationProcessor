package com.lonelyplanet.destination.processor;

import com.lonelyplanet.destination.processor.constants.AppConstants;
import com.lonelyplanet.destination.processor.exceptions.DestinationsFileUnmarshalException;
import com.lonelyplanet.destination.processor.messages.AppMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

/**
 * Main class, used to process destinations from the command-line.
 */
public class CommandLineInterface {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineInterface.class);

    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
    private final CommandLinePropertySource commandLinePropertySource;

    public CommandLineInterface(CommandLinePropertySource commandLinePropertySource) {
        this.commandLinePropertySource = commandLinePropertySource;
    }

    public static void main(String[] args) {
        try {
            CommandLineInterface cli =
                    new CommandLineInterface(new SimpleCommandLinePropertySource(args));
            cli.runProcessor();
        } catch (DestinationsFileUnmarshalException e) {
            logger.error(AppMessages.PROCESSING_DESTINATIONS_EXCEPTION_MESSAGE, e);
        }
    }

    public void runProcessor() throws DestinationsFileUnmarshalException {
        setCommandLinePropertySource(commandLinePropertySource);
        context.setConfigLocation(AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH);
        context.registerShutdownHook();
        context.refresh();
        context.start();
        try {
            Processor processor = context.getBean(Processor.class);
            processor.processAllDestinations();
        } finally {
            context.close();
        }
    }

    private void setCommandLinePropertySource(CommandLinePropertySource commandLinePropertySource) {
        for (String propertyName : commandLinePropertySource.getPropertyNames()) {
            System.setProperty(propertyName, commandLinePropertySource.getProperty(propertyName));
        }
    }

}
