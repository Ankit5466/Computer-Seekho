package com.Project.Services;

import java.util.List;

import com.Project.Entities.GetInTouch;

public interface GetInTouchService {
    void save(GetInTouch getInTouch);
    List<GetInTouch> getAll();
    void deleteById(int getInTouchId);
}
