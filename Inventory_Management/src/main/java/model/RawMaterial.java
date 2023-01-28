package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "raw_material")
@Component
public class RawMaterial {

	@Id
	private int id;
	private String name;
	private int quantity;
	private String unit;
	private int cpu;

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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public RawMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RawMaterial(int id, String name, int quantity, String unit, int cpu) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "RawMaterial [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", cpu=" + cpu
				+ "]";
	}

}
