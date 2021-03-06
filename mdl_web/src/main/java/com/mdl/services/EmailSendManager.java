package com.mdl.services;

import javax.mail.MessagingException;

import com.mdl.model.SimpleEmail;

public interface EmailSendManager {
	/**
	 * 发送简单邮件
	 * @param simpleEmail 简单邮件详情
	 * @throws MessagingException 
	 */
	public void sendEmail(SimpleEmail simpleEmail) throws MessagingException;
}
