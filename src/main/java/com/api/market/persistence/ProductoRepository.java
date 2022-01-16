package com.api.market.persistence;

import com.api.market.persistence.crud.ProductoCrudRepository;
import com.api.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
    }
}