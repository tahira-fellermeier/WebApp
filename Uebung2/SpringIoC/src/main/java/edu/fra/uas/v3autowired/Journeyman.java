package edu.fra.uas.v3autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class Journeyman {
    @Autowired // erzeuge mir einen instanz sobald notig
    @Qualifier("please Clean")//Programme sucht in allen möglichen Implementierung von Work nach "pleaseDrill" und legt dann ein Objekt an
    Work work;

    public void performWork() {
        work.doWork();
   }
}
