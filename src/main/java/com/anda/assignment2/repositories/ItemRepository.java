package com.anda.assignment2.repositories;

import com.anda.assignment2.bean.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {}
