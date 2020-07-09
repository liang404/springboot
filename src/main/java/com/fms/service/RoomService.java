package com.fms.service;

import com.fms.pojo.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(Integer id);
    List<Room> findByStatus();
    void update(Room room);
    void delete(Integer id);
    void add(Room room);
}
