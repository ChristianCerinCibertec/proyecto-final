package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensaje")
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmensaje", nullable = false)
	public Long idmensaje;
	
	@Column(name = "nombre", nullable = false)
	public String nombre;
	
	@Column(name = "email", nullable = false)
	public String email;
	
	@Column(name = "mensaje", nullable = false)
	public String mensaje;

}
