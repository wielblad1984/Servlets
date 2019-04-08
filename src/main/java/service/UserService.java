package service;

import model.User;
import repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;


    public UserService() {
        this.userRepository = UserRepository.getInstance();
    }

    public Optional<User>createUser(String login, String password){
        User user= new User(login,password,Instant.now());
        return userRepository.addUser(user);

    }
    public Optional<User>getUser(int id)
    {
        return userRepository.getUserById(id);
    }


    public List<User>getAllUsers(){
        return userRepository.getAllUsers();

    }
    public Optional<User>getUserByLogin(String login)
    {
        return userRepository.getUserByLogin(login);
    }
}
