package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.Job;

public interface JobDAO {
	public boolean saveOrUpdate(Job job);
	public boolean delete(Job job);
    public List<Job> list();
}

