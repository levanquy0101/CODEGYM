package m4.e2_library.repository;

import m4.e2_library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findFirstByCode(String code);
}
