package src.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTime01 {
    public static void main(String[] args) {
        /**
         * 1
         */
        LocalDate ld =LocalDate.now();
        LocalTime lt =LocalTime.now();
        LocalDateTime ldt =LocalDateTime.now();

        /**
         * 2
         */
        LocalDate localDate =ldt.toLocalDate();
        LocalTime localTime =ldt.toLocalTime();

        /**
         * 3
         */
        LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
        LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);

        /**
         * 1
         */
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);

        /**
         * 2
         */
        System.out.println(localDate);
        System.out.println(localTime);

        /**
         * 3
         */
        System.out.println(d2);
        System.out.println(t2);
        System.out.println(dt2);
        System.out.println(dt3);

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt4 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt4);

        /**
         * 加减时间
         */
        LocalDateTime localDateTime =LocalDateTime.of(2021,3,10,9,44);
        LocalDateTime D2 =localDateTime.minusMonths(1).plusDays(5).minusHours(3);
        System.out.println(D2);

        /**
         * 调整时间
         */
        LocalDateTime L1 =localDateTime.withYear(2020);
        LocalDateTime L3 =L1.withDayOfYear(1);
        LocalDateTime L2 =L3.withMonth(3);
        System.out.println(L2);

        /**
         * 复杂时间调整
         */
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);

        /**
         * 判断时间先后
         */
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));

        /**
         * 时间戳进行转换
         */
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        Duration d1=d.ofHours(10);
        System.out.println(d); // PT1235H10M30S
        System.out.println("d1: "+d1);

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D
    }
}


