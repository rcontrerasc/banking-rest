package com.unmsm.ddd.banking.console;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unmsm.ddd.banking.application.BankingApplicationService;
import com.unmsm.ddd.banking.application.dtos.BankAccountDto;

public class Main {

    private BankingApplicationService bankingApplicationService = null;
    private ClassPathXmlApplicationContext context = null;

    public Main() {
        try {
            this.initializeIoCContainer();
            this.resolveDependencies();
            this.performTransfer();
            System.out.println("Done!");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
        }
    }

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        new Main();
    }

    public void performTransfer() throws Exception {
        BankAccountDto originAccountDto = new BankAccountDto();
        originAccountDto.setNumber("123456789");
        BankAccountDto destinationAccountDto = new BankAccountDto();
        destinationAccountDto.setNumber("123456788");
        BigDecimal amount = new BigDecimal(40);
        bankingApplicationService.performTransfer(originAccountDto, destinationAccountDto, amount);
    }

    private void initializeIoCContainer() {
        this.context = new ClassPathXmlApplicationContext(
            new String[] { "applicationContext.xml", "applicationContext-hibernate.xml" });
        this.context.getEnvironment().setActiveProfiles("main", "hibernate");
        this.context.refresh();
    }

    public void resolveDependencies() throws Exception {
        bankingApplicationService = (BankingApplicationService) context.getBean("bankingApplicationService");
    }
}