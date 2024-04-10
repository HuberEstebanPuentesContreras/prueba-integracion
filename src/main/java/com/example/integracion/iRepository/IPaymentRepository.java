package com.example.integracion.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integracion.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Short>{

}
