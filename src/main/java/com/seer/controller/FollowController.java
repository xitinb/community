package com.seer.controller;

import com.seer.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 添加关注
     * @param userId
     * @param followerId
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<Boolean> followOne(@RequestParam(value = "userId")String userId,
                                             @RequestParam(value = "followerId")String followerId){
        int i = followService.followOneByUserId(userId,followerId);
        boolean msg ;
        if(i == 0){
            msg = false;
        }else {
            msg = true;
        }
        return ResponseEntity.ok(msg);

    }

    /**
     * 取消关注
     * @param userId
     * @param followerId
     * @return
     */
    @GetMapping("cancel")
    public ResponseEntity<Boolean> unfollowOne(@RequestParam(value = "userId",required = true)String userId,
                                               @RequestParam(value = "followerId",required = true)String followerId){

        int i = followService.unfollowOneByUserId(userId, followerId);
        boolean msg ;
        if(i == 0){
            msg = false;
        }else {
            msg = true;
        }
        return ResponseEntity.ok(msg);
    }

    /**
     * 检查是否关注 0代表没有， 1代表已经关注
     * @param userId
     * @param followerId
     * @return
     */
    @GetMapping("check")
    public ResponseEntity<Boolean> checkOne(@RequestParam(value = "userId")String userId,
                                             @RequestParam(value = "followerId")String followerId){
        int i = followService.checkOne(userId,followerId);
        boolean msg ;
        if(i == 0){
            msg = false;
        }else {
            msg = true;
        }
        return ResponseEntity.ok(msg);
    }


//
//    @GetMapping("")

}
