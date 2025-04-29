package com.vasanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


//for fetching and caching
//public class Main {
//    public static void main(String[] args) {
//
//        Address a1 = new Address();
//        a1.setAid(1);
//        a1.setNum(100);
//        a1.setStreet("Nemilicherry");
//        a1.setArea("Chromepet");
//
//        Address a2 = new Address();
//        a2.setAid(2);
//        a2.setNum(19);
//        a2.setStreet("Mainroad");
//        a2.setArea("Chromepet");
//
//        Address a3 = new Address();
//        a3.setAid(3);
//        a3.setNum(69);
//        a3.setStreet("dasanroad");
//        a3.setArea("Chitlapakkam");
//
//        Player p1 = new Player();
//        p1.setPid(101);
//        p1.setPname("vas");
//        p1.setPosition("forward");
//
//        Player p2 = new Player();
//        p2.setPid(102);
//        p2.setPname("pras");
//        p2.setPosition("winger");
//
//        p1.setAddresses(Arrays.asList(a1,a2));
//        p2.setAddresses(Arrays.asList(a3));
//
//
//        SessionFactory sf = new Configuration()
//                .addAnnotatedClass(com.vasanth.Player.class)
//                .addAnnotatedClass(com.vasanth.Address.class)
//                .configure()
//                .buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);
//        session.persist(p1);
//        session.persist(p2);
//
//        transaction.commit();
//
//        session.close();
//
//        Session session1 = sf.openSession();
//        //if you do the get method in same session as persist it won't file the select query because of cache memory
//        //instead of using select it will get the data from the same session where we have persist
//        // doing the get in different session ie session1 because it will fire a select query beacause
//        // of cache memory there is no data in second session which is because of level1 cache which is default in hibernate
//        //in level 1 cache diff session have diff memory
//        Player p5 = session1.get(Player.class,101);
//        //above line will only fetch player and not its relation table address beacause of lvl1 cache. this is called lazy fetch
//        System.out.println(p5);
//        //print if you want all deets it will fetch all deets
//
//        //after changing the fetchtype to eager (laxy fetch is default)
//        Player p5 = session1.get(Player.class,101);
//
//        sf.close();
//
//    }
//}

    //for HQL practice
    //first add data

//Address a1 = new Address();
//        a1.setAid(4);
//        a1.setNum(32);
//        a1.setStreet("postofficeroad");
//        a1.setArea("Guindy");
//
//Transaction transaction = session.beginTransaction();
//        session.persist(a1);
//        transaction.commit();

//public class Main {
//    public static void main(String[] args) {
//
//        SessionFactory sf = new Configuration()
//                .addAnnotatedClass(com.vasanth.Address.class)
//                .configure()
//                .buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        //this is normal way of getting data from SQL
//        Address a1 = session.get(Address.class,4);
//        System.out.println(a1);
//
//        //Using HQL
//        //eg select * from address where num = 32;
//        //from Address where num = 32;
//        //using hql to fetch data
//
//        Query query = session.createQuery("from Address where num = 32");
//        List<Address> addresses = query.getResultList();
//
//        //using HQL to fetch data with filter and specific properties
//
//        String street = "Nemilicherry";
//
//        //QUERIES to select all data and a single col from table using list of address
//        //second query uses list address fully when you only select area name in second but store all details of address in list
//        Query query = session.createQuery("from Address where street like ?1");
//        Query query = session.createQuery("select area from Address where street like ?1");
//        query.setParameter(1,street);
//        List<Address> addresses = query.getResultList();
//
//
//        //third query to store data with less space
//        Query query = session.createQuery("select area,street from Address where street like ?1");
//        query.setParameter(1,street);
//        List<Object[]> addresses = query.getResultList();
//
//        for(Object[] obj: addresses)
//        {
//            System.out.println((String) obj[0] + " " + (String)obj[1]);
//        }
//
//        System.out.println(addresses);
//
//
//        session.close();
//        sf.close();
//
//    }
//}


public class Main {
      public static void main(String[] args) {

          //get vs load
          // get will fire a query even if we dont print data.  this is Eager load
          //Address address = session.get(Address.class,2);

          //load will not execute a query unless we print the fetched data.  this is lazy load
          //Address address = session.load(Address.class,2);
          //since load is deprecated use these
//          Address address = session.byId(Address.class).getReference(2);
//          System.out.println(address);


          SessionFactory sf = new Configuration()
                  .addAnnotatedClass(com.vasanth.Address.class)
                  .configure()
                  .buildSessionFactory();

          //level 1 cache, default, lazy load ----- same session 2 query same get requests it uses cache
          //level 2cache eager load ----- different session 2queries same get request of data, uses ehcahe library

          Session session = sf.openSession();
          Address a1 = session.get(Address.class,2);
          System.out.println(a1);
          session.close();

          Session session1 = sf.openSession();
          Address a2 = session1.get(Address.class,2);
          System.out.println(a2);
          session1.close();


          sf.close();


  }
}

