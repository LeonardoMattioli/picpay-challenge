package com.picpaychallenge.services;

import com.picpaychallenge.models.Enums.UserType;
import com.picpaychallenge.models.User;
import com.picpaychallenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void validateTransfer(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Lojistas não podem enviar dinheiro");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Sem saldo suficiente");
        }
    }
}
