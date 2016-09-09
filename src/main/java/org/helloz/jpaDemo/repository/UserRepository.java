package org.helloz.jpaDemo.repository;

import org.helloz.jpaDemo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by helloz on 2016/9/9.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

    User findByAccount(String account);
}
