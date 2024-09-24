package com.example.kakaologin.kakaologin.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class KakaoToken {
    String token_type;
    String access_token;
    Integer expires_in;
    String refresh_token;
    Integer refresh_token_expires_in;
}
