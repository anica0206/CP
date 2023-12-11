package com.example.demo12.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HomeMapper {
    public List<Map<String, String>> getTime();
}
