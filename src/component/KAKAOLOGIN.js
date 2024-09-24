import React from 'react';
import '../App.css'; // 경로 수정
import kakoimage from '../public/kakao_login_medium_narrow.png';

function KAKAOLOGIN() {
  return (
    <div className="container" style={{ display: 'flex', justifyContent: 'center', alignContent: 'center', alignItems: 'center', flexDirection: 'column', margin: '200px auto' }}>
      <h1>카카오 로그인</h1>
      <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=749bdcb087030221000080af3c6ec751&redirect_uri=http://localhost:8080/kakao/login">
        <img src={kakoimage} alt="카카오 로그인" /> {/* public 폴더 내 이미지 경로 */}
      </a>
    </div>
  );
}


export default KAKAOLOGIN;