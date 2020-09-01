package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

public class AppSpringXML {
	  public static void main(String[] args) {
	 
		// Création du contexte Spring
		  try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext  ("application-config-fichier.xml");) {
			  
			  Menu menu = context.getBean(Menu.class);
			  menu.afficher();
		  } // ici , en faisant ce try, on appelle autoclosable donc inutile de fermer les ressources 
		  
	  }
	  
	}