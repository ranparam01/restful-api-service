package com.hcl.restservice.restfulapiservice.request;

import java.net.URI;
import java.util.List;

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
	private RequestDaoService service;

	@GetMapping("/requests")
	public List<Request> retriveAllRequests() {
		return service.findAll();
	}

	@GetMapping("/requests/{id}")
	public Request retriveRequest(@PathVariable int id) {
		Request request=service.findOne(id);
		if(request==null) 
			throw new RequestNotFoundException("id-"+ id);
		return request;
	}
	
	@DeleteMapping("/requests/{id}")
	public void deleteRequest(@PathVariable int id) {
		Request request=service.deleteById(id);
		if(request==null) 
			throw new RequestNotFoundException("id-"+ id);
	}

	@PostMapping("/requests")
	public ResponseEntity<Object> createRequests(@Valid @RequestBody Request request) {
		Request savedRequest = service.save(request);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRequest.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
