package com.example.demo12.controller;

import com.example.demo12.mapper.HomeMapper;
import com.example.demo12.mapper.chartMapper;
import com.example.demo12.model.chartMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private HomeMapper homeMapper;

    @RequestMapping("/")
    public String home() {
        System.out.println("-----");
        List<Map<String, String>> list = homeMapper.getTime();
        System.out.println("-----");
        return "home";
    }

    public class chartMainController {

        @Autowired
        private chartMapper chartMap;

        public String chart(Model model) {
            List<chartMainVO> charts = chartMap.getChart();

            model.addAttribute("chart", charts);
            return "Chart";
        }
    }
}
