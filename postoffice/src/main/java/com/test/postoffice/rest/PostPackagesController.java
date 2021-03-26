package com.test.postoffice.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.postoffice.entity.EStatus;
import com.test.postoffice.entity.PostOffice;
import com.test.postoffice.entity.ProcessedPostPackage;
import com.test.postoffice.payload.request.ArrivedPackageRequest;
import com.test.postoffice.payload.request.ReceivePackageRequest;
import com.test.postoffice.payload.request.RegisterPackageRequest;
import com.test.postoffice.payload.request.SendPackageRequest;
import com.test.postoffice.payload.request.TracePackageRequest;
import com.test.postoffice.payload.response.ArrivedPackageResponse;
import com.test.postoffice.payload.response.ReceivePackageResponse;
import com.test.postoffice.payload.response.RegisterPackageResponse;
import com.test.postoffice.payload.response.SendPackageResponse;
import com.test.postoffice.payload.response.TraceEntity;
import com.test.postoffice.payload.response.TracePackageResponse;
import com.test.postoffice.service.PostOfficeService;
import com.test.postoffice.service.PostPackageService;
import com.test.postoffice.service.ProcessedPkgService;

@RestController
@RequestMapping("/api")
public class PostPackagesController {
	
	@Autowired
	private PostOfficeService postOfficeService;
	
	@Autowired
	private PostPackageService postPkgController;
	
	@Autowired
	private ProcessedPkgService processedPkgService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerPackage(@Valid @RequestBody RegisterPackageRequest request) {
		
		List<PostOffice> offices = postOfficeService.findAll();
		
		request.getPkg().setId(0);
		int srcPostOfficeInd = (int) (Math.random() * offices.size() + 1);
		PostOffice office = offices.get(srcPostOfficeInd);
		System.out.println(srcPostOfficeInd);
		ProcessedPostPackage processedPkg = new ProcessedPostPackage(request.getPkg(),
				EStatus.ARRIVED,
				new Date(),
				office);
		processedPkg.setId(0);
		
		
		postPkgController.save(request.getPkg());
		processedPkgService.save(processedPkg);

		
		return ResponseEntity.ok(new RegisterPackageResponse(request.getPkg().getId(),
				request.getPkg().getDstPostOffice().getId(),
				office.getId(),
				processedPkg.getStatus(), processedPkg.getDate(),
				request.getPkg().getRecipientName(),
				request.getPkg().getRecipientAddress()));
	}
	
	@PostMapping("/arrive")
	public ResponseEntity<?> arrivedPackage(@Valid @RequestBody ArrivedPackageRequest request) {
		ProcessedPostPackage processedPkg = processedPkgService.findAll()
				.stream().filter(pkg -> pkg.getPostPackage().getId() == request.getPackageId())
				.findAny()
				.orElse(null);
//		System.out.println(processedPkgService.findAll());
//		System.out.println(processedPkg);
//		System.out.println(postOfficeService.findById(request.getPostOfficeId()));
		
		if (processedPkg != null) {
			ProcessedPostPackage newRecord = new ProcessedPostPackage(processedPkg.getPostPackage(), EStatus.ARRIVED, new Date(), postOfficeService.findById(request.getPostOfficeId()));
//			System.out.println(newRecord);
			//			processedPkg.setStatus(EStatus.ARRIVED);
//			processedPkg.setCurrentPostOffice(postOfficeService.findById(request.getPostOfficeId()));
//			processedPkg.setId(0);
//			processedPkg.setDate(new Date());
			processedPkgService.save(newRecord);
			return  ResponseEntity.ok(new ArrivedPackageResponse(newRecord.getPostPackage().getId(),
					newRecord.getStatus(),
					newRecord.getDate(),
					newRecord.getCurrentPostOffice().getId()));
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	
	@PostMapping("/send")
	public ResponseEntity<?> sendPackage(@Valid @RequestBody SendPackageRequest request) {
		ProcessedPostPackage processedPkg = processedPkgService.findAll()
				.stream().filter(pkg -> pkg.getPostPackage().getId() == request.getPackageId())
				.findAny()
				.orElse(null);
		
		if (processedPkg != null) {
			ProcessedPostPackage newRecord = new ProcessedPostPackage(processedPkg.getPostPackage(), EStatus.SENT, new Date(), postOfficeService.findById(request.getPostOfficeId()));

//			processedPkg.setStatus(EStatus.SENT);
//			processedPkg.setCurrentPostOffice(postOfficeService.findById(request.getPostOfficeId()));
//			processedPkg.setId(0);
//			processedPkg.setDate(new Date());
			processedPkgService.save(newRecord);
			return ResponseEntity.ok(new SendPackageResponse(
					newRecord.getPostPackage().getId(),
					newRecord.getStatus(),
					newRecord.getDate(),
					newRecord.getCurrentPostOffice().getId()));
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	
	
	@PostMapping("/receive")
	public ResponseEntity<?> receivePackage(@Valid @RequestBody ReceivePackageRequest request) {
//		ProcessedPostPackage processedPkg = processedPkgService.findAll()
//				.stream().filter(pkg -> pkg.getPostPackage().getId() == request.getPackageId())
//				.find()
//				.orElse(null);
		
		List<ProcessedPostPackage> processedPkgList =  processedPkgService.findAll().stream().filter(pkg -> pkg.getPostPackage().getId() == request.getPackageId()).collect(Collectors.toList());
		ProcessedPostPackage processedPkg = processedPkgList.get(processedPkgList.size() - 1);
		
		System.out.println(processedPkg);
		
		
		if (processedPkg != null) {
			System.out.println(processedPkg);
			ProcessedPostPackage newRecord = new ProcessedPostPackage(processedPkg.getPostPackage(), EStatus.RECEIVED, new Date(), processedPkg.getPostPackage().getDstPostOffice());
//
////			processedPkg.setStatus(EStatus.RECEIVED);
////			processedPkg.setId(0);
////			processedPkg.setDate(new Date());
			processedPkgService.save(newRecord);
			return ResponseEntity.ok(new ReceivePackageResponse(
					newRecord.getPostPackage().getId(),
					newRecord.getStatus(),
					newRecord.getDate(),
					newRecord.getCurrentPostOffice().getId()));
		}
		return null;
//		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	
	@GetMapping("/trace")
	public ResponseEntity<?> tracePackage(@Valid @RequestBody TracePackageRequest request) {
		List<ProcessedPostPackage> history = postPkgController.findById(request.getPackageId()).getHistory();
		List<TraceEntity> trace = new ArrayList<TraceEntity>();
		
		for (ProcessedPostPackage traceEntity : history) {
			trace.add(new TraceEntity(traceEntity.getCurrentPostOffice().getAddress(),
					traceEntity.getStatus(),
					traceEntity.getDate()));
		}
		
		TracePackageResponse response = new TracePackageResponse(request.getPackageId(), trace);
		System.out.println(response);
		return ResponseEntity.ok(response);
	}
	
	
}
