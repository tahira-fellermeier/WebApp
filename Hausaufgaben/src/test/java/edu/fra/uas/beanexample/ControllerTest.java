package edu.fra.uas.beanexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.fra.uas.controller.BeanController;
import edu.fra.uas.service.NotenService;

@SpringBootTest
public class ControllerTest {
    
    @Autowired
    private BeanController beanController;
    @Autowired
    private NotenService messageService;

    @Test
    void testController() {
        assertThat(beanController.putMessage("Das ist ein Test")).isEqualTo(" put messgae: Das ist ein Test");
    }

    @Test
    void incrementController(){
        int expectedCount = 2;
        assertThat(messageService.increment(1)).isEqualTo(expectedCount);

    }

}
