package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(value = "/")
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

  private final UserRepository userRepository;

  public UserController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
  public List<User> getAllUsers() {
    LOG.info("Getting all users.");
    return userRepository.findAll();
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public User addNewUsers(@RequestBody final User user) {
    LOG.info("Saving user.");
    return userRepository.save(user);
  }
}
