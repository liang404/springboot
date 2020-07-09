package com.fms.service.Impl;

import com.fms.mapper.RoomDao;
import com.fms.pojo.Room;
import com.fms.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;
    @Override
    public List<Room> findAll() {
        return this.roomDao.findAll();
    }

    @Override
    public Room findById(Integer id) {
        return roomDao.findById(id);
    }

    @Override
    public List<Room> findByStatus() {
        return roomDao.findByStatus();
    }

    @Override
    public void update(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(Integer id) {
        roomDao.deleteByRoomId(id);
    }

    @Override
    public void add(Room room) {
        roomDao.add(room);
    }
}
