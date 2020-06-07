package com.maschnetwork.generator.problem

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SupplierController{

  private val suppliers = listOf(
    Supplier(id = 1, name = "Nike"),
    Supplier(id = 2, name = "Adidas")
  )

  @GetMapping("/api/suppliers")
  fun getSuppliers() : ResponseEntity<List<Supplier>> {
    return ResponseEntity.ok(suppliers)
  }
}

data class Supplier(val id: Long, val name: String)