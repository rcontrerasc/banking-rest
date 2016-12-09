package com.unmsm.ddd.banking.application;

import java.math.BigDecimal;

import com.unmsm.ddd.banking.application.dtos.BankAccountDto;
import com.unmsm.ddd.banking.domain.entities.BankAccount;
import com.unmsm.ddd.banking.domain.services.TransferDomainService;
import com.unmsm.ddd.banking.infrastructure.abstractions.UnitOfWork;

public class BankingApplicationService {
    private UnitOfWork unitOfWork = null;
    private TransferDomainService transferDomainService = null;

    public BankingApplicationService(UnitOfWork unitOfWork, TransferDomainService transferDomainService)
        throws Exception {
        this.unitOfWork = unitOfWork;
        this.transferDomainService = transferDomainService;
        this.validateDependencies();
    }

    private void validateDependencies() {
        if (this.unitOfWork == null) {
            throw new IllegalArgumentException("unitOfWork cannot be null");
        }
        if (this.transferDomainService == null) {
            throw new IllegalArgumentException("transferDomainService cannot be null");
        }
    }

    public void performTransfer(BankAccountDto originBankAccountDto, BankAccountDto destinationBankAccountDto,
        BigDecimal amount) throws Exception {
        try {
            this.unitOfWork.beginTransaction();
            BankAccount originAccount =
                this.unitOfWork.getBankAccountRepository().findByNumber(originBankAccountDto.getNumber());
            BankAccount destinationAccount =
                this.unitOfWork.getBankAccountRepository().findByNumber(destinationBankAccountDto.getNumber());
            this.transferDomainService.performTransfer(originAccount, destinationAccount, amount);
            this.unitOfWork.save(originAccount);
            this.unitOfWork.save(destinationAccount);
            this.unitOfWork.commitTransaction();
        } catch (Exception ex) {
            this.unitOfWork.rollbackTransaction();
            throw ex;
        }
    }
}