package com.backend.aiplane.domain.like.application;

import com.backend.aiplane.domain.flightInfo.application.FlightInfoService;
import com.backend.aiplane.domain.flightInfo.domain.FlightInfo;
import com.backend.aiplane.domain.like.application.dto.CreateLikeDto;
import com.backend.aiplane.domain.like.domain.Like;
import com.backend.aiplane.domain.like.domain.LikeRepository;
import com.backend.aiplane.domain.user.application.UserService;
import com.backend.aiplane.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserService userService;
    private final FlightInfoService flightInfoService;

    public void create(CreateLikeDto createLikeDto){
        Long userId = createLikeDto.getUserId();
        Long flightInfoId = createLikeDto.getFlightInfoId();

        try{
            getLikeByUserIdAndFlightInfoId(userId, flightInfoId);
        }catch (IllegalArgumentException e){
            User user = userService.getUserByUserId(userId);
            FlightInfo flightInfo = flightInfoService.getFlightInfoById(flightInfoId);

            Like createdLike = Like.builder()
                    .user(user)
                    .flightInfo(flightInfo)
                    .build();

            likeRepository.save(createdLike);
        }
    }

    public Like getLikeById(Long id){
        Like like = likeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Like id = " + id)
        );

        return like;
    }

    public Like getLikeByUserIdAndFlightInfoId(Long userId, Long flightInfoId){
        Like like = likeRepository.findByUserIdAndFlightInfoId(userId, flightInfoId).orElseThrow(
                () -> new IllegalArgumentException("No Like userId = " + userId + " flightInfoId = " + flightInfoId)
        );

        return like;
    }

    public List<Like> getLikesByUserId(Long userId){
        List<Like> userLikes = likeRepository.findAllByUserId(userId);
        return userLikes;
    }
}
