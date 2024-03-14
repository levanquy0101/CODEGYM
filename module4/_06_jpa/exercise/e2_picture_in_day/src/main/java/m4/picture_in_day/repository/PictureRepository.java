package m4.picture_in_day.repository;

import m4.picture_in_day.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> findPictureByDisplayDate(LocalDate date);
}
