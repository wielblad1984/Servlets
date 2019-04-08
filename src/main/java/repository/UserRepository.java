package repository;

import model.User;

import java.util.*;

public class UserRepository {

    private static UserRepository INSTANCE;

    public static UserRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserRepository();
            return INSTANCE;
        }
        return INSTANCE;
    }
    private Map<Integer, User> userMap;

    private UserRepository(){
        this.userMap=new HashMap<>();
    }

    public synchronized Optional<User>addUser(User user){
        if(userMap.containsKey(user.getId())){
            return Optional.empty();
        }
        userMap.put(user.getId(),user);
        return Optional.of(user);

    }

    public List<User> getAllUsers(){

        return new ArrayList<>(userMap.values());
    }

    public Optional<User>getUserByLogin(String login){
        return userMap.values().stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
    }
    public Optional<User>getUserById(int id){

        return Optional.ofNullable(userMap.get(id));
    }
}
