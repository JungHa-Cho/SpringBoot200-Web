package personal.cjh.webservice.domain.posts;

import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by cho_jeong_ha on 2018-03-20 오후 10:32
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 * Desc : DAO, JPA에선 REPOSITORY라 하며, 상속시 CRUD 자동 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long>{

  @Query("SELECT p " +
      "FROM Posts p " +
      "ORDER BY p.id DESC")
  Stream<Posts> findAllDesc();
}