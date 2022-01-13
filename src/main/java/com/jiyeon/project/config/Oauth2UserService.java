package com.jiyeon.project.config;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class Oauth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        /**
         * userRequest 에서는 getAccessToken, clientRegistration.. 등의 메서드로 받은 값을 가져올 수 있다.
         * ex) userRequest.getAccessToken();
         * clientRegistration() --> 구글에서 받은 회원 프로필로 새로운 Employee 가입을 시켜준다.
         */


        OAuth2User oauth2User = super.loadUser(userRequest);


        return super.loadUser(userRequest);
    }

}
