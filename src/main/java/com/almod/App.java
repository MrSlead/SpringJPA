package com.almod;

import com.almod.dao.CityDAO;
import com.almod.entity.Author;
import com.almod.entity.City;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        CityDAO cityDAO = (CityDAO) ctx.getBean("cityDAO");

        List<City> cities = cityDAO.findAll2();

        for(City c : cities){
            System.out.println(c);
        }
    }
}
