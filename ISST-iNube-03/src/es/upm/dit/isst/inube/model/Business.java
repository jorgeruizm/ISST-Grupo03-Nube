package es.upm.dit.isst.inube.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Business {

	@Id 
	private String merchant;
	private String zipCode;
	private String cnae;
	
	@OneToOne
	private User user;
	@OneToOne(mappedBy="business", fetch=FetchType.EAGER)
	private TPV tpv;
	
	public Business() {}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public TPV getTpv() {
		return tpv;
	}

	public void setTpv(TPV tpv) {
		this.tpv = tpv;
	}
	
}