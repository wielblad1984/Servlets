package repository;

import model.Post;

import java.util.*;

public class PostRepository {

    private static PostRepository INSTANCE;

    private Map<Integer, Post>postDataBase;

    private PostRepository(){
        postDataBase=new HashMap<>();
    }

    public  static PostRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PostRepository();
            return INSTANCE;
        }
        return INSTANCE;
    }
    public void addPost(Post postToAdd){

        postDataBase.put(postToAdd.getId(),postToAdd);

    }
    public List<Post>getAllPosts(){
     return new ArrayList<Post>(postDataBase.values());

    }
    public Optional<Post> getPostById(int postId){
        if(postDataBase.containsKey(postId)){
            return Optional.of(postDataBase.get(postId));
        }
        return Optional.empty();
    }





}
