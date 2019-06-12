package com.arc.utils.code;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtils {

    private RandomUtils() {
    }

    /**
     * 生成带字母的随机数     指定长度
     * @param base
     * @param length
     * @return
     */
	public static String getRandomString(String base,int length) { //length表示生成字符串的长度
		Random random = new Random(System.currentTimeMillis());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	        int number = random.nextInt(base.length());
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();
	}

    //生成流水号
    public String getSerialNumber() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = formatter.format(new Date());
        long tem = (long) (Math.random() * 1000000);//6位随机数
        return format += tem;
    }
}
