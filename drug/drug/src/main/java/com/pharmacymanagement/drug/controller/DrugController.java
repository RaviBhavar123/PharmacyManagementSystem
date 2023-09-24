package com.pharmacymanagement.drug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacymanagement.drug.entity.Drug;
import com.pharmacymanagement.drug.exception.DrugException;
import com.pharmacymanagement.drug.service.DrugService;

@RestController
@RequestMapping("/Drug")
public class DrugController {
	@Autowired
	private DrugService drugService;

	@PostMapping("/add")
	public ResponseEntity<Drug> add(@RequestBody Drug drug) throws DrugException {
		Drug drug1 = drugService.addDrug(drug);
		return new ResponseEntity<>(drug1, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Drug> update(@RequestBody Drug drug) throws DrugException {
		Drug drug2 = drugService.updateDrug(drug, null);

		return new ResponseEntity<>(drug2, HttpStatus.OK);

	}

	@GetMapping("/get/{drugId}")
	public ResponseEntity<Drug> get(@PathVariable Long drugId) throws DrugException {
		Drug drug1 = drugService.getDrug(drugId);
		return new ResponseEntity<>(drug1, HttpStatus.OK);
	}

	@DeleteMapping("/delet/{drugId}")
	public ResponseEntity<?> delet(@PathVariable Long drugId) throws DrugException {
		drugService.deletDrug(drugId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

}
