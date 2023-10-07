//package com.company.account.controller;
//
//import com.company.account.dto.AccountDTOConverter;
//import com.company.account.dto.CreateAccountRequest;
//import com.company.account.model.Customer;
//import com.company.account.repository.AccountRepository;
//import com.company.account.repository.CustomerRepository;
//import com.company.account.service.AccountService;
//import com.company.account.service.CustomerService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.math.BigDecimal;
//import java.time.Clock;
//import java.util.UUID;
//import java.util.function.Supplier;
//
//
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
//        "server-port=0",
//        "command.line.runner.enabled=false"
//})
//@RunWith(SpringRunner.class)
//@DirtiesContext
//public class AccountControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private Clock clock;
//
//    @MockBean
//    private Supplier<UUID> uuidSupplier;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private AccountDTOConverter converter;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private AccountService service = new AccountService(accountRepository, customerService, converter);
//    private ObjectMapper mapper = new ObjectMapper();
//
//    private static final UUID uuid = UUID.randomUUID();
//
//    @BeforeEach
//    public void setup() {
//        mapper.registerModule(new JavaTimeModule());
//        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
//    }
//
//    @Test
//    public void testCreateAccount_whenCustomerIdExists_shouldCreateAccountAndReturnAccountDTO() {
//        Customer customer = customerRepository.save(new Customer("Leyla", "Abbasova"));
//        CreateAccountRequest request = new CreateAccountRequest(customer.getId(), new BigDecimal(100));
//
//        this.mockMvc.perform(post())
//
//
//
//
//    }
//
//}