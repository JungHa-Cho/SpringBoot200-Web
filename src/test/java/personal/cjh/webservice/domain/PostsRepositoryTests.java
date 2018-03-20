package personal.cjh.webservice.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import personal.cjh.webservice.domain.posts.Posts;
import personal.cjh.webservice.domain.posts.PostsRepository;

/**
 * Created by cho_jeong_ha on 2018-03-20 오후 10:49
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTests {

  @Autowired
  PostsRepository postsRepository;

  /**
   * 이후 테스트 코드에 영향을 끼치지 않기 위해 테스트가 끝날때 마다 respository 전체 비우는 코드
   */
  @After
  public void cleanup() {
    postsRepository.deleteAll();
  }

  @Test
  public void 게시글저장_불러오기() {
    //given
    LocalDateTime now = LocalDateTime.now();
    postsRepository.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("jojoldu@gmail.com")
        .build());

    //when
    List<Posts> postsList = postsRepository.findAll();

    //then
    Posts posts = postsList.get(0);
    assertThat(posts.getTitle(), is("테스트 게시글"));
    assertThat(posts.getContent(), is("테스트 본문"));
    assertTrue(posts.getCreatedDate().isAfter(now));
    assertTrue(posts.getModifiedDate().isAfter(now));
  }
}
