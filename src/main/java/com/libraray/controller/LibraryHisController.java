package com.libraray.controller;

import com.libraray.model.LibraryHis;
import com.libraray.repository.LibraryHisRepo;
import com.libraray.service.LibraryHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/History")
public class LibraryHisController {

    @Autowired
    private LibraryHisRepo libraryHisRepo;
    @Autowired
    private LibraryHisService libraryHisService;

    @PostMapping("/add/LibraryHis")
    public LibraryHis addLibraryHis(@RequestBody LibraryHis libraryHis){
        return libraryHisService.addLibraryHis(libraryHis);
    }

    @GetMapping("/find/All/History")
    public List<LibraryHis> getLibraryHis(){
        return libraryHisService.getLibraryHis();
    }

    @GetMapping("/find/history/{id}")
    public Optional<LibraryHis> getLibraryHisById(@PathVariable UUID id){
        return libraryHisService.getLibraryHisById(id);
    }
    @PutMapping("/submit/{id}")
    public LibraryHis submitBook(@PathVariable UUID id, @RequestParam String submissionDt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = dateFormat.parse(submissionDt);
        return libraryHisService.submitBook(id,currentDate);
    }
    @PutMapping("/fine/amount")
    public LibraryHis fineAmount(@RequestParam UUID id){
        return libraryHisService.fineAmount(id);

    }

}
