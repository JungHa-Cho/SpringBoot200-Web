package personal.cjh.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.Getter;
import personal.cjh.webservice.domain.posts.Posts;

/**
 * Created by cho_jeong_ha on 2018-03-22 오전 12:26
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@Getter
public class PostsMainResponseDto {
  private Long id;
  private String title;
  private String author;
  private String modifiedDate;

  public PostsMainResponseDto(Posts entity) {
    id = entity.getId();
    title = entity.getTitle();
    author = entity.getAuthor();
    modifiedDate = toStringDateTime(entity.getModifiedDate());
  }

  /**
   * Java 8 버전
   */
  private String toStringDateTime(LocalDateTime localDateTime){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return Optional.ofNullable(localDateTime)
        .map(formatter::format)
        .orElse("");
  }

  /**
   * Java 7 버전
   */
  private String toStringDateTimeByJava7(LocalDateTime localDateTime){
    if(localDateTime == null){
      return "";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return formatter.format(localDateTime);
  }
}
