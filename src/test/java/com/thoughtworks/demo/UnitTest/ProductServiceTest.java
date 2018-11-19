package com.thoughtworks.demo.UnitTest;

import com.github.andrewoma.dexx.collection.ArrayList;
import com.thoughtworks.demo.exception.ProductNotFoundException;
import com.thoughtworks.demo.model.Product;
import com.thoughtworks.demo.repository.ProductRepository;
import com.thoughtworks.demo.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ProductNotFoundException.class)
    public void should_throw_product_not_found_exception_when_product_id_not_exist() {
        //given
        Long productId = 1L;
        //when
        productService.get(productId);
        //then
    }

    @Test
    public void should_return_product_when_get_by_product_id() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();

        when(productRepository.findById(productId))
                .thenReturn(Optional.of(product));
        //when
        Product actual = productService.get(productId);
        //then
        assertEquals(product.getId(), actual.getId());
    }

    @Test
    public void should_return_all_product_when_get_all() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();

        when(productRepository.findAll())
                .thenReturn(Arrays.asList(product));
        //when
        List<Product> actual = productService.getAll();
        //then
        assertEquals(productId, actual.get(0).getId());
    }

    @Test
    public void should_save_product_when_add_a_product() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();
        //when
        productService.add(product);
        //then
        verify(productRepository, times(1)).save(product);
    }


    @Test(expected = ProductNotFoundException.class)
    public void should_throw_product_not_found_exception_when_update_product_not_exist() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();
        //when
        productService.update(productId, product);
        //then
    }

    @Test
    public void should_save_changes_when_update_a_product() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();

        when(productRepository.findById(productId))
                .thenReturn(Optional.of(product));
        //when
        productService.update(productId, product);
        //then
        verify(productRepository, times(1)).save(product);
    }

    @Test(expected = ProductNotFoundException.class)
    public void should_throw_product_not_found_exception_when_delete_product_not_exist() {
        //given
        Long productId = 1L;
        //when
        productService.remove(productId);
        //then
    }

    @Test
    public void should_delete_product_when_remove_a_product() {
        //given
        Long productId = 1L;
        Product product = Product
                .builder()
                .id(productId)
                .build();

        when(productRepository.findById(productId))
                .thenReturn(Optional.of(product));
        //when
        productService.remove(productId);
        //then
        verify(productRepository, times(1)).delete(product);
    }

}
