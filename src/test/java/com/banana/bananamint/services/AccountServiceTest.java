package com.banana.bananamint.services;

import com.banana.bananamint.domain.Account;
import com.banana.bananamint.domain.Customer;
import com.banana.bananamint.exception.AccountException;
import com.banana.bananamint.persistence.AccountRepositoryData;
import com.banana.bananamint.persistence.CustomerRepositoryData;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountRepositoryData accountRepository;

    @Autowired
    private CustomerRepositoryData customerRepository;

    @Autowired
    private AccountService accountService;

    private static final Logger logger = Logger.getLogger(AccountServiceTest.class.getName());

    @Test
    public void testOpenAccount() throws AccountException {
        // Crear un cliente de ejemplo
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setBirthDate(LocalDate.of(1990, 1, 1));
        customer.setDni("12345678W");

        // Guardar el cliente en la base de datos
        customerRepository.save(customer);

        // Crear una cuenta de ejemplo
        Account account = new Account();
        account.setActive(true);
        account.setBalance(1000);
        account.setMaxOverdraft(500);
        account.setOpeningDate(LocalDate.now());
        account.setType("Corriente");
        account.setOwner(customer);

        // Guardar la cuenta en la base de datos
        Account savedAccount = accountRepository.save(account);

        // Verificar que la cuenta se haya guardado correctamente
        assertNotNull(savedAccount.getId());
        assertThat(savedAccount.isActive()).isTrue();
        assertThat(savedAccount.getBalance()).isEqualTo(1000);
        assertThat(savedAccount.getMaxOverdraft()).isEqualTo(500);
        assertThat(savedAccount.getOpeningDate()).isEqualTo(LocalDate.now());
        assertThat(savedAccount.getType()).isEqualTo("Corriente");
        assertThat(savedAccount.getOwner()).isEqualTo(customer);

        logger.info("La cuenta se ha abierto para el cliente: " + customer.getId());
    }

    @Test
    public void testShowAllAccounts() {
        // Crear un cliente de ejemplo
        Customer customer = new Customer();
        customer.setName("Jane Smith");
        customer.setEmail("jane.smith@example.com");
        customer.setBirthDate(LocalDate.of(1985, 5, 15));
        customer.setDni("87654321W");

        // Guardar el cliente en la base de datos
        customerRepository.save(customer);

        // Crear cuentas de ejemplo
        Account account1 = new Account();
        account1.setActive(true);
        account1.setBalance(2000);
        account1.setMaxOverdraft(1000);
        account1.setOpeningDate(LocalDate.now());
        account1.setType("Ahorro");
        account1.setOwner(customer);

        Account account2 = new Account();
        account2.setActive(true);
        account2.setBalance(3000);
        account2.setMaxOverdraft(1500);
        account2.setOpeningDate(LocalDate.now());
        account2.setType("Corriente");
        account2.setOwner(customer);

        // Guardar las cuentas en la base de datos
        accountRepository.save(account1);
        accountRepository.save(account2);

        // Obtener todas las cuentas del cliente
        List<Account> accounts = accountRepository.findByOwner(customer);

        // Verificar que se hayan recuperado las cuentas correctamente
        assertNotNull(accounts);
        assertThat(accounts.size()).isEqualTo(2);

        logger.info("Se han encontrado: " + accounts.size() + " cuentas para el cliente Id: " + customer.getId());
    }
}