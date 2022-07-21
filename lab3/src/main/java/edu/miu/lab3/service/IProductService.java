package edu.miu.lab3.service;


import edu.miu.lab3.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> fetchAll();
}
