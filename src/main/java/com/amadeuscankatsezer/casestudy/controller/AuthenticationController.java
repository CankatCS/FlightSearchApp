package com.amadeuscankatsezer.casestudy.controller;

import com.amadeuscankatsezer.casestudy.dto.JwtAuthenticationResponseDto;
import com.amadeuscankatsezer.casestudy.dto.SignInRequestDto;
import com.amadeuscankatsezer.casestudy.dto.SignUpRequestDto;
import com.amadeuscankatsezer.casestudy.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cankat Sezer
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponseDto signup(@RequestBody SignUpRequestDto request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponseDto signin(@RequestBody SignInRequestDto request) {
        return authenticationService.signin(request);
    }
}

