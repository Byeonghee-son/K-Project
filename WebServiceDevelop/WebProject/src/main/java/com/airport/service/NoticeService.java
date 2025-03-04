package com.airport.service;

import java.util.List;

import com.airport.domain.Notice;

public interface NoticeService {
	
	List<Notice> notice();	
	Notice getNotice(Notice notice);
	void insertNotice(Notice notice);
	void updateNotice(Notice notice);
	void deleteNotice(Notice notice);

}
