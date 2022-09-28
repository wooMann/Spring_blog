package com.example.spring_blog.mail;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MailServiceMessageDTO {
    private String title;
    private String body;
}
