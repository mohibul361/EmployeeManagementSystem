package com.sencillo.service;

import java.util.List;

import com.sencillo.model.Holiday;

public interface HolidayService
{
	public void addHoliday(Holiday h);
        public void updateHoliday(Holiday h);
        public List<Holiday> listHoliday();
        public List<Holiday> listEmployeeHoliday();
        public Holiday getHolidayById(int id);
        public void deleteHoliday(int id);
}

