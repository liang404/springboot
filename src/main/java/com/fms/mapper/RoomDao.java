package com.fms.mapper;

import com.fms.pojo.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoomDao {
        //查询所有课室
     List<Room> findAll();
     //通过id查相应课室
    Room findById(Integer id);
    //通过status查空闲课室
    List<Room> findByStatus();
    //通过id删除课室
    void deleteByRoomId(Integer id);
    //修改课室信息
    void update(Room room);
    //添加课室信息
    void add(Room room);
}
