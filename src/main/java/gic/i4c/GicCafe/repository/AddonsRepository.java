package gic.i4c.GicCafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.Addons;

public interface AddonsRepository extends JpaRepository<Addons, Integer> {
    Addons findByName(String name);
    List<Addons> findMultipleByName(String name);
}