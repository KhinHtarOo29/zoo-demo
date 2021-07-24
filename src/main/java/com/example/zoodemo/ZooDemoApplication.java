package com.example.zoodemo;

import com.example.zoodemo.services.ZooService;
import com.example.zoodemo.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZooDemoApplication implements CommandLineRunner {

    @Autowired
    private ZooService zooService;

    public static void main(String[] args) {
        SpringApplication.run(ZooDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        zooService.saveData();

        JPAUtil.checkData("select * from Cage");
        JPAUtil.checkData("select * from Animal");
        JPAUtil.checkData("select * from Supplier");
        JPAUtil.checkData("select * from Food_Item");
        JPAUtil.checkData("select * from Category");
        JPAUtil.checkData("select * from Animal_Food_Item");
    }
}
