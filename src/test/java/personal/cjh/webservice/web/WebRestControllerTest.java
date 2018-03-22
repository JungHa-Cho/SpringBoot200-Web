package personal.cjh.webservice.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cho_jeong_ha on 2018-03-22 오후 10:04 Blog : https://jungha-cho.github.io/ Github :
 * https://github.com/JungHa-Cho Email : ppzxc8487@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebRestControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void Profile확인() {
    // When
    String profile = this.restTemplate.getForObject("/profile", String.class);

    // Then
    assertThat(profile).isEqualTo("local");
  }
}