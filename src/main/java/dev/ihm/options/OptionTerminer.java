package dev.ihm.options;

import org.springframework.stereotype.Controller;

import dev.exception.PlatException;

@Controller
public class OptionTerminer implements IOptionMenu {
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Aurevoir");
    }
    
    public int getPoids() {
		return 3; // On veut l'afficher en 3e dans le menu
	}
}
