package com.sencillo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sencillo.dao.HolidayDao;
import com.sencillo.model.Holiday;

@Service
@Transactional
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayDao holidayDao;

         public void setHolidayDao(HolidayDao holidayDao) {
		this.holidayDao = holidayDao;
	}
        
        @Override
	@Transactional
	public void updateHoliday(Holiday h) {
		this.holidayDao.updateHoliday(h);
	}
        
        @Override
	@Transactional
	public List<Holiday> listHoliday() {
		return this.holidayDao.listHoliday();
	}

        @Override
        @Transactional
        public List<Holiday> listEmployeeHoliday() {
                return this.holidayDao.listEmployeeHoliday();
        }
        
        @Override
	@Transactional
	public void addHoliday(Holiday h) {
		this.holidayDao.addHoliday(h);
	}
        
	@Override
	@Transactional
	public Holiday getHolidayById(int id) {
		return this.holidayDao.getHolidayById(id);
        }
        
        @Override
	@Transactional
	public void deleteHoliday(int id) {
		this.holidayDao.deleteHoliday(id);
	}
        

}