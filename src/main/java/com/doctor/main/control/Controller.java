package com.doctor.main.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.main.exception.EmptyData;
import com.doctor.main.exception.WrongId;
import com.doctor.main.model.Model;

@RestController
public class Controller {
	
	@Autowired
	private com.doctor.main.service.Service serv;
	
	@GetMapping("/doc-data")
	public ResponseEntity<Object> getFindAll() throws Exception
	{
		try {
			return new ResponseEntity<>(serv.getAll() ,HttpStatus.FOUND);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	@GetMapping("/doc-data/{Id}")
	public ResponseEntity<Object> getOneData(@PathVariable int Id) throws Exception
	{
		try {
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	@GetMapping("/doc-data/ascending")
	public ResponseEntity<Object> getNameWise() throws Exception
	{
		try {
			return new ResponseEntity<>(serv.sortingData() ,HttpStatus.ACCEPTED);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	@PutMapping("/doc-data")
	public ResponseEntity<Object> getUpdateModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.updateModel(mdd);
			return new ResponseEntity<>(serv.oneData(mdd.getId()) ,HttpStatus.ACCEPTED);
		} catch (EmptyData e) {
			throw new EmptyData(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	@PutMapping("/doc-data/{Id}/{Sal}")
	public ResponseEntity<Object> getUpdateModel(@PathVariable int Id , @PathVariable int Sal) throws Exception
	{
		try {
			serv.updateModel(Id, Sal);
			return new ResponseEntity<>(serv.oneData(Id) ,HttpStatus.FOUND);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@PostMapping("/doc-data")
	public ResponseEntity<Object> getOneSaveModel(@RequestBody Model mdd) throws Exception
	{
		try {
			serv.oneSave(mdd);
			return new ResponseEntity<>("Data added into Data Base",HttpStatus.CREATED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
	
	@DeleteMapping("/doc-data/{Id}")
	public ResponseEntity<Object> getOneSaveModel(@PathVariable int Id) throws Exception
	{
		try {
			serv.deleteOne(Id);
			return new ResponseEntity<>("Data deleted from Data Base",HttpStatus.ACCEPTED);
		} catch (WrongId e) {
			throw new WrongId(e.getMsg());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
	}
}
