package com.tom.ssm.spring5.chapter0705.impl;

import com.tom.ssm.spring5.chapter0705.Axe;
import com.tom.ssm.spring5.chapter0705.Person;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/5 下午 02:33
 * @version: 1.0
 */
public class Chinese implements Person {
    private List<String> schools;
    private Map scores;
    private Map<String, Axe> phaseAxes;
    private Properties health;
    private Set axes;
    private String[] books;
    public Chinese(){
        System.out.println("Spring實例化主調: Chinese實例...");
    }
    public void setSchools(List schools){
        this.schools =schools;
    }
    public void setScores(Map scores){
        this.scores = scores;
    }

    public void setPhaseAxes(Map<String, Axe> phaseAxes) {
        this.phaseAxes = phaseAxes;
    }
    public void setHealth(Properties health){
        this.health = health;
    }
    public void setAxes(Set axes){
        this.axes = axes;
    }
    public void setBooks(String[] books){
        this.books = books;
    }
    @Override
    public void test() {
        System.out.println(schools);
        System.out.println(scores);
        System.out.println(phaseAxes);
        System.out.println(health);
        System.out.println(axes);
        System.out.println(java.util.Arrays.toString(books));
    }
}
