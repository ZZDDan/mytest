package com.rxx.jdk8new;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

/**
 * Java8日期使用
 * <p>
 * Instant：时间戳
 * LocalDate：不带时间的日期
 * LocalTime：不带日期的时间
 * LocalDateTime：含时间与日期，不过没有带时区的偏移量
 * ZonedDateTime：带时区的完整时间
 * </p>
 *
 * @author zhang
 */
public class DateTest {

    //0-概述
    @Test
    public void instantTest() {
        Instant now = Instant.now();
        // 2017-12-13T09:00:14.609Z
        System.out.println(now);
        // 毫秒：609
        System.out.println(now.get(ChronoField.MILLI_OF_SECOND));
        // 微秒，只是用毫秒数除以1000：609000
        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
        // 纳秒，只是用毫秒数除以1000_000：609000000
        System.out.println(now.get(ChronoField.NANO_OF_SECOND));
        // 毫秒转Instant
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        // 2017-12-13T17:00:14.609
        System.out.println(localDateTime);
    }


    //1-获取当天的日期
    @Test
    public void test1() {
        LocalDate today = LocalDate.now();
        // Today's Local date : 2017-12-13
        System.out.println("Today's Local date : " + today);
    }

    //2-获取当前的年月日
    @Test
    public void test2() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        // Year : 2017 Month : 12 day : 13
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    //3-获取某个特定的日期
    @Test
    public void test3() {
        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
        // Your Date of birth is : 2010-01-14
        System.out.println("Your Date of birth is : " + dateOfBirth);
    }

    //4-检查两个日期是否相等
    @Test
    public void test4() {
        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2014, 01, 14);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }
    }

    //5-检查重复事件，比如说生日
    @Test
    public void test5() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2000, 11, 06);
        //日期 --11-06
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        //
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            // Sorry, today is not your birthday
            System.out.println("Sorry, today is not your birthday");
        }
    }

    //6-获取当前时间
    @Test
    public void test6() {
        LocalTime time = LocalTime.now();
        // local time now : 17:06:17.458
        System.out.println("local time now : " + time);
    }

    //7-增加时间里面的小时数
    @Test
    public void test7() {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // adding two hours
        // Time after 2 hours : 19:06:47.035
        System.out.println("Time after 2 hours : " + newTime);
    }

    //8-获取1周后的日期
    @Test
    public void test8() {
        // 今天
        LocalDate today = LocalDate.now();
        // Today is : 2017-12-13
        System.out.println("Today is : " + today);

        // 下周
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        // Today is : 2017-12-13
        System.out.println("Date after 1 week : " + nextWeek);

        LocalDate today1 = LocalDate.now();
        //前一天
        LocalDate dayBefore = today1.plus(-1, ChronoUnit.DAYS);
        // day before is : 2017-12-12
        System.out.println("day before is : " + dayBefore);

        //前一天的一周前
        LocalDate beforeWeek = dayBefore.plus(-1, ChronoUnit.WEEKS);
        // Date before 1 week : 2017-12-05
        System.out.println("Date before 1 week : " + beforeWeek);
    }

    //9-一年前后的日期
    @Test
    public void test9() {
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        // Date after 1 week : 2017-12-20
        System.out.println("Date before 1 year : " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        //Date after 1 year : 2018-12-13
        System.out.println("Date after 1 year : " + nextYear);
    }

    //10-不同时区的时钟
    @Test
    public void test10() {
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        // Clock : SystemClock[Z]
        System.out.println("Clock : " + clock);

        // Returns time based on system clock zone Clock defaultClock =
        Clock clock1 = Clock.systemDefaultZone();
        // Clock : SystemClock[Asia/Shanghai]
        System.out.println("Clock : " + clock1);
    }

    //11-判断某个日期是在另一个日期的前面还是后面
    @Test
    public void test11() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        if (tomorrow.isAfter(today)) {
            // Tomorrow 2017-12-14 comes after today 2017-12-13
            System.out.printf("Tomorrow %s comes after today %s\n", tomorrow, today);
        }
        //减去
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if (yesterday.isBefore(today)) {
            // Yesterday 2017-12-12 is day before today 2017-12-13
            System.out.printf("Yesterday %s is day before today %s\n", yesterday, today);
        }
    }

    //12-处理不同的时区
    @Test
    public void test12() {
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
        // Current date and time in a particular timezone : 2017-12-13T17:25:12.332-05:00[America/New_York]
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }

    //13-表示固定的日期，比如信用卡过期时间
    @Test
    public void tese13() {
        YearMonth currentYearMonth = YearMonth.now();
        // Days in month year 2017-12: 31
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        // Your credit card expires on 2018-02
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    //14-在Java 8中检查闰年
    @Test
    public void test14() {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.printf("%d year is Leap year\n", today.getYear());
        } else {
            // 2017 year is not a Leap year
            System.out.printf("%d year is not a Leap year\n", today.getYear());
        }
    }

    //15-两个日期之间包含多少天，多少个月
    @Test
    public void test15() {
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease = Period.between(java8Release, today);

        // Months left between today and Java 8 release : 8
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
    }

    //16-带时区偏移量的日期与时间
    @Test
    public void test16() {
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        // Date and Time with timezone offset in Java : 2014-01-14T19:30+05:30
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    //17-获取当前时间戳
    @Test
    public void test17() {
        Instant timestamp = Instant.now();
        // What is value of this instant 2017-12-13T09:39:28.493Z
        System.out.println("What is value of this instant " + timestamp);
    }

    //18-使用预定义的格式器来对日期进行解析/格式化
    @Test
    public void test18() {
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(
                dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        // What is value of this instant 2017-12-13T09:39:28.493Z
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
    }

    //19-使用自定义的格式器来解析日期
    @Test
    public void test19() {
        String goodFriday = "Apr 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            // Apr 18 2014 is not parsable!
            System.out.printf("%s is not parsable!%n", goodFriday);
        }
    }

    //20-对日期进行格式化，转换成字符串
    @Test
    public void test20() {
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            // Apr 18 2014 is not parsable!
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }

    @Test
    public void localDateTest() {
        // 获得当前日期
        LocalDate now = LocalDate.now();
        // 2017-12-13
        System.out.println(now.toString());

        // 日期加上1天
        LocalDate localDate2 = now.plusDays(1);
        // 2017-12-14
        System.out.println(localDate2.toString());

        // 日期加上一周
        LocalDate localDate3 = now.plusWeeks(1);
        // 2017-12-20
        System.out.println(localDate3);
        // 计算当前年的第52天是几月几号：今年的第52天 = 2017-02-21
        System.out.println("今年的第52天 = " + now.withDayOfYear(52));

        // 字符串转日期
        DateTimeFormatter strToDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor dateTemporal = strToDateFormatter.parse("2017-01-01");
        LocalDate date = LocalDate.from(dateTemporal);
        // 2017-01-01
        System.out.println(date);

        // 格式化日期
        DateTimeFormatter dateToStrFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateStr = dateToStrFormatter.format(now);
        // 20171213
        System.out.println(dateStr);
    }
}
