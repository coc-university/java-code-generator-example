package com.codecampn.codegen.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataModel {

    private String name;
    private Boolean info;
    private List<String> metadata;

}