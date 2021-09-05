package code.services;

import code.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IStudentServices {
    Student save(Student student);

    Student findById(long id);

    ArrayList<Student> findAll();

    ArrayList<Student> findAllByName(String name);

    void Delete(Student student);

    void edit(Student student);

    Page<Student> findAllPage(Pageable pageable);

    ArrayList<Student> xapxep();

    Page<Student> findAllNamePage(String name, Pageable pageable);
}
