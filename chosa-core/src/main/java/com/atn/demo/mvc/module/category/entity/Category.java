package com.atn.demo.mvc.module.category.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.atn.commons.entities.ModelObject;

@Entity
@Table(name = "APP_CATEGORY", uniqueConstraints = @UniqueConstraint(columnNames = "CATEGORY_ID"))
public class Category extends ModelObject<Long> {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private long categoryId;

	@Column(name = "CATEGORY_NAME")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_PARENT_ID_FK")
    private Category categoryParent;
	
	
   @OneToMany(mappedBy="categoryParent",fetch=FetchType.EAGER)
    private Set<Category> categories;
	
	
	


	
	
	
	
	
	public Category() {
		super();
	}

	public Category(long categoryId, String name, Category categoryParent,
			Set<Category> categories) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.categoryParent = categoryParent;
		this.categories = categories;
	}

	@Override
	public Long getId() {

		return getCategoryId();
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

}
