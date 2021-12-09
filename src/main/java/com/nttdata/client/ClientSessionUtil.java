package com.nttdata.client;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientSessionUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (final Throwable e) {
			System.err.println("[ERROR] Ha ocurrido un error en la configuración - HIBERNATE" + e);
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}