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

    private final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
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
        setupApplicationContext();
        applicationContext.start();
        try {
            Processor processor = applicationContext.getBean(Processor.class);
            long startTime = System.nanoTime();
            processor.processAllDestinations();
            long endTime = System.nanoTime();
            logger.info(AppMessages.PROCESSING_DURATION_MESSAGE_FORMAT,
                    elapsedTimeInMilliSecs(startTime, endTime));
        } finally {
            applicationContext.close();
        }
    }

    private long elapsedTimeInMilliSecs(long startTimeInNanoSecs, long endTimeInNanoSecs) {
        return (endTimeInNanoSecs - startTimeInNanoSecs) / AppConstants.NANOSECS_IN_ONE_MILLISEC;
    }

    private void setupApplicationContext() {
        setupCommandLinePropertySource(commandLinePropertySource);
        applicationContext.setConfigLocation(AppConstants.APPLICATION_CONTEXT_FILE_NAME_AND_PATH);
        applicationContext.registerShutdownHook();
        applicationContext.refresh();
    }

    private void setupCommandLinePropertySource(CommandLinePropertySource commandLinePropertySource) {
        for (String propertyName : commandLinePropertySource.getPropertyNames()) {
            System.setProperty(propertyName, commandLinePropertySource.getProperty(propertyName));
        }
    }

}
