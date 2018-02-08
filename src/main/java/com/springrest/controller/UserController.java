package com.springrest.controller;

import com.oracle.tools.packager.Log;
import com.springrest.api.MemberLoginClient;
import com.springrest.model.MemberData;
import com.springrest.model.MemberLogin;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    MemberLogin _memberLogin;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getUser(@PathVariable("id") Long id) {
        return "{\"id\":1,\"firstName\":\"DAMITH\",\"lastName\":\"GANEGODA\",\"username\":\"test\",\"created\":\"2016-07-22\",\"updated\":\"2016-07-22\"}";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String userLogin() {
        MemberLoginClient memberLoginClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(MemberLoginClient.class))
                .logLevel(Logger.Level.FULL)
                .encoder(new FormEncoder())
                .target(MemberLoginClient.class, "https://mlc--dev49.cs19.my.salesforce.com/services/oauth2/token");

        String username = "mma_integ@manulife.com.dev49";
        String password = "a1s2d3f4wRGJeDx2eVSDvpEbJDOXMdxkj";
        String client_id = "3MVG9Vik22TUgUpjJp9xnKULQ8CK96blaWHU6P3fOxwouRG9cLliH4TNs9.XSv3ZI2P9wRHPZyP6weqHKmAhE";
        String client_secret = "4957008284902022033";
        String grant_type = "password";

        _memberLogin = memberLoginClient.login(username, password, client_id, client_secret, grant_type);
        return _memberLogin.getAccessToken();
    }

    @RequestMapping(value = "/salesforce", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getSalesForceId() {
        String cert = "12898";
        String plan_num = "29437";

        MemberLoginClient memberLoginClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(MemberLoginClient.class))
                .logLevel(Logger.Level.FULL)
                .target(MemberLoginClient.class, "https://mlc--dev49.cs19.my.salesforce.com/services/apexrest/gbn/v1/member?cert="+cert+"&plan_num="+plan_num);

        MemberData memberData = memberLoginClient.getSalesForceId(_memberLogin.getAccessToken());

        return memberData.getContactC();
    }
}
