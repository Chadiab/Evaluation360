package com.chadi.springjwt.repository;

import com.chadi.springjwt.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long> {
}
