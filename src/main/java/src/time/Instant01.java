package src.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Instant01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒

        // 以指定时间戳创建Instant:
        Instant ins = Instant.ofEpochSecond(1568568760);
        Instant ins1 = Instant.now();
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        LocalDateTime ldt =ins1.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(zdt); // 2019-09-16T01:32:40+08:00[Asia/Shanghai]
        System.out.println(ldt);

        /**
         * 转换需要的时区及时间格式
         */
       // long ts = 1574208900000L;
        long ts =System.currentTimeMillis();



        System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts, Locale.US, "America/New_York"));
    }

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
    }

