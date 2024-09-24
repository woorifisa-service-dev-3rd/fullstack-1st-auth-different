package com.example.kakaologin.kakaologin.Service;

import com.example.kakaologin.kakaologin.DTO.KakaoToken;
import com.example.kakaologin.kakaologin.DTO.KakaoUserInfo;
import com.example.kakaologin.kakaologin.entity.KakaoUser;
import com.example.kakaologin.kakaologin.openfeign.InfoFeign;
import com.example.kakaologin.kakaologin.openfeign.KakaoFeign;
import com.example.kakaologin.kakaologin.repository.KakaoUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoService {

    private final KakaoFeign kakaoFeign;
    private final InfoFeign infoFeign;
    private final KakaoUserRepository kakaoUserRepository;

    @Value("${oauth2.client.response_type}")
    private String responseType;

    @Value("${oauth2.client.client_id}")
    private String clientId;

    @Value("${oauth2.client.redirect_uri}")
    private String redirectUri;

    public KakaoToken getUserToken(String authorization_code)
    {
        KakaoToken kakaoToken =
                kakaoFeign.getAccessToken("authorization_code",clientId,redirectUri,authorization_code);

        log.info(kakaoToken.getAccess_token()+"token 획득 성공");
        return kakaoToken;
    }

    @Transactional
    public KakaoUser getUserInfoandSave(KakaoToken kakaoToken)
    {
        KakaoUserInfo kakaoUserInfo= infoFeign.getUserInfo("Bearer "+kakaoToken.getAccess_token());

        String nickname = kakaoUserInfo.getKakao_account().getProfile().getNickname();
        String profile_img = kakaoUserInfo.getKakao_account().getProfile().getProfile_image_url();
        Long kakao_id = kakaoUserInfo.getId();

        KakaoUser kakaoUser = KakaoUser.builder().nickname(nickname).profile_image_url(profile_img).kakao_id(kakao_id).build();
        if (kakaoUserRepository.findByKakaoId(kakao_id).isEmpty())
        {
            kakaoUserRepository.save(kakaoUser);
        } else
        {
            kakaoUserRepository.updateKakaoUserWhenExist(nickname,profile_img,kakao_id);
        }

        return kakaoUser;
    }



}
