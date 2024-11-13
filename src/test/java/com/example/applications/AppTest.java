package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AppTest {
    @InjectMocks
    ProductApplication productApplication;

    @Mock
    ProductService productService;

    @Test
    public void deveSalvarImagemCorretamente() {
        Product product = any(Product.class);
        productApplication.append(product);
        Mockito.verify(productService, Mockito.times(1)).save(product);
    }

    @Test
    public void deveRemoverImagemCorretamente(){
        Product product = any(Product.class);
        productApplication.remove(1);
        Mockito.verify(productService, Mockito.times(1)).remove(1);
    }

    @Test
    public void deveAtualizarImagemCorretamente(){
        Product product = any(Product.class);
        productApplication.update(2, product);
        Mockito.verify(productService, Mockito.times(1)).update(product);
    }
}