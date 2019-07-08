package com.arc.utils.mine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期/时间工具类 该类定义一些常用的日期和时间格式
 * 提供有关日期/时间的常用静态操作方法
 *
 * @author yechao
 * @version V1.0
 * @date 2018/08/07 15:27
 */
public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public enum TimeUnit {
        MILLI, SEC, MIN, HOUR, DAY
    }

    private static final String[] parsePatterns = {
            "yyyy-MM",
            "yyyy/MM",
            "yyyy.MM",
            "yyyy.MM.dd",
            "yyyy/MM/dd",
            "yyyy-MM-dd",
            "yyyy/MM/dd HH:mm",
            "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm",
    };


    /**
     * 日期格式
     **/
    public static final String HHMMSS = "HHmmss";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String HH_MM = "HH:mm";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    public static final int SEC_UNIT = 60;
    public static final int SEC_PER_MIN = SEC_UNIT;
    public static final int SEC_PER_HOUR = SEC_UNIT * SEC_PER_MIN;
    public static final int SEC_PER_DAY = 24 * SEC_PER_HOUR;
    public static final int MILLI_PER_SEC = 1000;


    /**
     * 将字符串转成日期
     *
     * @param source 日期字符串
     * @param format 格式
     * @return
     */
    public static Date parseDate(String source, DateFormat format) {
        if (source == null)
            return null;
        try {
            return format.parse(source);
        } catch (ParseException e) {
            logger.error("Can not be parsed to date. ", e);
        }
        return null;
    }

    /**
     * 将字符串转成日期
     *
     * @param source  日期字符串
     * @param pattern 格式字符串
     * @return
     */
    public static Date parseDate(String source, String pattern) {
        if (source == null) return null;
        try {
            return new SimpleDateFormat(pattern).parse(source);
        } catch (ParseException e) {
            logger.error("Can not be parsed to date. ", e);
        }
        return null;
    }

    /**
     * 格式化日期
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String formatDate(Date date, DateFormat format) {
        if (date == null) return null;
        try {
            return format.format(date);
        } catch (Exception e) {
            logger.error("Can not be parsed to date. ", e);
        }
        return null;
    }

    /**
     * 格式化日期
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date == null) return null;
        try {
            return new SimpleDateFormat(format).format(date);
        } catch (Exception e) {
            logger.error("Can not be parsed to date. ", e);
        }
        return null;
    }

    /**
     * 得到当前时间
     *
     * @return
     */
    public static Date currentDate() {
        return new Date();
    }

    /**
     * 以默认(yyyy-MM-dd HH:mm:ss)格式得到当前时间字符串
     *
     * @return
     */
    public static String formatCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 以固定格式得到当前时间字符串
     *
     * @param format 格式
     * @return
     */
    public static String formatCurrentDate(DateFormat format) {
        return format.format(new Date());
    }

    /**
     * 以固定格式化字符串得到当前时间字符串
     *
     * @param format 格式
     * @return
     */
    public static String formatCurrentDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 比较两个时间
     *
     * @param source
     * @param target
     * @return 0: source=target, 1: source>target, -1: source<target
     */
    public static int compareDate(Date source, Date target) {
        return source.compareTo(target);
    }

    /**
     * 以同种格式比较两个时间字符串
     *
     * @param source
     * @param target
     * @param format
     * @return 0: source=target, 1: source>target, -1: source<target
     */
    public static int compareDate(String source, String target, DateFormat format) {
        try {
            return format.parse(source).compareTo(format.parse(target));
        } catch (ParseException e) {
            throw new RuntimeException("Exception when compare two date string. ", e);
        }
    }

    /**
     * 以同种格式比较两个时间字符串
     *
     * @param source
     * @param target
     * @param pattern
     * @return 0: source=target, 1: source>target, -1: source<target
     */
    public static int compareDate(String source, String target, String pattern) {
        DateFormat formate = new SimpleDateFormat(pattern);
        try {
            return formate.parse(source).compareTo(formate.parse(target));
        } catch (ParseException e) {
            throw new RuntimeException("Exception when compare two date string. ", e);
        }
    }

    /**
     * 以不同格式比较两个时间字符串
     *
     * @param source
     * @param sourceFormat
     * @param source
     * @param targetFormat
     * @return 0: source=target, 1: source>target, -1: source<target
     */
    public static int compareDate(String source, DateFormat sourceFormat,
                                  String target, DateFormat targetFormat) {
        try {
            return sourceFormat.parse(source).compareTo(targetFormat.parse(target));
        } catch (ParseException e) {
            throw new RuntimeException("Exception when compare two date string. ", e);
        }
    }

    /**
     * 以不同格式比较两个时间字符串
     *
     * @param source
     * @param sourcePattern
     * @param source
     * @param targetPattern
     * @return 0: source=target, 1: source>target, -1: source<target
     */
    public static int compareDate(String source, String sourcePattern,
                                  String target, String targetPattern) {
        try {
            return new SimpleDateFormat(sourcePattern).parse(source).compareTo(
                    new SimpleDateFormat(targetPattern).parse(target));
        } catch (ParseException e) {
            throw new RuntimeException("Exception when compare two date string. ", e);
        }
    }

    /**
     * 比较时间和时间字符串是否相等
     *
     * @param source
     * @param target
     * @param format
     * @return
     */
    public static boolean isEqual(Date source, String target, DateFormat format) {
        return format.format(source).equals(target);
    }

    /**
     * 比较时间和时间字符串是否相等
     *
     * @param source
     * @param target
     * @param pattern
     * @return
     */
    public static boolean isEqual(Date source, String target, String pattern) {
        return new SimpleDateFormat(pattern).format(source).equals(target);
    }

    /**
     * 增加或减少天数
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addDay(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

    /**
     * 增加或减少天数
     *
     * @param date
     * @param amount
     * @return
     */
    public static String addDay(String date, DateFormat format, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(parseDate(date, format));
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return format.format(cal.getTime());
    }

    /**
     * 增加或减少月数
     *
     * @param date
     * @param amount
     * @return
     */
    public static String addMonth(String date, DateFormat format, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(parseDate(date, format));
        cal.add(Calendar.MONTH, amount);
        return format.format(cal.getTime());
    }

    /**
     * 增加或减少日历
     *
     * @param date
     * @param calendarField
     * @param amount
     * @return
     */
    public static Date calendarAdd(Date date, int calendarField, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        cal.add(calendarField, amount);
        return cal.getTime();
    }

    /**
     * @param start
     * @param end
     * @return
     */
    public static boolean isMoreThan(String start, String end, long interval) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startTs = DateUtils.parseDate(start, simpleDateFormat).getTime();
        long endTs = DateUtils.parseDate(end, simpleDateFormat).getTime();
        return endTs - startTs > interval;
    }


    /**
     * 获取指定时间的那一天的 第一秒
     *
     * @param now
     * @return
     */
    public static Date getBeginDate(Date now) {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        return c.getTime();
    }

    /**
     * 获取指定时间内的那一天的 最后一秒
     *
     * @param now
     * @return
     */
    public static Date getEndDate(Date now) {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 两个时间的间隔秒
     *
     * @param one
     * @param other
     * @return
     */
    public static int getBetweenTime(Date one, Date other) {
        return (int) (Math.abs(one.getTime() - other.getTime()) / 1000);
    }


    /**
     * 将Date类型转换成String类型
     *
     * @param date Date对象
     * @return 形如:"yyyy-MM-dd HH:mm:ss"
     */
    public static String date2String(Date date) {
        return date2String(date, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 将Date按格式转化成String
     *
     * @param date    Date对象
     * @param pattern 日期类型
     * @return String
     */
    public static String date2String(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 将String类型转换成Date类型
     *
     * @param date Date对象
     * @return
     */
    public static Date string2Date(String date) {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date string2Date(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /***
     * 获取时间差额
     * @param startDate
     * @param endDate
     * @param timeUnit 默认millisecond
     * @return
     */
    public static Long diffTimeUnit(Date startDate, Date endDate, TimeUnit timeUnit) {
        Long diffTime = endDate.getTime() - startDate.getTime();

        switch (timeUnit) {
            case MILLI: {
                return diffTime;
            }
            case SEC: {
                return diffTime / DateUtils.MILLI_PER_SEC;
            }
            case MIN: {
                return diffTime / DateUtils.MILLI_PER_SEC / DateUtils.SEC_PER_MIN;
            }
            case HOUR: {
                return diffTime / DateUtils.MILLI_PER_SEC / DateUtils.SEC_PER_HOUR;
            }
            case DAY: {
                return diffTime / DateUtils.MILLI_PER_SEC / DateUtils.SEC_PER_DAY;
            }
            default:
                return diffTime;
        }
    }

    /**
     * 获得当前系统时间
     * 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurDate() {
        return date2String(new Date(), "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 判断某一时间是否在一个区间内
     *
     * @param sourceTime 时间区间,半闭合,如[10:00-20:00)
     * @param curTime    需要判断的时间 如10:00
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceTime, String curTime) {
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (curTime == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }

    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        if (time <= 0)
            return "00:00";
        else {
            hour = time / 60;
            if (hour > 99)
                return "99:59:59";
            minute = time - hour * 60;
            timeStr = unitFormat(hour) + ":" + unitFormat(minute);
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    public static String getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    }

    /**
     * 给时间加上几个小时
     *
     * @param day  当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @param hour 需要加的时间
     * @return
     */
    public static String addDateMinut(String day, int hour) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);

    }


    //生成流水号
    public String getSerialNumber() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = formatter.format(new Date());
        long tem = (long) (Math.random() * 1000000);//6位随机数
        return format += tem;
    }

    public static Long getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    public static Long getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime().getTime();
    }

    public static String getStringDate(Long dateTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date(dateTime));
        return dateString;
    }

    public static String getStringDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());
        return dateString;
    }

    public static Date getDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateString);
        return date;
    }

    public static String timeStamp2Date(Long time) {
//        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(time));
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String longFormatStr(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(sdf.format(time));
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param value
     * @return
     * @Title: objectConvertBigDecimal
     * @Description: Object类型的数字转Date
     * @author: ZXM
     */
    public static String objectConvertDate(Object value) {
        String strDate = "";
        Long longDate = 0L;
        if (value != null) {
            if (value instanceof Long) {
                longDate = (Long) value;
            } else if (value instanceof String) {
                longDate = Long.valueOf((String) value);
            } else if (value instanceof Integer) {
                longDate = (Long) value;
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
                        + " into a Long.");
            }
        }
        strDate = longFormatStr(longDate);
        return strDate;
    }


    //将Object转为字符串
    public static String changeDate(Object obj) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(format.parse(obj.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //将Date转为字符串
    public static String changeDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    //通过参数获取指定日期
    public static Date getDate(int basis, Date date, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int tempDate = calendar.get(basis);
        calendar.set(basis, tempDate + value);
        return calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {

        //		Date startDate=DateUtil.string2Date("11:59:00", DATE_PATTERN.HH_MM_SS);
//		Date endDate=DateUtil.string2Date("12:00:01", DATE_PATTERN.HH_MM_SS);
//		System.out.println(DateUtil.SEC_PER_DAY/DateUtil.SEC_UNIT);
//		int times = (DateUtil.diffTimeUnit(startDate,endDate, TimeUnit.SEC)).intValue();
//		System.out.println(times);
//		startDate= org.apache.commons.lang3.time.DateUtils.addMinutes(startDate, 10);
//		System.out.println(DateUtil.date2String(startDate));
//		System.out.println(getExtraTime("00:23","12:00","HH:MM"));
//		System.out.println(isInTime("00:00-11:00", "10:59"));
//	    System.out.println(isInTime("12:00-17:00", "00:00"));
//	    System.out.println(isInTime("18:00-23:59", "03:00"));
//	    System.out.println();
//	    System.out.println(isInTime("0:00-11:00", "03:00"));
//	    System.out.println(isInTime("12:00-17:00", "22:00"));
//	    System.out.println(isInTime("18:00-23:59", "18:00"));
//	    System.out.println(isInTime("0:00-11:00", "20:01"));
//	    System.out.println(isInTime("18:00-23:59", "19:59"));
//        System.out.println(getTimeByHour(2));
//        System.out.println("**********************************************");
//        System.out.println(changeDate("2018-04-23 12:12:12"));
//        System.out.println(changeDate(getDate(Calendar.MONTH,new Date(),-6)));

//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-02-02 06:30:00").toLocaleString());
//        System.out.println(DateUtil.getBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-02-02 06:30:00")).toLocaleString());
//        System.out.println(DateUtil.getEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-02-02 06:30:00")).toLocaleString());
//        System.out.println("**********************************************");
//
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String mark = "2017-02-02 06:30:00";
//        Date formatterDate = formatter.parse(mark);
//        calendar.setTime(formatterDate);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        Date start = calendar.getTime();
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        calendar.add(Calendar.SECOND, -1);
//        Date end = calendar.getTime();
//        System.out.println(start.toLocaleString());
//        System.out.println(end.toLocaleString());
//        /* other way */
//        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//        start = formater2.parse(formater.format(new Date()) + " 00:00:00");
//        end = formater2.parse(formater.format(new Date()) + " 23:59:59");
//
//        System.out.println(start);
//        System.out.println(end);
    }

}
