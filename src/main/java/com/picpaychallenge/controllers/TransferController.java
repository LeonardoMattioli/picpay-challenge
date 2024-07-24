package com.picpaychallenge.controllers;

import com.picpaychallenge.dtos.TransferDTO;
import com.picpaychallenge.models.Transfer;
import com.picpaychallenge.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferDTO transferDTO) throws Exception {
        Transfer transfer = transferService.createTransfer(transferDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transfer);
    }
}
