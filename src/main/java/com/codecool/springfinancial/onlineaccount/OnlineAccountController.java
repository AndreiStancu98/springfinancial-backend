package com.codecool.springfinancial.onlineaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OnlineAccountController {
    private final OnlineAccountService onlineAccountService;
    @Autowired
    public OnlineAccountController(OnlineAccountService onlineAccountService){
        this.onlineAccountService = onlineAccountService;
    }

    @PostMapping("api/user/new-user")
    public void registerNewUser(@RequestBody OnlineAccount onlineAccount){
        onlineAccountService.addNewUser(onlineAccount);
    }
    @DeleteMapping("api/user/delete/pid={pid}")
    public void deleteUser(@PathVariable("pid") String pid){
        onlineAccountService.deleteUser(pid);
    }


    @GetMapping("api/user")
    public List<OnlineAccount> getAll(){
        return onlineAccountService.getAllUsers();
    }

    @PutMapping(path = "api/user/update/pid={pid}")
    public void updateCustomer(
            @PathVariable("pid") String pid,
            @RequestParam(required = false) String password) {
        onlineAccountService.updateUser(pid, password);
    }
}