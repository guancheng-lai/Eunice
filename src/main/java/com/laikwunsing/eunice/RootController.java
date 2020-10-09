package com.laikwunsing.eunice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class RootController {

    final ZoneId zoneId = ZoneId.of( "Asia/Shanghai" );

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute( "msg", "I love you!" );
        model.addAttribute( "wedding", numDaysSinceWedding() );
        model.addAttribute( "separated", numDaysSinceSeparated() );
        return "root";
    }

    private String numDaysSinceSeparated() {
        LocalDate separated = LocalDate.of(2020, Month.JANUARY, 10);
        return dayDiff( separated );
    }

    private String numDaysSinceWedding() {
        LocalDate wedding = LocalDate.of(2019, Month.DECEMBER, 25);
        return dayDiff( wedding );
    }

    private String dayDiff(LocalDate date) {
        LocalDate today = LocalDate.now( zoneId );
        long days = DAYS.between(date, today);
        return Long.toString( days );
    }
}
