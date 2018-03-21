package personal.cjh.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import personal.cjh.webservice.domain.posts.Posts;
import personal.cjh.webservice.domain.posts.PostsRepository;
import personal.cjh.webservice.dto.posts.PostsSaveRequestDto;

/**
 * Created by cho_jeong_ha on 2018-03-21 오후 11:39
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

  @Autowired
  private PostsService postsService;

  @Autowired
  private PostsRepository postsRepository;

  @After
  public void cleanup() {
    postsRepository.deleteAll();
  }

  @Test
  public void DTO_데이터가_posts_테이블에_저장된다() {
    // given
    PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
        .author("ppzxc8487@gmail.com")
        .content("테스트")
        .title("테스트 타이틀")
        .build();

    // when
    postsService.save(dto);

    // then
    Posts posts = postsRepository.findAll().get(0);
    assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
    assertThat(posts.getContent()).isEqualTo(dto.getContent());
    assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
  }
}