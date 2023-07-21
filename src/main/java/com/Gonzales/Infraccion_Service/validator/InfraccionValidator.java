package com.Gonzales.Infraccion_Service.validator;

import com.Gonzales.Infraccion_Service.entity.Infraccion;
import com.Gonzales.Infraccion_Service.exceptions.ValidateServiceException;


public class InfraccionValidator {
	public static void save(Infraccion infraccion) {
		if(infraccion.getDni()==null || infraccion.getDni().isEmpty()) {
			throw new ValidateServiceException("El dni es requerido");
		}
		
		if(infraccion.getDni().length()<9) {
			throw new ValidateServiceException("El dni es muy largo");
		}
		
		if(infraccion.getDescripcion()==null || infraccion.getInfraccion().isEmpty()) {
			throw new ValidateServiceException("La descripcion es requerido");
		}
		
		if(infraccion.getDescripcion().length()<255) {
			throw new ValidateServiceException("La descripcion es muy largo");
		}
		
		if(infraccion.getFalta()==null || infraccion.getFalta().isEmpty()) {
			throw new ValidateServiceException("La falta es requerido");
		}
		
		if(infraccion.getFalta().length()<4) {
			throw new ValidateServiceException("La falta es muy largo");
		}
		
		if(infraccion.getInfraccion()==null || infraccion.getInfraccion().isEmpty()){
			throw new ValidateServiceException("La infraccion es requerida");
		}
		
		if(infraccion.getInfraccion().length()<200) {
			throw new ValidateServiceException("La infraccion es muy larga");
		}
		
	}
}
