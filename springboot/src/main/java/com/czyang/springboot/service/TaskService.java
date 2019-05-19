package com.czyang.springboot.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.czyang.springboot.entity.Task;

@Service
public class TaskService {

	private static ArrayList<Task> taskList = new ArrayList<Task>();

	static {
		Task task = new Task();
		task.setId(1);
		task.setContent("Restful API homework 1");
		task.setCreatedTime("2019-05-15T00:00:00Z");

		Task task2 = new Task();
		task2.setId(2);
		task2.setContent("Restful API homework 2");
		task2.setCreatedTime("2019-05-15T00:00:00Z");

		taskList.add(task);
		taskList.add(task2);
	}

	public String GetTaskList() {
		return JSON.toJSONString(taskList);
	}

	public String GetTaskById(String id) {
		Task task = taskList.get(1 + Integer.parseInt(id));
		return JSON.toJSONString(task);
	}

	public String add(Task task) {
		taskList.add(task);
		return JSON.toJSONString("OK");
	}
	
	public String delete(String id) {
		taskList.remove(1 + Integer.parseInt(id));
		return JSON.toJSONString("OK");
	}
}
