package com.example.kakaologin.kakaologin.openfeign;

import com.example.kakaologin.kakaologin.DTO.KakaoToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "kakao", url = "https://kauth.kakao.com")
public interface KakaoFeign {

    @PostMapping("/oauth/token")
    KakaoToken getAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );


}
