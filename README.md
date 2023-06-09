# spring-boot-logging

You can use Util Logging, Log4j2, and Logback, and for each one pre-configured to use console output with optional file output also available. In Spring Boot by default if you are using starters you will get the Logback implementation.


On the other hand, for public APIs that Spring Boot uses SLF4J (Simple Logging Façade for Java) which allows programmers to choose different logging frameworks.
**
Logging Levels**
Trace, Debug, Info, Warn, Error

**Log Format**
The default Spring Boot log format is shown below
2021-07-08 13:25:09.187  INFO 9769 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-07-08 13:25:09.198  INFO 9769 --- [main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]

Which contains the following information:

Date and Time
Log level (TRACE, DEBUG, INFO, WARN or ERROR)
Process ID
The separator --- to distinguish the start of the log message
Thread name enclosed within square brackets []
Logger name showing the source class
Log message

The log format can be customized using the logging.pattern.console and logging.pattern.file properties in application.properties, for example:

# Logging pattern for the console
logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} - %logger{36} - %msg%n
# Logging pattern for file
logging.pattern.file= %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%

Applying the above property changes the console log format to the following:

2021-07-08 13:41:04 - o.s.b.w.e.tomcat.TomcatWebServer - Tomcat initialized with port(s): 8080 (http)
2021-07-08 13:41:04 - o.a.catalina.core.StandardService - Starting service [Tomcat]


**Command-line VM Options**
java -jar -Dlogging.level.<logger-name>=<level> application.jar
  
java -jar -Dlogging.level.root=DEBUG application.jar
java -jar -Dlogging.level.org.springframework=TRACE application.jar
  
**Properties files**

logging.level.root=DEBUG
logging.level.org.springframework=TRACE
  
Logger initiation
@Component
public class LoggingTest {
    Logger logger = LoggerFactory.getLogger(LoggingTest.class);
    public void test(){
        logger.trace("trace");
        logger.info("info");
    }
}
  
@Slf4j
@Component
public class LoggingTest {
    public void test(){
        log.trace("trace");
        log.info("info");
    }
}
  
**Log Output**

**File Output**:

logging.file.name=app-log-file.log
logging.file.path=/var/log
  
**Log Format**

logging.pattern.console=<Customized pattern>
  
**Custom Log Configuration**

Logback: logback-spring.xml, logback-spring.groovy, logback.xml, or logback.groovy

Log4j2: log4j2-spring.xml or log4j2.xml

JDK (Java Util Logging): logging.properties
  
**Logback Configuration**

A file in the classpath with one of the following names will be automatically loaded by Spring boot and override the default configuration:

logback.xml
logback-spring.xml

  
**File Rotation**

By default log files rotate when they reach 10 MB but if you are using The Logback you have extra advance options to enhance the file rotation configurations. Some of the rotation policies are as follow:

logging.logback.rollingpolicy.file-name-pattern: The filename pattern is used to create log archives.

logging.logback.rollingpolicy.clean-history-on-start: If log archive cleanup should occur when the application starts.

logging.logback.rollingpolicy.max-file-size: The maximum size of the log file before it is archived.

logging.logback.rollingpolicy.total-size-cap: The maximum amount of size log archives can take before being deleted.

logging.logback.rollingpolicy.max-history: The maximum number of archive log files to keep (defaults to 7).
  
**Logback Extensions**
  
There are some extra extensions to The Logback in Spring Boot that you can benefit from if you are using logback-spring.xml configuration file.
