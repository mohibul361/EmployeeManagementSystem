package com.sencillo.dao;

import java.util.List;

import com.sencillo.model.Holiday;

public interface HolidayDao
{
	public void addHoliday(Holiday h);
        public void updateHoliday(Holiday h);
        public List<Holiday> listHoliday();
        public List<Holiday> listEmployeeHoliday();
        public Holiday getHolidayById(int id);
        public void deleteHoliday(int id);
}

