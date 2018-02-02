package com.invest.controller;

import com.invest.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CJ on 2018-02-01.
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;


}
