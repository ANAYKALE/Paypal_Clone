package com.paypal.reward_service.controller;

import com.paypal.reward_service.entity.Reward;
import org.springframework.web.bind.annotation.*;
import com.paypal.reward_service.repository.RewardRepository;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardRepository rewardRepository;


    @PostMapping
    public void init() {
        System.out.println("✅ RewardConsumer Bean Loaded");
    }
    public RewardController(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @GetMapping
    public List<Reward> getAllRewards(){
        return rewardRepository.findAll();
    }
    @GetMapping("/user/{userId}")
    public List<Reward> getRewardsByUserId(@PathVariable Long userId){
        return rewardRepository.findByUserId(userId);
    }
}
