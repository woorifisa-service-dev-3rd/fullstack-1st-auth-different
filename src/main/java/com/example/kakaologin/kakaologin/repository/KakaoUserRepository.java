package com.example.kakaologin.kakaologin.repository;

import com.example.kakaologin.kakaologin.entity.KakaoUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KakaoUserRepository  extends CrudRepository<KakaoUser, Integer> {
    Optional<KakaoUser> findByKakaoId(Long kakao_id); // Long 타입으로 수정

    @Modifying
    @Query("UPDATE KakaoUser k SET k.nickname = :nickname, k.profile_image_url = :profileImageUrl WHERE k.kakaoId = :kakao_id")
    void updateKakaoUserWhenExist(String nickname, String profileImageUrl, Long kakao_id);

}
