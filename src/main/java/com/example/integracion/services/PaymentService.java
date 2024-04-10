package com.example.integracion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integracion.entity.Payment;
import com.example.integracion.iRepository.IPaymentRepository;
import com.example.integracion.iServices.IPaymentService;

@Service
public class PaymentService implements IPaymentService{

	@Autowired
	private IPaymentRepository repository;
	
	@Override
	public List<Payment> all(){
		return repository.findAll();
	}
	
	@Override
	public Optional<Payment> findById(Short id){
		return repository.findById(id);
	}
	
	@Override
	public Payment save(Payment payment) {
		return repository.save(payment);
	}

	@Override
	public void delete(Short Id) {
		this.repository.deleteById(Id);
	}
}
