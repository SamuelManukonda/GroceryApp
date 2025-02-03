//package com.grocery.app.model;
//
//import jakarta.persistence.*;
//
//
//@Entity
//@DiscriminatorValue("ADMIN")
//public class Admin extends User {
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "admin_id", referencedColumnName = "user_id", nullable = false)
//    private User user;
//
//    public Admin(User user) {
//        this.user = user;
//    }
//
//    public Admin() {}
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//}
