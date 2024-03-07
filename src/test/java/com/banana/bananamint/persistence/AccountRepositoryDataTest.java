package com.banana.bananamint.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.persistence.AccountRepositoryData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AccountRepositoryDataTest {

    @Autowired
    private AccountRepositoryData accountRepository;

    private static final Logger logger = Logger.getLogger(AccountRepositoryDataTest.class.getName());

    @Test
    public void saveAccount() {
        // given
        Account cuenta = new Account();
        cuenta.setActive(true);
        cuenta.setBalance(1000);
        cuenta.setMaxOverdraft(500);
        cuenta.setOpeningDate(LocalDate.now());
        cuenta.setType("Corriente");

        // when
        Account savedAccount = accountRepository.save(cuenta);

        // then
        assertThat(savedAccount.getId()).isNotNull();
        assertThat(savedAccount.isActive()).isTrue();
        assertThat(savedAccount.getBalance()).isEqualTo(1000);
        assertThat(savedAccount.getMaxOverdraft()).isEqualTo(500);
        assertThat(savedAccount.getOpeningDate()).isEqualTo(LocalDate.now());
        assertThat(savedAccount.getType()).isEqualTo("Corriente");

        // Log message
        logger.info("Account saved: " + savedAccount);
    }

    @Test
    public void findAll() {
        // given
        Account cuenta = new Account();
        cuenta.setActive(true);
        cuenta.setBalance(1000);
        cuenta.setMaxOverdraft(500);
        cuenta.setOpeningDate(LocalDate.now());
        cuenta.setType("Corriente");
        accountRepository.save(cuenta);

        // when
        List<Account> cuentasList = accountRepository.findAll();

        // then
        assertThat(cuentasList).isNotNull();
        assertThat(cuentasList.size()).isGreaterThan(0);

        // Log message
        logger.info("Lista cuentas: " + cuentasList);
    }
}
