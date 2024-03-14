package m4.picture_in_day.service;

import m4.picture_in_day.model.Picture;
import m4.picture_in_day.repository.PictureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Optional<Picture> find(LocalDate localDate){
        return pictureRepository.findPictureByDisplayDate(localDate);
    }
}
