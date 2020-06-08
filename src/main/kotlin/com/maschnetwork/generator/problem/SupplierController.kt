package com.maschnetwork.generator.problem

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SupplierController{

  private val suppliers = listOf(
    SupplierDTO(id = 1, name = "Nike"),
    SupplierDTO(id = 2, name = "Adidas")
  )

  @GetMapping("/api/suppliers")
  fun getSuppliers() : ResponseEntity<List<SupplierDTO>> {
    return ResponseEntity.ok(suppliers)
  }
}

data class SupplierDTO(val id: Long, val name: String)