package com.tipocambio.api.app_tipocambio_backend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tipocambio.api.client.TipoCambioClient;

import junit.framework.Assert;

@SpringBootTest
class TipocambioTests {

	@Autowired
	private TipoCambioClient tipoCambioClient;
	
	@Test
	public void cambioTipoCambio() {
//		final List posts = tipoCambioClient.getAll();
//		assertNotNull(posts);
//		assertFalse(posts.isEmpty());
	}

}
