package com.picpaychallenge.dtos;

import java.math.BigDecimal;

public record TransferDTO(Long senderId, Long receiverId, BigDecimal amount) {
}
