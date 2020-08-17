package com.almod.dao;

import com.almod.entity.Author;
import com.almod.entity.City;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CityDAO implements BaseDAO<City> {
    @PersistenceContext
    private EntityManager emf;

    private DataSource dataSource;

    public List<City> findAll() {
        List<City> list = emf.createQuery("from city").getResultList();
        return list;
    }

    public List<City> findAll2() throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM city limit 10");

        List<City> cities = new ArrayList<>();
        while(resultSet.next()){
            cities.add(new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("population")));
        }
        return cities;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
