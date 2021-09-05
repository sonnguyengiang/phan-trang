package code.repository;

import code.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IStudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(value = "SELECT * FROM baitap.student where name like concat('%',:name,'%')", nativeQuery = true)
    public ArrayList<Student> findAllByName(@Param("name") String findName);

    Page<Student> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM baitap.student where name like concat('%',:name,'%')", nativeQuery = true)
    public Page<Student> findAllByNamePage(@Param("name") String findName, Pageable pageable);

}
