package edu.fra.uas;

// v1instantiating - funktioniert
//import edu.fra.uas.v1instantiating.MasterV1;

// v2setter 
//import edu.fra.uas.v2setter.Drilling;
//import edu.fra.uas.v2setter.Journeyman;
//import edu.fra.uas.v2setter.MasterV2;

// v3autowired
import edu.fra.uas.v3autowired.MasterV3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIoCApplication {

// v1instantiating
   //@Autowired //bean erstellt sobald die benötigt wird, daher braucht man "new master" nicht
   //private MasterV1 masterV1; // Master wird initialisiert

    // v3autowired
    @Autowired
    private MasterV3 masterV3;

    public static void main(String[] args) {
        SpringApplication.run(SpringIoCApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // v1instantiating
                //masterV1.delegateWork(); //hier wird die Methode in Master aufgerufen

                // v2setter
                //MasterV2 masterV2 = new MasterV2(); // Instanz von Master angelegt ohne es als bean zu bezeichnen
                //masterV2.setJourneymanAndWork(new Journeyman(), new Drilling()); //legt drilling als Work-Type fest
                //masterV2.delegateWork();//ruft delegateWork auf

                // v3autowired
                masterV3.delegateWork();
            }
        };
        return action;
    }

}
