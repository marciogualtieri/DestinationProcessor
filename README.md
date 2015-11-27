### Table of Contents
#### 1. [TEST & BUILD THE APPLICATION](#test-and-build-the-application)
#### 2. [EXECUTE THE JAR IN THE COMMAND LINE](#execute-the-jar-in-the-command-line)
##### 2.1 [Usage](#usage)
##### 2.2 [Examples](#examples)
##### 2.3 [Configuration](#configuration)
#### 3. [ON THE DESIGN CHOICES](#on-the-design-choices)


### <a name="test-and-build-the-application"></a> TEST & BUILD THE APPLICATION

$ mvn clean test package

Java 8 is required due to the use of method references and streams.

### <a name="execute-the-jar-in-the-command-line"></a> EXECUTE THE JAR IN THE COMMAND LINE


#### <a name="usage"></a> Usage

     $ java -jar ./target/destination-processor-1.0-SNAPSHOT-jar-with-dependencies.jar
          [--destinations.file=<destinations file name and path>]
          [--taxonomy.file=<taxonomy file name and path>]
          [--output.base.directory=<output directory for HTML output files>]

The HTML files will then be available in the output base directory:

     output/africa-355064.html
     output/bloemfontein-355615.html
     output/cape-town-355612.html
     ...

#### <a name="examples"></a> Examples

     $ java -jar ./target/destination-processor-1.0-SNAPSHOT-jar-with-dependencies.jar
          --destinations.file=requirements/sample-input-files/destinations.xml
          --taxonomy.file=requirements/sample-input-files/taxonomy.xml
          --output.base.directory=output

     $ java -jar ./target/destination-processor-1.0-SNAPSHOT-jar-with-dependencies.jar

For convenience, the sample  input files  provided  with  the  assignment are available  in the following
directory:

     requirements/sample-input-files

#### <a name="configuration"></a> Configuration

The three parameters, destinations.file, taxonomy.file and output.base.directory are optional, as default
values for these can be configured in the following properties file:

     ./src/main/resources/configuration.properties

These are the default values at the moment:

     default.taxonomy.file = taxonomy.xml
     default.destinations.file = destinations.xml
     default.output.base.directory = output

Logging can be configured in the following file:

     ./src/main/resources/log4j.xml

At the moment, logs are generated in the folder "logs".

### <a name="on-the-design-choices"></a> ON THE DESIGN CHOICES

[JAXB](http://www.oracle.com/technetwork/articles/javase/index-140168.html) is used to unmarshal the XML elements for both destinations and taxonomy files. Due to performance
factors, I have decided to unmarshal the whole  taxonomy and keep it in memory since for each  destination
entry, the correspondent node entry needs  to be searched  in the taxonomy nodes. Also, taxonomy nodes are
fairly small. Node search is performed in memory using Apache [JXPath](https://commons.apache.org/proper/commons-jxpath/).

Given that the destinations  can be quite big (due to destinations' content, such as information, history,
wild life, etc), destination  elements are stream parsed one by  one using [StaX](http://freemarker.incubator.apache.org/) and  then unmarshalled
with JAXB.

The JAXB model (schema) for the XML inputs  (both taxonomy and destinations) is  defined by the classes in
the package com.lonelyplanet.destination.processor.jaxb.model using JAXB annotations.  In the absence of a
schema that could be processed by JAXB to generate the model classes from, I opted for  defining the model
in Java using  annotations  instead  of defining  an XSD file, as I feel  it to be easier  to maintain  by
developers.

For generating the HTML output, I have chosen Freemarker [4]. The following Freemarker template is used to
define the HTML output structure:

     ./src/main/resources/freemarker/templates/destinationOutput.ftl

Business rules (such as parsing the destination data and generating navigation) are then restricted to the
Java code while the actual HTML structure is defined in the template.