/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparadores;

import Entidades.Person;
import java.util.Comparator;

/**
 *
 * @author tomyv
 */
public class Comparators {
    
    public static Comparator <Person> orderByName = new Comparator <Person> () {
        @Override
        public int compare(Person t, Person t1) {
            return t.getCompleteName().compareTo(t1.getCompleteName());
        }
    };
    
    public static Comparator <Person> orderByDni = new Comparator <Person>() {
        @Override
        public int compare(Person t, Person t1) {
            return t.getId().compareTo(t1.getId());
        }
    };
    
}
