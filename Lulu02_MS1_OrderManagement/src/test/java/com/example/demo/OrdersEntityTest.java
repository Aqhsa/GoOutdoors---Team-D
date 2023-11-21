package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.orders.management.entity.OrdersEntity;
import com.orders.management.entity.PaymentsEntity;
import com.orders.management.repository.PaymentsRepo;

	public class OrdersEntityTest {

	    
	    @Test
	    public void testCreateOrder() {
	        OrdersEntity ordersEntity = new OrdersEntity();
	        ordersEntity.setOrderid(1);
	        ordersEntity.setDate("2023-01-01");

	        // Save the entity to a repository or service
	        // Perform the create operation

	        assertNotNull(ordersEntity); // Ensure the entity is not null
	        assertEquals(1, ordersEntity.getOrderid());
	        assertEquals("2023-01-01", ordersEntity.getDate());

	        // Additional assertions if needed
	    }
	    
	   

	        @Test
	        public void testReadOrder() {
	            // Retrieve an existing entity from a repository or service
	            OrdersEntity ordersEntity = getEntityFromRepository(); // Replace with actual retrieval

	            assertNotNull(ordersEntity); // Ensure the entity is not null
	            assertEquals(1, ordersEntity.getOrderid());
	            assertEquals("2023-01-01", ordersEntity.getDate());

	            // Additional assertions if needed
	        }

	        // Replace this method with actual retrieval logic
	        private OrdersEntity getEntityFromRepository() {
	            // Implement the logic to retrieve an entity
	        
	        	return new OrdersEntity(1, "2023-01-01");
	        
	        }
	      
	        
	        @Test
	            public void testDeleteOrder() {
	                // Retrieve an existing entity from a repository or service
	                OrdersEntity ordersEntity = getEntityFromRepository(); // Replace with actual retrieval

	                assertNotNull(ordersEntity); // Ensure the entity is not null

	                // Delete the entity from the repository or service
	                deleteEntityFromRepository(ordersEntity); // Replace with actual delete operation

	                // Try to retrieve the deleted entity
	            }

	            // Replace these methods with actual retrieval and delete logic
	            @SuppressWarnings("unused")
				private OrdersEntity getEntityFromRepository1() {
	                // Implement the logic to retrieve an entity
	                return new OrdersEntity(1, "2023-01-01");
	            }

	            private void deleteEntityFromRepository(OrdersEntity entity) {
	                // Implement the logic to delete an entity from the repository or service
	            }
	            
	            
	            
	            //payment
	            
	            @Test
	            public void testCreatePaymentInfo() {
	                PaymentsEntity paymentInfo = new PaymentsEntity();
	                paymentInfo.setInvoiceNo(1);
	                paymentInfo.setPaymentDate("2023-01-01");
	                paymentInfo.setPaymentStatus("Paid");

	                // Perform the create operation (e.g., save to a repository or service)

	                assertNotNull(paymentInfo); // Ensure the entity is not null
	                assertEquals(1, paymentInfo.getInvoiceNo());
	                assertEquals("2023-01-01", paymentInfo.getPaymentDate());
	                assertEquals("Paid", paymentInfo.getPaymentStatus());

	                // Additional assertions if needed
	         
	            }
	            
	            
	            
	            
	            
	            
	            @Test
	            public void testReadPaymentInfo() {
	                // Create a mock repository
	                PaymentsRepo mockRepository = mock(PaymentsRepo.class);

	                // Define the expected behavior when retrieving an entity
	                PaymentsEntity expectedPaymentInfo = new PaymentsEntity();
	                expectedPaymentInfo.setInvoiceNo(1);
	                expectedPaymentInfo.setPaymentDate("2023-01-01");
	                expectedPaymentInfo.setPaymentStatus("Paid");
	                when(mockRepository.findById(1)).thenReturn(Optional.of(expectedPaymentInfo));

	                // Retrieve an existing entity from the mock repository
	                PaymentsEntity paymentInfo = mockRepository.findById(1).orElse(null);

	                assertNotNull(paymentInfo); // Ensure the entity is not null
	                assertEquals(1, paymentInfo.getInvoiceNo());
	                assertEquals("2023-01-01", paymentInfo.getPaymentDate());
	                assertEquals("Paid", paymentInfo.getPaymentStatus());

	                // Additional assertions if needed
	            }

	 //           @Test
//	            public void testUpdatePaymentInfo() {
//	                // Create a mock repository
//	                PaymentInfoRepository mockRepository = mock(PaymentInfoRepository.class);
//
//	                // Define the expected behavior when retrieving an entity
//	                PaymentInfo expectedPaymentInfo = new PaymentInfo();
//	                expectedPaymentInfo.setInvoiceNo(1);
//	                expectedPaymentInfo.setPaymentDate("2023-01-01");
//	                expectedPaymentInfo.setPaymentStatus("Paid");
//	                when(mockRepository.findById(1)).thenReturn(Optional.of(expectedPaymentInfo));
//
//	                // Retrieve an existing entity from the mock repository
//	                PaymentInfo paymentInfo = mockRepository.findById(1).orElse(null);
//
//	                assertNotNull(paymentInfo); // Ensure the entity is not null
//	                assertEquals(1, paymentInfo.getInvoiceNo());
//	                assertEquals("2023-01-01", paymentInfo.getPaymentDate());
//	                assertEquals("Paid", paymentInfo.getPaymentStatus());
//
//	                // Modify the entity
//	                paymentInfo.setInvoiceNo(2);
//	                paymentInfo.setPaymentDate("2023-02-01");
//	                paymentInfo.setPaymentStatus("Unpaid");
//
//	                // Define the expected behavior when updating an entity
//	                when(mockRepository.save(any(PaymentInfo.class))).thenReturn(paymentInfo);
//
//	                // Call the update operation on your service or controller
//
//	                // Retrieve the updated entity
//	                PaymentInfo updatedPaymentInfo = mockRepository.findById(1).orElse(null);
//
//	                assertNotNull(updatedPaymentInfo); // Ensure the entity is not null
//	                assertEquals(2, updatedPaymentInfo.getInvoiceNo());
//	                assertEquals("2023-02-01", updatedPaymentInfo.getPaymentDate());
//	                assertEquals("Unpaid", updatedPaymentInfo.getPaymentStatus());
//
//	                // Additional assertions if needed
//	            }
//
//	            @Test
//	            public void testDeletePaymentInfo() {
//	                // Create a mock repository
//	                PaymentInfoRepository mockRepository = mock(PaymentInfoRepository.class);
//
//	                // Define the expected behavior when retrieving an entity
//	                PaymentInfo expectedPaymentInfo = new PaymentInfo();
//	                expectedPaymentInfo.setInvoiceNo(1);
//	                expectedPaymentInfo.setPaymentDate("2023-01-01");
//	                expectedPaymentInfo.setPaymentStatus("Paid");
//	                when(mockRepository.findById(1)).thenReturn(Optional.of(expectedPaymentInfo));
//
//	                // Retrieve an existing entity from the mock repository
//	                PaymentInfo paymentInfo = mockRepository.findById(1).orElse(null);
//
//	                assertNotNull(paymentInfo); // Ensure the entity is not null
//
//	                // Define the expected behavior when deleting an entity
//	                doNothing().when(mockRepository).delete(expectedPaymentInfo);
//
//	                // Call the delete operation on your service or controller
//
//	                // Try to retrieve the deleted entity
//	                PaymentInfo deletedPaymentInfo = mockRepository.findById(1).orElse(null);
//
//	                assertNull(deletedPaymentInfo); // Ensure the entity is null after deletion
//	            }
//	        }
//	      
	            
	            
	            
	            
	            
	            
	}
	        
	            
	            


	
	
	
	
	
	
	
	
	        
	        
	        
	       
	          
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
