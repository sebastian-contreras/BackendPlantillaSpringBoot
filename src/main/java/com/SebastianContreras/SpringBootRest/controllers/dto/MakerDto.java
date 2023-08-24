package com.SebastianContreras.SpringBootRest.controllers.dto;

import com.SebastianContreras.SpringBootRest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakerDto {
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
