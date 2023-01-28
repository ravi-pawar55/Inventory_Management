package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "issue_raw_material")
@Component
public class IssueRawMaterial {

	@Id
	private int id;
	private String name;
	private int quantity;
	private String issuer_name;
	private int itemId;
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIssuer_name() {
		return issuer_name;
	}

	public void setIssuer_name(String issuer_name) {
		this.issuer_name = issuer_name;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IssueRawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssueRawMaterial(int id, String name, int quantity, String issuer_name, int itemId, String date) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.issuer_name = issuer_name;
		this.itemId = itemId;
		this.date = date;
	}

	@Override
	public String toString() {
		return "IssueRawMaterial [id=" + id + ", name=" + name + ", quantity=" + quantity + ", issuer_name="
				+ issuer_name + ", itemId=" + itemId + ", date=" + date + "]";
	}

}
