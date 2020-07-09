package com.fms.controller;

import com.fms.pojo.Room;
import com.fms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    //查询所有课室
    @GetMapping("/findAllRoom")
    public @ResponseBody List<Room> findAllRoom() {
        return roomService.findAll();
    }
    //查询所有空闲课室0为空闲，1为已占用
    @GetMapping("findRoomByStatus")
    public List<Room> findRoomByStatus(){
        return roomService.findByStatus();
    }
    @GetMapping("/findRoomById")
    public Room findRoom(Integer id) {
        return roomService.findById(id);
    }

    @GetMapping("/updateRoom")
    public void updateRoom(Room room) {
        roomService.update(room);
    }

    @GetMapping("/deleteRoom")
    public void deleteRoom(Integer id) {
        roomService.delete(id);
    }

    @GetMapping("/addRoom")
    public void findRoom(Room room) {
        roomService.add(room);
    }
}

