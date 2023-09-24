package com.pharmacymanagement.drug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacymanagement.drug.entity.Drug;
import com.pharmacymanagement.drug.exception.DrugException;
import com.pharmacymanagement.drug.repository.DrugRepo;

@Service
public class DrugServiceImpl implements DrugService {
	@Autowired
	private DrugRepo drugRepo;

	@Override
	public Drug addDrug(Drug drug) {

		return drugRepo.save(drug);
	}

	@Override
	public Drug getDrug(Long drugId) {
		Drug drug = drugRepo.findById(drugId).orElseThrow(() -> new DrugException("Inavlid Drug Id " + drugId));
		return drug;
	}

	@Override
	public Drug updateDrug(Drug drug, Long drugId) {
		Drug drug1 = drugRepo.findById(drugId).orElseThrow(() -> new DrugException("Inavlid Drug Id " + drugId));
		drug1.setDrugName(drug1.getDrugName());
		drug1.setDrugid(drug1.getDrugid());
		drug1.setDrugQuantity(drug1.getDrugQuantity());
		drug1.setPrice(drug1.getPrice());
		drug1.setExpiryDate(drug1.getExpiryDate());
		drugRepo.save(drug1);
		return drug1;
	}

	@Override
	public void deletDrug(Long drugId) throws DrugException {
		drugRepo.deleteById(drugId);

	}
	
	

}
