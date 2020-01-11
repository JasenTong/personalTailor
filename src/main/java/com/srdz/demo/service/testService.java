package com.srdz.demo.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;

@Service
public class testService {

    private void print(){
        System.out.println("hello");
    }

}
