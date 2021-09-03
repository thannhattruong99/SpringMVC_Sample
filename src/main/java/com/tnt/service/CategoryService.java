/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnt.service;

import com.tnt.pojos.Category;
import java.util.List;

/**
 *
 * @author truongtn
 */
public interface CategoryService {
    List<Category> getCategories();
}
