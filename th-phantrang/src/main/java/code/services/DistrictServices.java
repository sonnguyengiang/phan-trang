package code.services;

import code.model.District;
import code.repository.IDistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class DistrictServices implements IDistrictServices{
    @Autowired
    IDistrictRepo iDistrictRepo;


    @Override
    public Page<District> findAll(Pageable pageable) {
        return iDistrictRepo.findAll(pageable);
    }
}
