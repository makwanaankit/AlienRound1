package com.alien.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien implements Comparable<Alien>
{
		@Id
		int aid;
		String alienName;
		int age;
		int marks;
		String city;
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public String getAlienName() {
			return alienName;
		}
		public void setAlienName(String alienName) {
			this.alienName = alienName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Alien() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Alien [aid=" + aid + ", alienName=" + alienName + ", age=" + age + ", marks=" + marks + ", city="
					+ city + "]";
		}
		public Alien(int aid, String alienName, int age, int marks, String city) {
			super();
			this.aid = aid;
			this.alienName = alienName;
			this.age = age;
			this.marks = marks;
			this.city = city;
		}
		public int compareTo(Alien o) {
			int compareMarks = ((Alien) o).getMarks(); 
			
			//ascending order
			return this.marks -compareMarks;

		}
		
		
		
}
