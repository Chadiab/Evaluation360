package com.chadi.springjwt.model;

import com.chadi.springjwt.entity.Criteria;
import com.chadi.springjwt.entity.Theme;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class CreateForm {
    private String formName;
    private String createdAt;
    private Collection<Theme> themes;
}
