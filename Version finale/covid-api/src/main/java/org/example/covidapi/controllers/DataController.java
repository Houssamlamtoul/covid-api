package org.example.covidapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DataController {

  @GetMapping("/api/data")
  public Object getData() {
    return "{\"message\": \"This is some data from the backend!\"}";
  }
}