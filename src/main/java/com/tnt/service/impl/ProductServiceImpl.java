/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tnt.pojos.Product;
import com.tnt.repository.ProductRepository;
import com.tnt.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author truongtn
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(String searchValue, int page) {
        return this.productRepository.getProducts(searchValue, page);
    }

    @Override
    public boolean addOrUpdate(Product product) {
        try {
            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            product.setImage((String) r.get("secure_url"));

            return this.productRepository.addOrUpdate(product);
        } catch (IOException ex) {
            System.err.println("=== ADD PRODUCT ===" + ex.getMessage());
        }
        return false;
    }

    @Override
    public long countProduct() {
        return this.productRepository.countProduct();
    }
}
