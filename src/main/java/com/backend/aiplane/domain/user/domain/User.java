package com.backend.aiplane.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "users_uuid", columnDefinition = "BINARY(16)", unique = true)
    private UUID userId;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "provider", nullable = false, length = 50)
    private String provider;

    // 로그인 시 추출한 유저 구분용 id
    @Column(name = "provider_id", nullable = false, length = 50)
    private String providerId;

}
