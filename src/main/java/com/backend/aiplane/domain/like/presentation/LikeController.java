package com.backend.aiplane.domain.like.presentation;

import com.backend.aiplane.domain.like.application.LikeService;
import com.backend.aiplane.domain.like.application.dto.CreateLikeDto;
import com.backend.aiplane.domain.like.domain.Like;
import com.backend.aiplane.domain.like.presentation.dto.request.CreateLikeRequest;
import com.backend.aiplane.domain.like.presentation.dto.response.LikeResponse;
import com.backend.aiplane.domain.like.presentation.dto.response.LikeResponses;
import com.backend.aiplane.global.response.SuccessCode;
import com.backend.aiplane.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping()
    public ResponseEntity<SuccessResponse> create(@RequestBody CreateLikeRequest createLikeRequest) {
        Long userId = createLikeRequest.userId();
        Long flightInfoId = createLikeRequest.flightInfoId();

        likeService.create(new CreateLikeDto(userId, flightInfoId));
        return SuccessResponse.of(SuccessCode.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<SuccessResponse<LikeResponses>> check(@PathVariable Long userId){
        List<Like> likes = likeService.getLikesByUserId(userId);
        LikeResponses likeResponses = convertToLikeResponses(likes);

        return SuccessResponse.of(likeResponses);
    }

    private LikeResponses convertToLikeResponses(List<Like> likes){
        List<LikeResponse> likeResponseList = likes.stream().map(
                (l) ->
                        new LikeResponse(l.getId(), l.getFlightInfo().getId())

        ).toList();

        return new LikeResponses(likeResponseList);
    }
}
