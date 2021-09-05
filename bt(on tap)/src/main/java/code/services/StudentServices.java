package code.services;

import code.model.Student;
import code.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class StudentServices implements IStudentServices{
    @Autowired
    IStudentRepo iStudentRepo;

    @Override
    public Student save(Student student) {
        return iStudentRepo.save(student);
    }

    @Override
    public Student findById(long id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) iStudentRepo.findAll();
    }

    @Override
    public ArrayList<Student> findAllByName(String name) {
        return iStudentRepo.findAllByName(name);
    }

    @Override
    public void Delete(Student student) {
        iStudentRepo.delete(student);
    }

    @Override
    public void edit(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public Page<Student> findAllPage(Pageable pageable) {
        return iStudentRepo.findAll(pageable);
    }

    @Override
    public ArrayList<Student> xapxep() {
        return null;
    }

    @Override
    public Page<Student> findAllNamePage(String name, Pageable pageable) {
        return iStudentRepo.findAllByNamePage(name, pageable);
    }


}
