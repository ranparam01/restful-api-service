package com.hcl.restservice.restfulapiservice.request;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RequestResource {
	
	@Autowired
	private RequestRepository requestRepository;

	@GetMapping("/requests")
	public List<Request> retriveAllRequests() {
		return requestRepository.findAll();
	}

	@GetMapping("/requests/{id}")
	public Optional<Request> retriveRequest(@PathVariable int id) {
		Optional<Request> request=requestRepository.findById(id);
		if(!request.isPresent()) 
			throw new RequestNotFoundException("id-"+ id);
		return request;
	}
	
	@DeleteMapping("/requests/{id}")
	public void deleteRequest(@PathVariable int id) {
	requestRepository.deleteById(id);
	}

	@PostMapping("/requests")
	public ResponseEntity<Object> createRequests(@Valid @RequestBody Request request) {
		Request savedRequest = requestRepository.save(request);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRequest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
