/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.formatter;

import com.tnt.pojos.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author truongtn
 */
public class CategoryFormater implements Formatter<Category>{

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Category parse(String string, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(string));
        return c;
    }
    
}
