package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mensaje;
import com.example.demo.repository.MensajeRepository;

@Service
public class MensajeService {
	@Autowired
	private MensajeRepository mensajeRepository;

	public List<Mensaje> GetAllMensajes(){
		return mensajeRepository.findAll();
		
	}
	
	
	public Mensaje createMensaje(Mensaje mensaje) {
		return mensajeRepository.save(mensaje) ;
		
	}
	
	public void deleteMensaje(Long id) {
		mensajeRepository.deleteById(id);
	}
	
}
