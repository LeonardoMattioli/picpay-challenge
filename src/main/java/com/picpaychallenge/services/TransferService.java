package com.picpaychallenge.services;

import com.picpaychallenge.dtos.TransferDTO;
import com.picpaychallenge.models.Enums.UserType;
import com.picpaychallenge.models.Transfer;
import com.picpaychallenge.models.User;
import com.picpaychallenge.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransferService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Transfer createTransfer(TransferDTO transferDTO) throws Exception {
        User sender = userService.findById(transferDTO.senderId());
        User receiver = userService.findById(transferDTO.receiverId());

        userService.validateTransfer(sender, transferDTO.amount());
        if (!authorizeTransfer()) {
            throw new Exception("Transação não autorizada");
        }

        sender.setBalance(sender.getBalance().subtract(transferDTO.amount()));
        receiver.setBalance(receiver.getBalance().add(transferDTO.amount()));

        userService.createUser(sender);
        userService.createUser(receiver);

        Transfer transfer = new Transfer(sender, receiver, transferDTO.amount());
        return transferRepository.save(transfer);
    }

    public boolean authorizeTransfer() {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = authorizationResponse.getBody();

            if (responseBody != null && "success".equals(responseBody.get("status"))) {
                return true;
            }
        }
        return false;
    }
}
