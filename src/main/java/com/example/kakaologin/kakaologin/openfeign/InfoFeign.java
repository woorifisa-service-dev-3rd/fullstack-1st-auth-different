package com.example.kakaologin.kakaologin.openfeign;

import com.example.kakaologin.kakaologin.DTO.KakaoUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "kakaoInfo", url = "https://kapi.kakao.com")
public interface InfoFeign {

    @GetMapping(value = "/v2/user/me")
    KakaoUserInfo getUserInfo(@RequestHeader("Authorization") String authorizationHeader);
}
