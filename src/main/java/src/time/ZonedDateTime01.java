package src.time;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

public class ZonedDateTime01 {
    public static void main(String[] args) {
//        int n = 123400;
//        // 123400
//        System.out.println(n);
//        // 1e208
//        System.out.println(Integer.toHexString(n));
//        // $123,400.00
//        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
//        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(n));
//
//        Date date=new Date();
//        System.out.println(System.currentTimeMillis());
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime()));
//
//
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
//        System.out.println(zbj);
//        System.out.println(zny);

        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 10, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);

        if (LocalDateTime.of(2019, 9, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 9, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试成功!");
        } else if (!LocalDateTime.of(2019, 9, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 9, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        bj=bj.plusHours(h).plusMinutes(m);
        ZonedDateTime zbj = bj.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        bj=zny.toLocalDateTime();
        return bj;
    }
}


    
