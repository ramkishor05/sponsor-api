package org.sponsor.account.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_WALLET")
public class EOMegaDraw extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Column(name = "BALANCE")
	private Double balance;
    
}
