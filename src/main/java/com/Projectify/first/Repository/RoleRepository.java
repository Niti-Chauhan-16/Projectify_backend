package com.Projectify.first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projectify.first.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

}
