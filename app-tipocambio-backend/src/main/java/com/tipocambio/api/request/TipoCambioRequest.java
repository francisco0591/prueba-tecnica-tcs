package com.tipocambio.api.request;

import java.io.Serializable;

public class TipoCambioRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float monto;
	private String moneda_origen;
	private String moneda_destino;
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getMoneda_origen() {
		return moneda_origen;
	}
	public void setMoneda_origen(String moneda_origen) {
		this.moneda_origen = moneda_origen;
	}
	public String getMoneda_destino() {
		return moneda_destino;
	}
	public void setMoneda_destino(String moneda_destino) {
		this.moneda_destino = moneda_destino;
	}
	
	
}
