package com.textgeek.webserver.repository;

import com.textgeek.webserver.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class BookCustomRepositoryImpl implements BookCustomRepository{
  @Autowired
  private EntityManager entityManager;
  @Override
  public List<Book> findAllWithParams(Map<String,String> allParams){
    CriteriaBuilder qb = entityManager.getCriteriaBuilder();
    CriteriaQuery query = qb.createQuery();
    Root<Book> root = query.from(Book.class);
    query.select(root);

    if(allParams.containsKey("genre")) query.where(qb.equal(root.get("genre"), allParams.get("genre")));

    return entityManager.createQuery(query).getResultList();
  }
}