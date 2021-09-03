/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.validator;

import com.tnt.pojos.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author truongtn
 */
@Component
public class ProductNameValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Product.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product p = (Product) o;
        if (!p.getName().contains("tnt")) {
            errors.rejectValue("name", "product.name.authErr");
        }
    }
    
}
