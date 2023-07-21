package com.Gonzales.Infraccion_Service.converter;

import org.springframework.stereotype.Component;

import com.Gonzales.Infraccion_Service.dto.InfraccionDTO;
import com.Gonzales.Infraccion_Service.entity.Infraccion;

@Component
public class InfraccionConverter extends AbstractConverter<Infraccion,InfraccionDTO> {
	@Override
	public InfraccionDTO fromEntity(Infraccion entity) {
		if(entity==null)return null;
		return InfraccionDTO.builder()
				.id(entity.getId())
				.dni(entity.getDni())
				.descricpion(entity.getDescripcion())
				.infraccion(entity.getInfraccion())
				.falta(entity.getFalta())
				.build();
	}

	@Override
	public Infraccion fromDTO(InfraccionDTO dto) {
		if(dto==null)return null;
		return Infraccion.builder()
				.id(dto.getId())
				.dni(dto.getDni())
				.descripcion(dto.getDescricpion())
				.infraccion(dto.getInfraccion())
				.falta(dto.getFalta())
				.build();	
	}
}

