package com.example.spring_blog.mail;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SendMailDTO {
    private String email;
    private String token;
    private String mailType;
}
