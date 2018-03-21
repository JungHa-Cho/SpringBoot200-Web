package personal.cjh.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import personal.cjh.webservice.service.PostsService;

/**
 * Created by cho_jeong_ha on 2018-03-21 오후 11:30
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
@Controller
@AllArgsConstructor
public class WebController {

  private PostsService postsService;

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());
    return "main";
  }
}
