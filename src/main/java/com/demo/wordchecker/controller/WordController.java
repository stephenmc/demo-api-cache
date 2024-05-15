package com.demo.wordchecker.controller;

import com.demo.wordchecker.constants.AppConstants;
import com.demo.wordchecker.model.Palindrome;
import com.demo.wordchecker.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

import com.demo.wordchecker.service.WordService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(AppConstants.API_WORD)
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("palindrome")
    public Word getPalindrome(@RequestParam("username") String id, @RequestParam("text") String text) throws Exception {

        Palindrome palindrome = wordService.check(text);
        return palindrome;
    }
}
