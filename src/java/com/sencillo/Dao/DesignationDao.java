package com.sencillo.dao;

import java.util.List;
import com.sencillo.model.Designation;

public interface DesignationDao
{
	public void addDesignation(Designation d);
        public void updateDesignation(Designation d);
        public List<Designation> listDesignation();
        public Designation getDesignationById(int id);
        public void deleteDesignation(int id);
}