package custom.scrum.board.common;

import custom.scrum.board.common.error.NotFoundException;
import custom.scrum.board.common.util.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM #{#entityName} e WHERE e.id=:id")
    int delete(long id);

    default void deleteExisted(long id) {
        if (delete(id) == 0) {
            throw new NotFoundException("Entity with id=" + id + " not found");
        }
    }

    default T getExisted(long id) {
        return Util.checkExist(id, findById(id));
    }
}