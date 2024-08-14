package com.maids.cc.bookStore.repository;

import com.maids.cc.bookStore.model.Patron;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatronRepository extends CrudRepository<Patron, Integer> {
}
