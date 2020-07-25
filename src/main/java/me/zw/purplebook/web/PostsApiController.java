package me.zw.purplebook.web;

import lombok.RequiredArgsConstructor;
import me.zw.purplebook.service.PostsService;
import me.zw.purplebook.web.dto.PostsResponseDto;
import me.zw.purplebook.web.dto.PostsSaveRequestDto;
import me.zw.purplebook.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    /**
     * 수정 API
     *
     * @param id
     * @param requestDto
     * @return
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    /**
     * 조회 API
     *
     * @param id
     * @return
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }


    /**
     * 삭제 API
     * @param id
     * @return
     */
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
