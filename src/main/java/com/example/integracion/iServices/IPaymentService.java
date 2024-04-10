package com.example.integracion.iServices;

import java.util.List;
import java.util.Optional;

import com.example.integracion.entity.Payment;

public interface IPaymentService {

	public List<Payment> all();
	
	public Optional<Payment> findById(Short id);
	
	public Payment save(Payment payment);
	
	public void delete(Short id);
	
}
