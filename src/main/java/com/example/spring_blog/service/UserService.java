package com.example.spring_blog.service;


import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.EmailTokens;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository.TokenRepository;
import com.example.spring_blog.data.repository.UserRepository;
import com.example.spring_blog.util.Sha256HashGenerator;
import com.example.spring_blog.util.TokenCreator;
import jdk.nashorn.internal.parser.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> join(UserDTO dto) {
        User user = dto.makeUser();
        user.setName(dto.getName());
        EmailTokens emailTokens = new EmailTokens();

        User result = userRepository.save(user);
        emailTokens.setUser(result);
        emailTokens.setToken(TokenCreator.makeToken());
        emailTokens.setState(0);
        tokenRepository.save(emailTokens);

        return Optional.ofNullable(result);
    }


    public boolean findByEmail(UserDTO dto){
        Optional<User> result = Optional.ofNullable(userRepository.findUserByEmail(dto.getEmail()));
        return result.isPresent() ? true : false;
    }

    public boolean checkEmailToken(Integer userId){
       Optional<User> result =  userRepository.findById(Long.valueOf(userId));
       if(result.get().getEmailTokens().getAuthAt() == null) return false;
       return true;
    }

    public Optional<User> login(UserDTO dto)  {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(dto.getEmail(), Sha256HashGenerator.hashGenerate(dto.getPassword())));
    }

    public User findUserByEmail(UserDTO dto) {

        return userRepository.findUserByEmail(dto.getEmail());
    }

    public Optional<User> updateUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());
        return Optional.ofNullable(userRepository.save(user));
    }

    public void deleteUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());

        userRepository.deleteById(dto.getId());
    }
}
