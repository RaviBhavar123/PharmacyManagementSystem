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
	public Drug updateDrug(Long drugId, Drug drug) {
		Drug drug1 = drugRepo.findById(drugId).orElseThrow(() -> new DrugException("Inavlid Drug Id " + drugId));
		drug1.setDrugName(drug.getDrugName());
		drug1.setDrugid(drug.getDrugid());
		drug1.setDrugQuantity(drug.getDrugQuantity());
		drug1.setPrice(drug.getPrice());
		drug1.setExpiryDate(drug.getExpiryDate());
		drugRepo.save(drug);
		return drug;
	}

	@Override
	public void deletDrug(Long drugId) throws DrugException {
		drugRepo.deleteById(drugId);

	}

	@Override
	public List<Drug> getallDrug() throws DrugException {
		List<Drug> drug=drugRepo.findAll();
		return drug;
	}
	
	

}
