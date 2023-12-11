package com.example.demo12.mapper;

import com.example.demo12.model.chartMainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface chartMapper {
    public List<chartMainVO> getChart();
}
