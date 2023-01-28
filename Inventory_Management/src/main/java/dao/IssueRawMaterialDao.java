package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.IssueRawMaterial;

@Component
public class IssueRawMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// inserting the data
	@Transactional // for making transaction with database like insert, delete, update
	public int insert(IssueRawMaterial issueRawMaterial) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(issueRawMaterial);
		return i;
	}

	// get the single data(object)
	public IssueRawMaterial getIssueRawMaterial(int issueRawMaterialId) {
		IssueRawMaterial issueRawMaterial = this.hibernateTemplate.get(IssueRawMaterial.class, issueRawMaterialId);
		return issueRawMaterial;
	}

	// get all issueRawMaterials(all rows)
	public List<IssueRawMaterial> getAllIssueRawMaterials() {
		List<IssueRawMaterial> issueRawMaterials = this.hibernateTemplate.loadAll(IssueRawMaterial.class);
		return issueRawMaterials;
	}

	// deleting the data
	@Transactional // for making transaction with database like insert, delete, update
	public void deleteIssueRawMaterial(int issueRawMaterialId) {
		IssueRawMaterial issueRawMaterial = this.hibernateTemplate.get(IssueRawMaterial.class, issueRawMaterialId);
		this.hibernateTemplate.delete(issueRawMaterial);
	}

	// updating data...
	@Transactional // for making transaction with database like insert, delete, update
	public void updateIssueRawMaterial(IssueRawMaterial issueRawMaterial) {
		this.hibernateTemplate.update(issueRawMaterial);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
