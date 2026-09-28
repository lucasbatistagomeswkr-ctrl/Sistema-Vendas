package com.projeto.sistema.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Cliente;
import com.projeto.sistema.repositorios.ClienteRepositorio;
import com.projeto.sistema.repositorios.CidadeRepositorio;


@Controller
public class ClienteControle {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@GetMapping("/cadastroCliente")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("administrativo/clientes/cadastro");
		mv.addObject("cliente" , cliente);
		mv.addObject("listaCidades" , cidadeRepositorio.findAll());

		return mv;
	}
	
	@GetMapping("/listarCliente")
	public ModelAndView Listar() {
		ModelAndView mv = new ModelAndView("administrativo/clientes/lista");
		mv.addObject("listaClientes", clienteRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cadastrar(cliente.get());
	}
	
	
	@GetMapping("/removerCliente/{id}")
	public ModelAndView remover(@PathVariable("id")Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		clienteRepositorio.delete(cliente.get());
		return Listar();
	}
	
	
	@PostMapping("/salvarCliente")
	public ModelAndView salvar(Cliente cliente, BindingResult result) {
	    if(result.hasErrors()) {
	        return cadastrar(cliente);
	    }
	    clienteRepositorio.saveAndFlush(cliente);
	    return cadastrar(new Cliente());
	}	
}
