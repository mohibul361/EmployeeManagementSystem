package com.sencillo.service;

import com.sencillo.model.Designation;
import java.util.List;

public interface DesignationService
{
	public void addDesignation(Designation d);
        public void updateDesignation(Designation d);
        public List<Designation> listDesignation();
        public Designation getDesignationById(int id);
        public void deleteDesignation(int id);
}
