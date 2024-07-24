package com.picpaychallenge.repositories;

import com.picpaychallenge.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
