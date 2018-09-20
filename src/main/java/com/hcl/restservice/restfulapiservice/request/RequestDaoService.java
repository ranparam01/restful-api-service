package com.hcl.restservice.restfulapiservice.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RequestDaoService {

	private static List<Request> requests = new ArrayList<>();

	private static int requestCount = 3;

	static {
		requests.add(new Request(1, new Date(), "53ba6f2b-6d52-4f5c-8ae0-7adc20808854",
				"NMubGVcDqkwwGnCs6fa01tqlkTisfUd4pBBYgcxxx=", "aks-system1", "myprefix", "jenkins01"));
		requests.add(new Request(2, new Date(), "53ba6f2b-6d52-4f5c-8ae0-7adc20808854",
				"NMubGVcDqkwwGnCs6fa01tqlkTisfUd4pBBYgcxxx=", "aks-system2", "myprefix", "jenkins02"));
		requests.add(new Request(3, new Date(), "53ba6f2b-6d52-4f5c-8ae0-7adc20808854",
				"NMubGVcDqkwwGnCs6fa01tqlkTisfUd4pBBYgcxxx=", "aks-system3", "myprefix", "jenkins03"));
	}

	public List<Request> findAll() {
		return requests;
	}

	public Request save(Request request) {
		if (request.getId() == null) {
			request.setId(++requestCount);
		}
		requests.add(request);
		return request;
	}

	public Request findOne(int id) {
		for (Request request : requests) {
			if (request.getId() == id) {
				return request;
			}
		}
		return null;
	}
	
	public Request deleteById(int id) {
		Iterator<Request> iterator= requests.iterator();
		while(iterator.hasNext()) {
			Request request= iterator.next();
			if (request.getId() == id) {
				iterator.remove();
				return request;
			}
		}
		return null;
	}

}
