package com.backend.aiplane.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "provider", nullable = false, length = 50)
    private String provider;

    // 로그인 시 추출한 유저 구분용 id
    @Column(name = "provider_id", nullable = false, length = 50)
    private String providerId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, length = 20)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", length = 20)
    private LocalDateTime updatedAt;
}
