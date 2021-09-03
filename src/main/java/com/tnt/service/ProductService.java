/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.service;

import com.tnt.pojos.Product;
import java.util.List;

/**
 *
 * @author truongtn
 */
public interface ProductService {
    List<Product> getProducts(String searchValue, int page);
    boolean addOrUpdate(Product product);
    long countProduct();
}
