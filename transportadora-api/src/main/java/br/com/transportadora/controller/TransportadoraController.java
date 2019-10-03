package br.com.transportadora.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.transportadora.model.Transportadora;
import br.com.transportadora.repository.TransportadoraRepository;

@RestController
@RequestMapping("/transportadoras")
@CrossOrigin("*")
public class TransportadoraController {
	@Autowired
	private TransportadoraRepository transportadoras;
	
	@GetMapping
	public ResponseEntity<List<Transportadora>> listar() {
		return ResponseEntity.ok(transportadoras.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transportadora> buscar(@PathVariable Long id) {
		Optional<Transportadora> transportadora = transportadoras.findById(id);
		
		if(!transportadora.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(transportadora.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transportadora adicionar (@Valid @RequestBody Transportadora transportadora) {
		return transportadoras.save(transportadora);
	}
	
	@PutMapping
	public Transportadora atualizar(@Valid @RequestBody Transportadora novaTransportadora) {
		return transportadoras.findById(novaTransportadora.getId())
				.map(transportadora ->{
					transportadora.setCelular(novaTransportadora.getCelular());
					transportadora.setEmail(novaTransportadora.getEmail());
					transportadora.setEmpresa(novaTransportadora.getEmpresa());
					transportadora.setModal(novaTransportadora.getModal());
					transportadora.setNome(novaTransportadora.getNome());
					transportadora.setTelefone(novaTransportadora.getTelefone());
					transportadora.setWhatsapp(novaTransportadora.getWhatsapp());
					transportadora.setEmpresa(novaTransportadora.getEmpresa());
					return transportadoras.save(transportadora);
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Transportadora nao encontrada"));
				
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable Long id) {
		transportadoras.deleteById(id);
	}

}
