package com.springrest.api;

import com.springrest.model.MemberData;
import com.springrest.model.MemberLogin;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface MemberLoginClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    MemberLogin login(@Param("username") String username, @Param("password") String password, @Param("client_id") String client_id, @Param("client_secret") String client_secret, @Param("grant_type") String grant_type);


    @RequestLine("GET")
    @Headers("Authorization: Bearer {token}")
    MemberData getSalesForceId(@Param("token") String token);
}
