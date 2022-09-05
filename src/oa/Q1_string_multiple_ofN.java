package oa;

/**
 * 1. 给你一个字符串，里面是数字，找出所有能整除3的子串的个数。
 * 比如 "133" -> 3
 *
 * 2. 给你一个矩阵，'1'代表箱子，'*'代表炸药，‘·’表示空位。输入给你了，每次会下落一格，如果箱子碰到炸药，那么会炸毁以炸药为中心的九格之内的所有箱子，请问最终矩阵会是什么样子。
 *
 * 1.给两个输入的年月日，判断这两个日期之间隔了多少天？
 * -- 2020 5 1, 2021 6 23
 * --> 输出对应天数
 *
 * 2. 给你一个输入，
 * (A, B) (B, C) (B, D)
 *
 * 让你返回结果为 （C(B(D))A) 的输出，同时中间处理 1. 是否有回环 2. 是否为不合法输入 3. 是否有重复对 等各种异常输入，返回不同的错误信息，如果没错误就输出标准格式。
 * @author huimin
 * @create 2021-09-30 0:06
 */
public class Q1_string_multiple_ofN {
    public static void main(String[] args) {
        String t = "medallion,hack_license,vendor_id,rate_code,store_and_fwd_flag,pickup_datetime,dropoff_datetime,passenger_count,trip_time_in_secs,trip_distance,pickup_longitude,pickup_latitude,dropoff_longitude,dropoff_latitude";
        String f = "medallion,hack_license,vendor_id,pickup_datetime,payment_type,fare_amount,surcharge,mta_tax,tip_amount,tolls_amount,total_amount";
        // t -> 14 - 4 = 10
        // f -> 11 - 4 = 7
        String[] splits1 = t.split(",");
        String[] splits2 = f.split(",");
        System.out.println(splits1.length);
        System.out.println(splits2.length);
    }
}
