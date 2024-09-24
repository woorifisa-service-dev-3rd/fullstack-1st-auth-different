package com.example.kakaologin.kakaologin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KakaoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long kakaoId;

    private String nickname;

    private String profile_image_url;

    @Builder
    public KakaoUser(String nickname, String profile_image_url, Long kakao_id)
    {
        this.nickname=nickname;
        this.profile_image_url=profile_image_url;
        this.kakaoId=kakao_id;
    }
}
