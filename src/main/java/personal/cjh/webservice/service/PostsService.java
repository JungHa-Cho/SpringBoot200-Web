package personal.cjh.webservice.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import personal.cjh.webservice.domain.posts.PostsRepository;
import personal.cjh.webservice.dto.posts.PostsMainResponseDto;
import personal.cjh.webservice.dto.posts.PostsSaveRequestDto;

/**
 * Created by cho_jeong_ha on 2018-03-21 오후 11:36
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@AllArgsConstructor
@Service
public class PostsService {
  private PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto dto){
    return postsRepository.save(dto.toEntity()).getId();
  }

  @Transactional(readOnly = true)
  public List<PostsMainResponseDto> findAllDesc() {
    return postsRepository.findAllDesc()
        .map(PostsMainResponseDto::new)
        .collect(Collectors.toList());
  }
}