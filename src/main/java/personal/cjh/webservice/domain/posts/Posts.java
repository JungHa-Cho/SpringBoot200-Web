package personal.cjh.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import personal.cjh.webservice.domain.BaseTimeEntity;

/**
 * Created by cho_jeong_ha on 2018-03-20 오후 10:32
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 기본 생성자 자동 추가, protected로 제한, 기본 생성자는 막히지만, JPA에서 ENTITY 생성은 허용
@Getter
@Entity // 테이블과 링크될 클래스를 지칭, PostTable -> FROM post_table
public class Posts extends BaseTimeEntity {

  @Id // PK
  @GeneratedValue // AUTO_INCREMENT
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  // 궂이 명시하지 않더라도 Entity 클래스의 모든 변수는 컬럼
  // 속성을 명시하고자할때
  @Column
  private String author;

  // 생성시 인자값 정확하게 명시 가능
  @Builder
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
