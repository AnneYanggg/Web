package com.czyang.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czyang.springboot.entity.Task;
import com.czyang.springboot.service.TaskService;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getTaskList(){
		return taskService.GetTaskList();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getTaskById(@PathVariable("id") String id){
		return taskService.GetTaskById(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String getaddTask(Task task){
		return taskService.add(task);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String getaddTask(@PathVariable("id") String id){
		return taskService.delete(id);
	}
}
