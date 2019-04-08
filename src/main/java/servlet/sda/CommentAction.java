package servlet.sda;

import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/secret/CommentAction")
public class CommentAction extends HttpServlet {
    private PostService postService;


    @Override
    public void init() throws ServletException {
        this.postService=new PostService();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String postIdParam = req.getParameter("postId");
        String userIdParam = req.getParameter("userId");
        String commentTextParam = req.getParameter("commentText");
        String commentBackgroundColorParam = req.getParameter("commentBackgroundColor");
        String likeParam = req.getParameter("like");

        int postId=Integer.parseInt(postIdParam);
        int userId=Integer.parseInt(userIdParam);
        boolean like=isLikeOn(likeParam);

        postService.addCommentToPost(postId,userId,commentTextParam,commentBackgroundColorParam,like);

        resp.sendRedirect(req.getContextPath() + "/secret/posts.jsp");

    }

    private boolean isLikeOn(String likeParam) {
        return "on".equals(likeParam);
    }
}
