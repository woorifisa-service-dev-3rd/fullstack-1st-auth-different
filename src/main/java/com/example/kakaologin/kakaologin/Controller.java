package com.example.kakaologin.kakaologin;

import com.example.kakaologin.kakaologin.Service.KakaoService;
import com.example.kakaologin.kakaologin.DTO.KakaoToken;
import com.example.kakaologin.kakaologin.entity.KakaoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final KakaoService kakaoService;

    @GetMapping("/kakao/login")
    public KakaoUser kakaoLogin(@RequestParam("code") String authorization_code)
    {
        System.out.println("로그인리다이랙트성공"+authorization_code);
        KakaoToken kakaoToken = kakaoService.getUserToken(authorization_code);
        return kakaoService.getUserInfoandSave(kakaoToken);

    }

}
