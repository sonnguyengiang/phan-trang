package code.repository;

import code.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDistrictRepo extends PagingAndSortingRepository<District, Long> {
    Page<District> findAll(Pageable pageable);
}
