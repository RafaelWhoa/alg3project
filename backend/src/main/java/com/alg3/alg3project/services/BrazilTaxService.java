package com.alg3.alg3project.services;

import com.alg3.alg3project.interfaces.TaxService;

public class BrazilTaxService implements TaxService {
    
    public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
