package m4.picture_in_day.controller;

import m4.picture_in_day.model.Comment;
import m4.picture_in_day.model.Picture;
import m4.picture_in_day.service.CommentService;
import m4.picture_in_day.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
public class CommentController {
    private final CommentService commentService;
    private final PictureService pictureService;

    public CommentController(CommentService commentService, PictureService pictureService) {
        this.commentService = commentService;
        this.pictureService = pictureService;
    }

    @GetMapping(value = {"/","/{c}"})
    public String home(Model model, @PathVariable(required = false) Integer c) {
        if(c != null){
            commentService.updateLike(c);
        }

        model.addAttribute("comment", new Comment());
        ZonedDateTime tz = ZonedDateTime.now(ZoneId.of("America/New_York"));
        Optional<Picture> optionalPicture = pictureService.find(tz.toLocalDate());
        model.addAttribute("picture", optionalPicture.orElseGet(Picture::new));

        return "home";
    }

    @PostMapping
    public String save(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }
}
