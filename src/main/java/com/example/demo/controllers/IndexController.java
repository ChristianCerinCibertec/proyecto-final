package com.example.demo.controllers;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Mensaje;
import com.example.demo.service.MensajeService;

@Controller
@RequestMapping("/prueba")
public class IndexController {
	
	
	@Autowired
	private MensajeService mensajeService;
	
	

	@GetMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping("/cursos")
	public String showCursos() {
		return "cursos";
	}
	
	@PostMapping("/ListaMensajes")
	public String GetAllMensajes(Model model) {
		List<Mensaje> lisMensajes = mensajeService.GetAllMensajes();
		
		for(Mensaje mensaje:lisMensajes) {
			
			System.out.println(mensaje.email);
			System.out.println(mensaje.nombre);
			System.out.println(mensaje.mensaje);
		}
		model.addAttribute("mensaje",lisMensajes);
		return "mensajeList";
		
	}
	
	@GetMapping("/contacto")
	public String showContacto() {
		return "contacto";
	}
	
	@PostMapping("/contacto")
	public String crearMensaje(@RequestParam("nombre") String nombre,@RequestParam("email") String email,@RequestParam("mensaje") String mensaje, Model model) {
		
		Mensaje mensaje1 = new Mensaje();
		mensaje1.nombre=nombre;
		mensaje1.email=email;
		mensaje1.mensaje=mensaje;
		
		mensajeService.createMensaje(mensaje1);
		List<Mensaje> lisMensajes = mensajeService.GetAllMensajes();
		model.addAttribute("mensaje1",lisMensajes);
		
		return "contacto";
		
	}
	
	@GetMapping("/nosotros")
	public String showNosotros() {
		return "nosotros";
	}
	
	 
	@GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
	
	@PostMapping("/login")
    public String login(@RequestParam("username") String username, 
    		@RequestParam("password") String password) {
        // Aquí puedes agregar la lógica para verificar las credenciales del usuario
        // Por simplicidad, vamos a asumir que el usuario y la contraseña son "admin"
		
        if ("admin".equals(username) && "admin".equals(password)) {
            // Si las credenciales son válidas, redirigir a la página de inicio
            return "redirect:/prueba/Listamensajes";
        } else {
            // Si las credenciales son inválidas, volver a mostrar el formulario de inicio de sesión con un mensaje de error
            return "redirect:/prueba/login?error=true";
        }
    }
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		mensajeService.deleteMensaje(id);
		List<Mensaje> lisMensajes = mensajeService.GetAllMensajes();
		model.addAttribute("mensaje",lisMensajes);
		
		return "mensajeList";
	}
	
	
	
	
	
	
	
	
}
