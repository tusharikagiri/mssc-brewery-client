package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.BeerStyleEnum;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());

		assertNotNull(dto);
	}

	@Test
	void testSaveBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("Test").beerStyle(BeerStyleEnum.IPA).build();

		URI uri = client.saveBeer(beerDto);

		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("Test").beerStyle(BeerStyleEnum.PILSNER).build();
		client.updateBeer(UUID.randomUUID(), beerDto);

	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
	@Test
	void testGetCustomerById() {
		CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDto);
	}

	@Test
	void testSaveCustomer() {
		CustomerDto customerDto = CustomerDto.builder().build();
		
		URI uri = client.saveCustomer(customerDto);
		
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("John Doe").build();
		
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
}
