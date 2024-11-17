package edu.fra.uas.v2setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Drilling implements Work { //Muss doWork from Work implementieren

    private static final Logger LOGGER = LoggerFactory.getLogger(Drilling.class); //logger erstellt

    public void doWork() {
        LOGGER.info(" --> drill a hole into the wall"); //message wird geloggt
    }
}
