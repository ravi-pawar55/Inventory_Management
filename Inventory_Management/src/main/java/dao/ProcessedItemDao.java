package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.ProcessedItem;

@Component
public class ProcessedItemDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// inserting the data
	@Transactional // for making transaction with database like insert, delete, update
	public int insert(ProcessedItem processedItem) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(processedItem);
		return i;
	}

	// get the single data(object)
	public ProcessedItem getProcessedItem(int processedItemId) {
		ProcessedItem processedItem = this.hibernateTemplate.get(ProcessedItem.class, processedItemId);
		return processedItem;
	}

	// get all processedItems(all rows)
	public List<ProcessedItem> getAllProcessedItems() {
		List<ProcessedItem> processedItems = this.hibernateTemplate.loadAll(ProcessedItem.class);
		return processedItems;
	}

	// deleting the data
	@Transactional // for making transaction with database like insert, delete, update
	public void deleteProcessedItem(int processedItemId) {
		ProcessedItem processedItem = this.hibernateTemplate.get(ProcessedItem.class, processedItemId);
		this.hibernateTemplate.delete(processedItem);
	}

	// updating data...
	@Transactional // for making transaction with database like insert, delete, update
	public void updateProcessedItem(ProcessedItem processedItem) {
		this.hibernateTemplate.update(processedItem);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
