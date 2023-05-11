package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Table_Seat;

public interface TableRepository extends JpaRepository<Table_Seat, Integer> {
    
}
