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
 * Created by cho_jeong_ha on 2018-03-21 오후 11:32
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void 메인페이지_로딩() {
    // when
    String body = this.restTemplate.getForObject("/", String.class);

    // then
    assertThat(body).contains("스프링부트로 시작하는 웹 서비스");
  }
}