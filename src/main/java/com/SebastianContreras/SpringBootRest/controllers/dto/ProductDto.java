package com.SebastianContreras.SpringBootRest.controllers.dto;

import com.SebastianContreras.SpringBootRest.entities.Maker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
public class ProductDto {
        private Long id;
        private String name;
        private BigDecimal price;
        private Maker maker;
}
