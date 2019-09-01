package alpha;


import org.apache.logging.log4j.*;

public class Demo_1 {

    private static Logger log = LogManager.getLogger(Demo_1.class.getName());


    public static void main(String[] args) {

        log.debug("I have clicked on button");
        log.info("Button is displayed");
        log.error("Button is not displayed ");
        log.fatal("button is missing");


    }
}
