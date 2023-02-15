package com.libraray.service;

import com.libraray.model.LibraryHis;
import com.libraray.repository.LibraryHisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LibraryHisService {
    @Autowired
    private LibraryHisRepo libraryHisRepo;
    @Autowired
    private BookService bookService;

    //testing
    public LibraryHisService(LibraryHisRepo libraryHisRepo) {
        this.libraryHisRepo = libraryHisRepo;
    }


    public LibraryHis addLibraryHis(LibraryHis libraryHis) {
        return libraryHisRepo.save(libraryHis);
    }

    public List<LibraryHis> getLibraryHis() {
        return libraryHisRepo.findAll();
    }

    public Optional<LibraryHis> getLibraryHisById(UUID id) {
        return libraryHisRepo.findById(id);
    }

    public LibraryHis submitBook(UUID id, Date submissionDt){
        AtomicReference<LibraryHis> atomicReference = new AtomicReference<>();
        Optional<LibraryHis> libraryHis =libraryHisRepo.findById(id);
        libraryHis.ifPresent(ref->{
            ref.setSubmissionDt(submissionDt);
            atomicReference.set(libraryHisRepo.save(ref));
        });
        return atomicReference.get();
    }

    public LibraryHis fineAmount(UUID id){
        LibraryHis libraryHis = libraryHisRepo.findById(id).orElse(null);
        Calendar day = Calendar.getInstance();
        Calendar returnDay = Calendar.getInstance();
        returnDay.setTime(libraryHis.getReturnDt());
        day.setTime(new Date());

        if(libraryHis!= null){
            if(new Date().after(libraryHis.getReturnDt()))
            {
                long noOfDays= TimeUnit.MILLISECONDS.toDays(day.getTimeInMillis() - returnDay.getTimeInMillis());
                System.out.println("No of dayys" + noOfDays);
                long fine = noOfDays * 10;
                libraryHis.setSubmissionDt(new Date());
                libraryHis.setFineAmount(fine);
            }
            else{
                libraryHis.setFineAmount(0);
            }

        }
        return libraryHisRepo.save(libraryHis);
    }




}
