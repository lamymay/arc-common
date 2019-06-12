package com.arc.utils.mine;

/**
 * @author 叶超
 * @since 2019/6/3 20:48
 */
public class PhoneNumberUtils {

    /**
     * 判断字符串是否符合手机号码格式
     * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
     * 电信号段: 133,149,153,170,173,177,180,181,189
     *
     * @param mobileNumber 待检测的字符串
     * @return boolean
     */
    public static boolean isMobileNO(String mobileNumber) {
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        if (mobileNumber == null || mobileNumber.trim().length() == 0) {
            return false;
        } else {
            return mobileNumber.matches(telRegex);
        }
    }


    public static void main(String[] args) {
        String str = "13545454@qq.com";//163.com gmail.com  qq.com
        int length = str.length();
        str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        String result = str.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        System.out.println(result);
        System.out.println("14@qq.com".replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4"));
        System.out.println("114@qq.com".replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4"));
        System.out.println("115454@qq.com".replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4"));
        System.out.println(result);
        System.out.println(result);
        System.out.println(result);

        System.out.println();
        String[] split = str.split("@");//数组有两部分
        StringBuilder stringBuilder = new StringBuilder();
        if (length > 2) {
            stringBuilder.append(split[0].substring(0, 2));//第一段的第1个字符
            stringBuilder.append("*****@");//写死了可以改进*
            stringBuilder.append(split[1].toString());//第2段的字符
        }
        System.out.println(split);
        System.out.println(stringBuilder.toString());
    }


}
