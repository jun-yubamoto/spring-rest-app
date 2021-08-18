package com.example.ybmt.jun.spring.web.springoas.service;

import javax.inject.Inject;

import com.example.ybmt.jun.orm.mbg.mapper.sample.UsersMapper;
import com.example.ybmt.jun.orm.mbg.model.sample.Users;
import com.example.ybmt.jun.spring.web.springoas.message.SpringOASLogger;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {

	private static final SpringOASLogger log = Logger.getMessageLogger(SpringOASLogger.class, UsersService.class.getName());

	private final UsersMapper usersMapper;

	@Inject
	public UsersService(UsersMapper usersMapper){
		this.usersMapper = usersMapper;
	}

	public Users findById(String id) throws IllegalArgumentException, Exception {
		try {
			Integer userId = Integer.parseInt(id);
			return usersMapper.selectByPrimaryKey(userId);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

}