package com.practice.datatable.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/csv")
public class CsvApi {
    @Autowired
    private CsvService csvService;

    @PostMapping("/import")
    public ResponseEntity<?> importFile(@RequestBody MultipartFile[] filesUpload) {
        csvService.handleFiles(filesUpload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
