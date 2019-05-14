package com.example.attack.utils;

import android.content.Context;
import com.example.attack.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jb on 2018/9/26.
 */
public class DateUtil {



    /**
     * 获取系统当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getSysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new java.util.Date());
    }


    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014年06月14日16:09"）
     *
     * @param
     * @return
     */
    public static String timet(Long l) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        String times = sdr.format(new Date(l * 1000L));
        return times;

    }

    public static String getTime(int second) {
        if (second < 10) {
            return "00分钟0" + second + "秒";
        }
        if (second < 60) {
            return "00分钟" + second + "秒";
        }
        if (second < 3600) {
            int minute = second / 60;
            second = second - minute * 60;
            if (minute < 10) {
                if (second < 10) {
                    return "0" + minute + "分钟0" + second + "秒";
                }
                return "0" + minute + "分钟" + second + "秒";
            }
            if (second < 10) {
                return minute + "分钟0" + second + "秒";
            }
            return minute + "分钟" + second + "秒";
        }
        int hour = second / 3600;
        int minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        if (hour < 10) {
            if (minute < 10) {
                if (second < 10) {
                    return "0" + hour + "小时0" + minute + "分钟0" + second + "秒";
                }
                return "0" + hour + "小时0" + minute + "分钟" + second + "秒";
            }
            if (second < 10) {
                return "0" + hour +"小时"+ minute + "分钟0" + second + "秒";
            }
            return "0" + hour +"小时"+ minute + "分钟" + second + "秒";
        }
        if (minute < 10) {
            if (second < 10) {
                return hour + "小时0" + minute + "分钟0" + second + "秒";
            }
            return hour + "小时0" + minute + "分钟" + second + "秒";
        }
        if (second < 10) {
            return hour + "小时" + minute + "分钟0" + second + "秒";
        }
        return hour + "小时" + minute + "分钟" + second + "秒";
    }

    public static String getCurrentTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }


    public static String duration(Long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        String hms = formatter.format(time);
        return hms;

    }

    /**
     * 判断是否是同一天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isTheSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }

    public static String toTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        return df.format(new Date());
    }

}




