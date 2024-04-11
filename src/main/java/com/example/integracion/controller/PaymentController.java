package com.example.integracion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.integracion.entity.Payment;
import com.example.integracion.services.PaymentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/security/payment/")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping("get")
	public List<Payment> all(){
		return service.all();
	}
	
	@GetMapping("getId/{id}")
	public Optional<Payment> show(@PathVariable Short id){
		return service.findById(id);
	}

	@PostMapping("create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment save(@RequestBody Payment payment) {
		return service.save(payment);
	}
	
	@PutMapping("update/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment update(@PathVariable Short id, @RequestBody Payment payment) {
		Optional<Payment> op = service.findById(id);
		
		if(op.isPresent()) {
			Payment paymentToUpdate = op.get();
			paymentToUpdate.setCustomerId(payment.getCustomerId());
			paymentToUpdate.setStaffId(payment.getStaffId());
			paymentToUpdate.setRentalId(payment.getRentalId());
			paymentToUpdate.setAmount(payment.getAmount());
			return service.save(paymentToUpdate);
		}
		
		return payment;
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Short id) {
		service.delete(id);
	}
	
}
