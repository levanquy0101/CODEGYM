package m4.picture_in_day.service;

import m4.picture_in_day.model.Comment;
import m4.picture_in_day.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void updateLike(int id){
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setLiked(comment.getLiked()+1);
            commentRepository.save(comment);
        }
    }

    public void save(Comment comment){
        commentRepository.save(comment);
    }
}
