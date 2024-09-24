package com.example.kakaologin.kakaologin.DTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KakaoLoginDto {
    String grant_type ;

    String client_id;

    String redirect_uri;
    String code;
}
