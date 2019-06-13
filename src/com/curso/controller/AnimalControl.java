package com.curso.controller;

import java.util.ArrayList;
import java.util.List;

import com.curso.entity.Animal;

public class AnimalControl {
		
	private List<Animal> animals = new ArrayList<>();

	public void adicionar(Animal a) {
		
	}
	public Animal pesquisarPorNome(String nome) {
		Animal a = new Animal();
		return a;
	}
	
	public List<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
}
