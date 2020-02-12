package com.srdz.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderSnFactory {
    public String generator(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<5;i++){
            result+=random.nextInt(10);
        }
        return "SRDZ"+newDate+result;
    }

}
