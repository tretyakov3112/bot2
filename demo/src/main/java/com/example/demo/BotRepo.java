package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface BotRepo extends MongoRepository<Bot, BigInteger> {
}
