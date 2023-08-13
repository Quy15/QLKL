package com.nhom21.fomatter;

import com.nhom21.pojo.Thesis;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ThesisFormatter implements Formatter<Thesis> {
    @Override
    public Thesis parse(String thesisId, Locale locale) throws ParseException {
        return new Thesis(Integer.parseInt(thesisId));
    }

    @Override
    public String print(Thesis thesis, Locale locale) {
        return String.valueOf(thesis.getId());
    }
}
