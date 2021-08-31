package code.services;

import code.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IDistrictServices {
    Page<District> findAll(Pageable pageable);
}
