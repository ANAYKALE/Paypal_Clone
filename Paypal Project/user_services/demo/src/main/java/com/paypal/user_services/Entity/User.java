package com.paypal.user_services.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table (name="app_user")
@NoArgsConstructor
public class User{


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;

 public String getRole() {
  return role;
 }

 public void setRole(String role) {
  this.role = role;
 }

 @Column(unique = true)
 private String email;
 private String password;

 private String role;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public User(Long id) {
  this.id = id;
 }


 public void setId(Long id){
  this.id=id;
 }

 public Long getId(){
  return id;
 }
 }