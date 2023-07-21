package com.Gonzales.Infraccion_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Gonzales.Infraccion_Service.converter.InfraccionConverter;
import com.Gonzales.Infraccion_Service.dto.InfraccionDTO;
import com.Gonzales.Infraccion_Service.service.InfraccionService;

import com.Gonzales.Infraccion_Service.entity.Infraccion;


@RestController
@RequestMapping("/v1/infraccion")
public class InfraccionController {
	 @Autowired
	 private InfraccionService service;
	 
	 @Autowired
	 private InfraccionConverter converter;
	 
	 
	 @GetMapping()
	 public ResponseEntity<List<InfraccionDTO>>findAll(
			 @RequestParam(value="dni",required=false,defaultValue="8") String dni,
			 @RequestParam(value="offset",required=false,defaultValue="0") int pageNumber,
			 @RequestParam(value="limit",required=false,defaultValue="5") int pageSize
			 ){
		 Pageable page = PageRequest.of(pageNumber, pageSize);
		 List<Infraccion> infracciones;
		 if(dni==null) {
			 infracciones = service.findAll(page);
		 }else {
			 infracciones = service.findByDni(dni, page);
		 }
		 
		 if(infracciones.isEmpty()) {
			 return ResponseEntity.noContent().build();
		 }
		 List<InfraccionDTO> infraccionesDTO = converter.fromEntity(infracciones);
		 return ResponseEntity.ok(infraccionesDTO);
	 }
	 
	 @GetMapping(value="/{id}")
	 public ResponseEntity<InfraccionDTO> findById(@PathVariable("id")int id){
		 Infraccion infraccion = service.findById(id);
		 if(infraccion==null) {
			 return ResponseEntity.notFound().build();
		 }
		 InfraccionDTO infraccionDTO = converter.fromEntity(infraccion);
		 return ResponseEntity.ok(infraccionDTO);
	 }
	 
	 @PostMapping
	 public ResponseEntity<InfraccionDTO>create(@RequestBody InfraccionDTO infracionDTO){
		 Infraccion registro = service.save(converter.fromDTO(infracionDTO));
		 InfraccionDTO registroDTO = converter.fromEntity(registro);
		 return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
	 }
	 
	 @PutMapping(value="/{id}")
	 public ResponseEntity<InfraccionDTO>update(@PathVariable("id") int id, @RequestBody InfraccionDTO infraccionDTO){
		 Infraccion registro = service.update(converter.fromDTO(infraccionDTO));
		 if(registro==null) {
			 return ResponseEntity.notFound().build();
		 }
		 InfraccionDTO registroDTO = converter.fromEntity(registro);
		 return ResponseEntity.ok(registroDTO);
	 }
	 
	 @DeleteMapping(value="/{id}")
	 public ResponseEntity<InfraccionDTO>delete(@PathVariable("id") int id){
		 service.delete(id);
		 return ResponseEntity.ok(null);
	 }
	 
}























































