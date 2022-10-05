package com.example.spring_blog.data.dto.user;


import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.util.Sha256HashGenerator;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;

    public User makeUser(){
        return User.builder()
                .id(getId())
                .email(getEmail())
                .password(Sha256HashGenerator.hashGenerate(getPassword()))
                .name(getName())
                .build();
    }
}
