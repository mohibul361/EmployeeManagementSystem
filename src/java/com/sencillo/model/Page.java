package com.sencillo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "page")
public class Page
{
	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String url;
	
	@Column(name = "page_order")
	private int pageOrder;

	@ManyToOne
	@JoinColumn(name = "parent_page_id")
	private Page parentPage;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Page getParentPage()
	{
		return parentPage;
	}

	public int getPageOrder()
	{
		return pageOrder;
	}

	public void setPageOrder(int pageOrder)
	{
		this.pageOrder = pageOrder;
	}

	public void setParentPage(Page parentPage)
	{
		this.parentPage = parentPage;
	}



	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

        @Override
	public String toString()
	{
            return "Page [id=" + id + ", name=" + name + ", url=" + url + ", parentPage=" +parentPage +"]";
	}
}
