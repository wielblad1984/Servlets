package service;

import model.Comment;
import model.Post;
import model.User;
import repository.PostRepository;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class PostService {

    private PostRepository postRepository;

    private  UserRepository userRepository;

    public PostService(){
        this.postRepository=PostRepository.getInstance();
        this.userRepository=UserRepository.getInstance();
    }
    public void addNewPost(String postText, int userId){
        Optional<User> userById= userRepository.getUserById(userId);

        if(!userById.isPresent()){
            throw  new IllegalStateException("Can not find user with id : " + userById);

        }
        Post postToAdd = new Post(postText, userById.get());
        postRepository.addPost(postToAdd);

    }
    public List<Post>getAllPosts(){
        return postRepository.getAllPosts();
    }

    public void addCommentToPost(int postId,int userId,String commentText,String commentColor,boolean like){
        Optional<Post>postById=postRepository.getPostById(postId);
        Optional<User>userById=userRepository.getUserById(userId);

        if(!postById.isPresent()||!userById.isPresent()){
            throw new IllegalStateException("User or post not exist");
        }
        Comment comment=new Comment(commentText,commentColor,like,userById.get());
        postById.get().addComment(comment);
    }
    public Post getPostById(int postId){

        return postRepository.getPostById(postId).get();
    }





}
