package com.example.spring_blog.service;


import com.example.spring_blog.data.dao.UserDAO;
import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository.UserRepository;
import com.example.spring_blog.util.Sha256HashGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private UserDAO userDAO = new UserDAO();


    public Optional<User> findById(Integer id){
        return userDAO.find(User.class,id);
    }

    public List<User> findAllUser(){
        return userDAO.findAllWithNamedQuery("User.findAllUser");
    }

    public Optional<User> join(UserDTO dto) {
        User user = dto.makeUser();
        user.setName(dto.getName());
        return userDAO.create(user);
    }

    public boolean findByEmail(UserDTO dto){
        Optional<User> result = Optional.ofNullable(userRepository.findUserByEmail(dto.getEmail()));
        return result.isPresent() ? true : false;
    }

    public boolean checkEmailToken(Integer userId){
       Optional<User> result =  userDAO.find(User.class,userId);
       if(result.get().getEmailTokens().getAuthAt() == null) return false;
       return true;
    }

    public Optional<User> login(UserDTO dto)  {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(dto.getEmail(), Sha256HashGenerator.hashGenerate(dto.getPassword())));
    }

    public User findUserByEmail(UserDTO dto) {

        return userDAO.findByEmail(dto.getEmail()).get();
    }

    public Optional<User> updateUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());
        return userDAO.update(user);
    }

    public boolean deleteUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());

        return userDAO.delete(User.class,dto.getId());
    }
}
