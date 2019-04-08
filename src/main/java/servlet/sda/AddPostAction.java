package servlet.sda;

import repository.PostRepository;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebServlet(urlPatterns = "/secret/AddPostAction")
public class AddPostAction extends HttpServlet {
    private PostService postService;

    @Override
    public void init() throws ServletException {
        postService=new PostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postText = req.getParameter("postText");

        Integer loggedUserId=(Integer)req.getSession().getAttribute("loggerUserId");

        postService.addNewPost(postText,loggedUserId);

        resp.sendRedirect(req.getContextPath()+ "/secret/posts.jsp");
    }
}
