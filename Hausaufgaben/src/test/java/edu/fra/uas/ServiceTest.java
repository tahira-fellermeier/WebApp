package edu.fra.uas;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.fra.uas.service.NotenService;

@SpringBootTest
class ServiceTest {

	@Autowired
	private NotenService notenService;

	@Test
	void testService() {
		System.out.println("Testbeginn");
		notenService.addNote("Statistik", 1);
		notenService.addNote("Web", 2);
		System.out.println(notenService.getNotenListe().size());
		assertThat(notenService.getNotenListe().size()).isEqualTo(3);
	}

}
