package com.pluralsight.Interface;

import com.pluralsight.Model.Product;

public interface AddRemoveExtras {
    void add(String servingSize, Product drink);
    void remove(String servingSize, Product drink);
}
