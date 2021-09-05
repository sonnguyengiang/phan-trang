package code.services;

import code.model.ClassRoom;
import code.repository.IClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ClassRoomServices implements IClassRoomServices{

    @Autowired
    IClassRoomRepo iClassRoomRepo;
    @Override
    public ArrayList<ClassRoom> fillAll() {
        return (ArrayList<ClassRoom>) iClassRoomRepo.findAll();
    }
}
