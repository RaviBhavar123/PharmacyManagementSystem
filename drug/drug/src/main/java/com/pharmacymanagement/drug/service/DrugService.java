package com.pharmacymanagement.drug.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pharmacymanagement.drug.entity.Drug;
import com.pharmacymanagement.drug.exception.DrugException;

@Service
public interface DrugService {
public Drug addDrug(Drug drug)throws DrugException;
public Drug getDrug(Long drugId)throws DrugException;
public Drug updateDrug(Long drugId, Drug drug)throws DrugException;
public void deletDrug(Long drugId) throws DrugException;
public List<Drug> getallDrug()throws DrugException;
}
