package com.springsample.login.demo.project.database.repo;


import com.springsample.login.demo.project.database.tables.UserInfoTab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoTab,Long> {

    @Query("SELECT a FROM UserInfoTab a WHERE USERNAME = ?1 AND PASSWORD = ?2")
    List<UserInfoTab> findByuserpass(String username, String pass);

}
